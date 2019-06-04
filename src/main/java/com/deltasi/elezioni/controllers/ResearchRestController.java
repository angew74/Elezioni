package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.helpers.PlessoLoader;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.UserSezione;
import com.deltasi.elezioni.model.json.*;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.risultati.Voti;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    IUserService userService;

    @Autowired
    IAffluenzaService affluenzeService;

    @Autowired
    IPlessoService plessoService;

    @Autowired
    BusinessRules businessRules;

    @Autowired
    PlessoLoader plessoLoader;

    @Autowired
    IUserSezioneService userSezioneService;


    @PostMapping(value = "/search/sezione", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public SezioneJson researchSezione(@RequestBody @ModelAttribute("SezioneJson") SezioneJson sezione, BindingResult result) {
        Iscritti iscritti = new Iscritti();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
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
                return sezione;
            }
            if (sezione.getCabina() == 0 || sezione.getCabina() == null) {
                sezione.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", "Cabina non può essere zero");
                sezione.setErrorMessages(errors);
                return sezione;
            }
            String msg = businessRules.IsInsertable(sezione.getSezione(), sezione.getTipo(),sezione.getCabina(), tipoelezioneid);
            if (msg.equals("")) {
                iscritti = iscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid, sezione.getSezione());
                if (iscritti.getCabina().equals(sezione.getCabina())) {
                    sezione.setIscritti(iscritti);
                    sezione.setValidated(true);
                } else {
                    sezione.setValidated(false);
                    errors = new HashMap<String, String>();
                    errors.put("Errore grave", "Sezione cabina non congruenti");
                    sezione.setErrorMessages(errors);
                    return sezione;
                }
            } else {
                sezione.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", msg);
                sezione.setErrorMessages(errors);
                return sezione;
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


    @PostMapping(value = "/search/plesso", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public PlessiWrapper researchPlesso(@RequestBody @ModelAttribute("PlessoJson") PlessoJson plesso, BindingResult result) {
        Iscritti iscritti = new Iscritti();
        Map<String, String> errors = null;
        plesso.setTipo("P");
        User user = new User();
        List<Plesso> pp = new ArrayList<Plesso>();
        List<PlessoJson> ppj = new ArrayList<PlessoJson>();
        PlessiWrapper plessiWrapper = new PlessiWrapper();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );

            plessiWrapper.setValidated(false);
            plessiWrapper.setErrorMessages(errors);
            return plessiWrapper;
        }
        try {

            if (plesso.getUtente() == null || StringUtils.isEmpty(plesso.getUtente())) {
                plessiWrapper.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", "Utente non può essere zero");
                plessiWrapper.setErrorMessages(errors);
                return plessiWrapper;
            }
            user = userService.getByUsername(plesso.getUtente());
            switch (plesso.getTipo())
            {
                case "U":
                    pp = plessoService.findByTipoelezioneIdAndUbicazioneLike(tipoelezioneid,plesso.getUbicazione());
                    break;
                case "D":
                    pp = plessoService.findByTipoelezioneIdAndDescrizioneLike(tipoelezioneid,plesso.getDescrizione());
                    break;
                case "P":
                   List<UserSezione> us = userSezioneService.findByTipoelezioneIdAndSezionePlessoId(tipoelezioneid, plesso.getNumero());
                    if(us != null && us.size() > 0 && plesso.getTipoRicerca().equals("I")) {
                        plessiWrapper.setValidated(false);
                        errors = new HashMap<String, String>();
                        errors.put("Errore grave", "Sezione già assegnata utilizzare funzione modifica");
                        plessiWrapper.setErrorMessages(errors);
                        return plessiWrapper;
                    }
                    if(us.size() == 0 && plesso.getTipoRicerca().equals("M")) {
                        plessiWrapper.setValidated(false);
                        errors = new HashMap<String, String>();
                        errors.put("Errore grave", "Sezione non assegnata utilizzare funzione inserimento");
                        plessiWrapper.setErrorMessages(errors);
                        return plessiWrapper;
                    }
                    if((us.size() != 0 && plesso.getTipoRicerca().equals("M")) && !(us.get(0).getUser().getUsername().equals(plesso.getUtente()))) {
                        plessiWrapper.setValidated(false);
                        errors = new HashMap<String, String>();
                        errors.put("Errore grave", "Sezione non assegnata all'utente richiesto");
                        plessiWrapper.setErrorMessages(errors);
                        return plessiWrapper;
                    }
                    else if(plesso.getTipoRicerca().equals("I") || plesso.getTipoRicerca().equals("M")){
                        pp.add(plessoService.findById(plesso.getNumero()));
                        ppj = plessoLoader.convert(pp);
                        plessiWrapper.setPlessi(ppj);
                        if(user != null) {
                            UserJson uj = new UserJson(user.getId(),user.getUsername());
                            plessiWrapper.setUser(uj);
                        }
                        else {
                            plessiWrapper.setValidated(false);
                            errors = new HashMap<String, String>();
                            errors.put("Errore grave", "Utente non trovato");
                            plessiWrapper.setErrorMessages(errors);
                            return plessiWrapper;
                        }
                    }
                    break;
            }


        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            plessiWrapper.setValidated(false);
            plessiWrapper.setErrorMessages(errors);
            return  plessiWrapper;
        }
        plessiWrapper.setValidated(true);
        return plessiWrapper;
    }


    @PostMapping(value = "search/affluenza", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public AffluenzaJson researchAffluenza(@RequestBody @ModelAttribute("SezioneJson") SezioneJson sezione, BindingResult result) {
        AffluenzaJson json = new AffluenzaJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            Affluenza afp = affluenzeService.findBySezioneNumerosezioneAndTipoelezioneId(sezione.getSezione(), tipoelezioneid);
            if (sezione.getTipo().equals("2A") || sezione.getTipo().equals("3C") || sezione.getTipo().equals("R2A") || sezione.getTipo().equals("R3c")) {
                /* imposto votanti 1 affluenza */
                if (sezione.getTipo().equals("2A") || sezione.getTipo().equals("R2A")) {
                    json.setVotantifemmineaffp(afp.getVotantifemmine1());
                    json.setVotantimaschiaffp(afp.getVotantimaschi1());
                    json.setVotantitotaliaffp(afp.getVotantitotali1());
                    /* imposto votanti per rettifica*/
                    if (sezione.getTipo().equals("R2A")) {
                        json.setVotantifemmine(afp.getVotantifemmine2());
                        json.setVotantimaschi(afp.getVotantimaschi2());
                        json.setVotantitotali(afp.getVotantitotali2());
                    }
                }
                /* imposto votanti 2 affluenza */
                if (sezione.getTipo().equals("3C") || sezione.getTipo().equals("R3C")) {
                    json.setVotantifemmineaffp(afp.getVotantifemmine2());
                    json.setVotantimaschiaffp(afp.getVotantimaschi2());
                    json.setVotantitotaliaffp(afp.getVotantitotali2());
                    /* imposto votanti per rettifica */
                    if (sezione.getTipo().equals("R3C")) {
                        json.setVotantifemmine(afp.getVotantifemmine3());
                        json.setVotantimaschi(afp.getVotantimaschi3());
                        json.setVotantitotali(afp.getVotantitotali3());
                    }
                }
            }
            /* imposto votanti per rettifica */
            if (sezione.getTipo().equals("R1A")) {
                json.setVotantifemmine(afp.getVotantifemmine1());
                json.setVotantimaschi(afp.getVotantimaschi1());
                json.setVotantitotali(afp.getVotantitotali1());
            }
            json.setNumerosezione(sezione.getSezione());
            json.setTipo(sezione.getTipo());
            /* imposto iscritti per confronti */
            if (!(sezione.getTipo().equals("CO"))) {
                json.setIscrittimaschi(afp.getIscritti().getIscrittimaschigen());
                json.setIscrittifemmine(afp.getIscritti().getIscrittifemminegen());
                json.setIscrittitotali(afp.getIscritti().getIscrittitotaligen());
            } else {
                Iscritti iscritti = iscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid, sezione.getSezione());
                json.setIscrittimaschi(iscritti.getIscrittimaschigen());
                json.setIscrittifemmine(iscritti.getIscrittifemminegen());
                json.setIscrittitotali(iscritti.getIscrittitotaligen());
            }
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            json.setValidated(false);
            json.setErrorMessages(errors);
            return json;
        }
        json.setValidated(true);
        return json;
    }

    @PostMapping(value = "search/voti", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public VotiJson researchVoti(@RequestBody @ModelAttribute("SezioneJsno") SezioneJson sezione, BindingResult result) {
        VotiJson json = new VotiJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            Affluenza afp = affluenzeService.findBySezioneNumerosezioneAndTipoelezioneId(sezione.getSezione(), tipoelezioneid);
            json.setVotanti(afp.getVotantitotali3());
            Iscritti iscritti = iscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid, sezione.getSezione());
            json.setIscritti(iscritti.getIscrittitotaligen());
            json.setNumerosezione(sezione.getSezione());
            json.setTipo(sezione.getTipo());
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            json.setValidated(false);
            json.setErrorMessages(errors);
            return json;
        }
        json.setValidated(true);
        return json;
    }


    @PostMapping(value = "search/preferenze", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public VotiJson researchPreferenze(@RequestBody @ModelAttribute("SezioneJsno") SezioneJson sezione, BindingResult result) {
        VotiJson json = new VotiJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            Affluenza afp = affluenzeService.findBySezioneNumerosezioneAndTipoelezioneId(sezione.getSezione(), tipoelezioneid);
            json.setVotanti(afp.getVotantitotali3());
            Iscritti iscritti = iscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid, sezione.getSezione());
            json.setIscritti(iscritti.getIscrittitotaligen());
            json.setNumerosezione(sezione.getSezione());
            json.setTipo(sezione.getTipo());

        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            json.setValidated(false);
            json.setErrorMessages(errors);
            return json;
        }
        json.setValidated(true);
        return json;
    }

}
