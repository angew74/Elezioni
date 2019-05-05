package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.model.configuration.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/interrogazioni")
public class InterrogazioniController {

    private static final Logger logger = LogManager.getLogger(AffluenzeController.class);

    @Autowired
    private Environment env;

    @Autowired
    BusinessRules businessRules;

    @Autowired
    IAbilitazioniService abilitazioniService;

    @Autowired
    IMunicipioService municipiService;

    @Autowired
    IAggregazioneInterrogazioneService aggregazioneService;

    @Autowired
    ITipoInterrogazioneService tipoInterrogazioneService;

    @Autowired
    IListaService listaService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("interrogazioni/list");
        modelAndView.addObject("titlepage", "Gestione Interrogazioni");
        List<FaseElezione> fasi = abilitazioniService.findFaseElezioneByAbiltazione(1);
        List<String> f = fasi.stream().map(x -> x.getCodice()).collect(Collectors.toList());
        modelAndView.addObject("fasi", f);
        return modelAndView;
    }

    @GetMapping(value = "/affluenza")
    public ModelAndView affluenza(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("interrogazioni/affluenza");
        String tipo = "RIC";
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<AggregazioneInterrogazione> list = aggregazioneService.findAllByTipoelezioneId(tipoelezioneid);
        List<TipoInterrogazione> i = tipoInterrogazioneService.findAllByTipoelezioneIdAndCodiceFase(tipoelezioneid, tipo);
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            modelAndView.addObject("tipiinterrogazione",i);
            modelAndView.addObject("aggregazioniint", list);
           } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }


}
