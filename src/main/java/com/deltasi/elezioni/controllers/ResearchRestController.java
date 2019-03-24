package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.PDeltaUrlAuthenticationSuccessHandler;
import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.contracts.IIscrittiService;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.json.AffluenzaJson;
import com.deltasi.elezioni.model.json.SezioneJson;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ResearchRestController {
    private static final Logger logger = LogManager.getLogger(ResearchRestController.class);

    @Autowired
    private Environment env;

    @Autowired
    IIscrittiService iscrittiService;

    @Autowired
    IAffluenzaService affluenzService;

    @PostMapping(value = "/search/sezione", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public SezioneJson researchSezione(@RequestBody @ModelAttribute("SezioneJson") SezioneJson sezione, BindingResult result) {
        Iscritti iscritti = new Iscritti();
        Map<String, String> errors = null;
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );

            sezione.setValidated(false);
            sezione.setErrorMessages(errors);
        }
        try {
            if (sezione.getSezione() == 0 || sezione.getSezione() == null) {
                sezione.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", "Sezione non può essere zero");
                sezione.setErrorMessages(errors);
            } else {
                if (sezione.getCabina() == 0 || sezione.getCabina() == null) {
                    sezione.setValidated(false);
                    errors = new HashMap<String, String>();
                    errors.put("Errore grave", "Cabina non può essere zero");
                    sezione.setErrorMessages(errors);
                }
                iscritti = iscrittiService.findIscrittiBySezione(sezione.getSezione());
                if (iscritti.getCabina().equals(sezione.getCabina())) {
                    sezione.setIscritti(iscritti);
                    sezione.setValidated(true);
                } else {
                    sezione.setValidated(false);
                    errors = new HashMap<String, String>();
                    errors.put("Errore grave", "Sezione cabina non congruenti");
                    sezione.setErrorMessages(errors);
                }
            }
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            sezione.setValidated(false);
            sezione.setErrorMessages(errors);
        }
        return sezione;
    }

    @PostMapping(value = "search/affluenza", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public AffluenzaJson researchAffluenza(@RequestBody @ModelAttribute("SezioneJson") SezioneJson sezione, BindingResult result) {
        AffluenzaJson json = new AffluenzaJson();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        Affluenza afp = affluenzService.findByNumerosezioneAndTipoelezioneId(sezione.getSezione(), tipoelezioneid);
        if (sezione.getTipo() == "2A" || sezione.getTipo() == "3A") {
            if (sezione.getTipo() == "2A") {
                json.setVotantifemmineaffp(afp.getVotantifemmine1());
                json.setVotantimaschiaffp(afp.getVotantimaschi1());
                json.setVotantitotaliaffp(afp.getVotantitotali1());
            }
            if (sezione.getTipo() == "3A") {
                json.setVotantifemmineaffp(afp.getVotantifemmine2());
                json.setVotantimaschiaffp(afp.getVotantimaschi2());
                json.setVotantitotaliaffp(afp.getVotantitotali2());
            }
        }
        json.setNumerosezione(sezione.getSezione());
        json.setTipo(sezione.getTipo());
        json.setIscrittimaschi(afp.getIscritti().getIscrittimaschi());
        json.setIscrittifemmine(afp.getIscritti().getIscrittifemmine());
        json.setIscrittitotali(afp.getIscritti().getIscrittitotali());
        json.setValidated(true);
        return json;
    }
}
