package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.contracts.IElegenService;
import com.deltasi.elezioni.contracts.IIscrittiService;
import com.deltasi.elezioni.contracts.ITipoElezioneService;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.json.SezioneJson;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/list");
        modelAndView.addObject("titlepage", "Gestione Andamento");
        return modelAndView;
    }

    @GetMapping(value = "/inserimento/{tipo}")
    public ModelAndView inserimento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/inserimento");
        String titolo = "Inserimento";
        switch (tipo) {
            case "2A":
                titolo = "Inserimento 2 Affluenza Seggio";
                break;
            case "1A":
                titolo = "Inserimento 1 Affluenza Seggio";
                break;
            case "A":
                titolo = "Inserimento Apertura Seggio";
                break;
            case "C":
                titolo = "Inserimento Costituzione Seggio";
                break;
            case "3C":
                titolo = "Inserimento Chiusura Seggio";
                break;
        }
        modelAndView.addObject("titlepage", titolo);
        modelAndView.addObject("tipo", tipo);
        return modelAndView;
    }

    @GetMapping(value = "/registra/{tipo}/{sezione}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public SezioneJson registra(@PathVariable String tipo, @PathVariable Integer sezione, Principal principal) {
        SezioneJson sezioneJson = new SezioneJson();
        Affluenza affluenza = new Affluenza();
        TipoElezione tipoElezione = new TipoElezione();
        Map<String, String> errors = null;
        try {
            LocalDateTime oggi = LocalDateTime.now();
            Integer idtipoelezione =Integer.parseInt(env.getProperty("tipoelezioneid"));
            tipoElezione =  tipoElezioneService.findTipoElezioneById(idtipoelezione);
            affluenza.setNumerosezione(sezione);
            affluenza.setDataoperazione(oggi);
            affluenza.setUtenteoperazione(SecurityContextHolder.getContext().getAuthentication().getName());
            affluenza.setTipoelezione(tipoElezione);
            switch (tipo) {
                case "A":
                    affluenza.setApertura1(1);
                    affluenzaService.add(affluenza);
                    break;
                case "C":
                    affluenza.setCostituzione1(1);
                    affluenzaService.add(affluenza);
                    break;
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
}
