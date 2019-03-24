package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.json.AffluenzaJson;
import com.deltasi.elezioni.model.json.SezioneJson;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.rmi.CORBA.Util;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/affluenze")
public class AffluenzeController {

    private static final Logger logger = LogManager.getLogger(AffluenzeController.class);

    @Autowired
    private Environment env;

    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    IElegenService elegenService;

    @Autowired
    IIscrittiService iscrittiService;

    @Autowired
    IAbilitazioniService abilitazioniService;

    @Autowired
    BusinessRules businessRules;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/list");
        modelAndView.addObject("titlepage", "Gestione Andamento");
        List<FaseElezione> fasi = abilitazioniService.findFaseElezioneByAbiltazione(1);
        List<String> f = fasi.stream().map(x -> x.getCodice()).collect(Collectors.toList());
        modelAndView.addObject("fasi", f);
        return modelAndView;
    }

    @GetMapping(value = "/inserimento/{tipo}")
    public ModelAndView inserimento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/inserimento");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            AffluenzaJson json = new AffluenzaJson();
            modelAndView.addObject("Andamento", json);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/modifica/{tipo}")
    public ModelAndView modifica(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/modifica");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "M");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);

        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/annullamento/{tipo}")
    public ModelAndView annullamento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/annullamento");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "A");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }


    @GetMapping(value = "/registra/{tipo}/{sezione}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public SezioneJson registra(@PathVariable String tipo, @PathVariable Integer sezione, Principal principal) {
        SezioneJson sezioneJson = new SezioneJson();
        Affluenza affluenza = new Affluenza();
        TipoElezione tipoElezione = new TipoElezione();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            String msg = businessRules.IsInsertable(sezione, tipo, tipoelezioneid);
            if (msg.equals("")) {
                LocalDateTime oggi = LocalDateTime.now();
                tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
                switch (tipo) {
                    case "AP":
                        affluenza = affluenzaService.findByNumerosezioneAndTipoelezioneId(sezione, tipoelezioneid);
                        affluenza.setDataoperazione(oggi);
                        affluenza.setUtenteoperazione(SecurityContextHolder.getContext().getAuthentication().getName());
                        affluenza.setApertura1(1);
                        affluenzaService.add(affluenza);
                        sezioneJson.setValidated(true);
                        break;
                    case "CO":
                        affluenza.setNumerosezione(sezione);
                        affluenza.setDataoperazione(oggi);
                        affluenza.setUtenteoperazione(SecurityContextHolder.getContext().getAuthentication().getName());
                        affluenza.setTipoelezione(tipoElezione);
                        Iscritti iscritti = iscrittiService.findIscrittiBySezione(sezione);
                        affluenza.setIscritti(iscritti);
                        affluenza.setCostituzione1(1);
                        affluenzaService.add(affluenza);
                        sezioneJson.setValidated(true);
                        break;
                }
            } else {
                errors = new HashMap<String, String>();
                errors.put("Errore applicativo", msg);
                sezioneJson.setValidated(false);
                sezioneJson.setErrorMessages(errors);
            }
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            sezioneJson.setValidated(false);
            sezioneJson.setErrorMessages(errors);
        }
        return sezioneJson;
    }


    @PostMapping(value = "/anda")
    public SezioneJson registraAffluenza(@ModelAttribute("sezione") @Valid AffluenzaJson affluenzaJson,
                                         BindingResult result, ModelMap mode) {
        SezioneJson response = new SezioneJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            if (result.hasErrors()) {
                errors = result.getFieldErrors().stream()
                        .collect(
                                Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                        );

                response.setValidated(false);
                response.setErrorMessages(errors);
            }
            Affluenza affluenza = affluenzaService.findByNumerosezioneAndTipoelezioneId(affluenzaJson.getNumerosezione(),tipoelezioneid);

        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }
}
