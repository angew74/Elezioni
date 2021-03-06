package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.model.configuration.Aggregazione;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.configuration.Municipio;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.deltasi.elezioni.model.json.AffluenzaJson;
import com.deltasi.elezioni.model.risultati.Lista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/ricalcoli")
public class RicalcoliController {

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
    IAggregazioneService aggregazioneService;

    @Autowired
    ITipoRicalcoloService tipoRicalcoloService;

    @Autowired
    IListaService listaService;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("ricalcoli/list");
        modelAndView.addObject("titlepage", "Gestione Ricalcoli");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<FaseElezione> fasi = abilitazioniService.findByAbilitataAndTipoelezioneId(1,tipoelezioneid);
        List<String> f = fasi.stream().map(x -> x.getCodice()).collect(Collectors.toList());
        modelAndView.addObject("fasi", f);
        return modelAndView;
    }

    @GetMapping(value = "/affluenza")
    public ModelAndView affluenza(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("ricalcoli/affluenza");
        String tipo = "RIC";
       Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<Aggregazione> list = aggregazioneService.FindAllBytipoElezioneId(tipoelezioneid);
        List<TipoRicalcolo> ricalcoli = tipoRicalcoloService.findAllByTipoelezioneIdAndCodiceFase(tipoelezioneid, tipo);
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            modelAndView.addObject("aggregazioni", list);
            modelAndView.addObject("tipiricalcolo", ricalcoli);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/costituzione")
    public ModelAndView costituzione(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("ricalcoli/costituzione");
        String tipo = "RIA";
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<Aggregazione> list = aggregazioneService.FindAllBytipoElezioneId(tipoelezioneid);
        List<TipoRicalcolo> ricalcoli = tipoRicalcoloService.findAllByTipoelezioneIdAndCodiceFase(tipoelezioneid, tipo);
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            modelAndView.addObject("aggregazioni", list);
            modelAndView.addObject("tipiricalcolo", ricalcoli);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/voti")
    public ModelAndView voti(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("ricalcoli/voti");
        String tipo = "RIL";
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<TipoRicalcolo> ricalcoli = tipoRicalcoloService.findAllByTipoelezioneIdAndCodiceFase(tipoelezioneid, tipo);
        List<Municipio> municipi = municipiService.getAll();
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            modelAndView.addObject("municipi", municipi);
            modelAndView.addObject("tipiricalcolo", ricalcoli);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/preferenze")
    public ModelAndView preferenze(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("ricalcoli/preferenze");
        String tipo = "RIP";
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<TipoRicalcolo> ricalcoli = tipoRicalcoloService.findAllByTipoelezioneIdAndCodiceFase(tipoelezioneid, tipo);
        List<Municipio> municipi = municipiService.getAll();
        List<Lista> liste = new ArrayList<Lista>();
        liste = listaService.findAllByTipoelezioneId(tipoelezioneid);
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("Liste", liste);
            modelAndView.addObject("tipo", tipo);
            modelAndView.addObject("municipi", municipi);
            modelAndView.addObject("tipiricalcolo", ricalcoli);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

}
