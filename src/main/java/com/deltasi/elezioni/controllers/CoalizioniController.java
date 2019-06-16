package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.json.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/coalizioni")
public class CoalizioniController {

    private static final Logger logger = LogManager.getLogger(VotiController.class);

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
    ISezioneService sezioneService;

    @Autowired
    BusinessRules businessRules;





    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("voti/list");
        modelAndView.addObject("titlepage", "Gestione Scrutinio");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<FaseElezione> fasi = abilitazioniService.findByAbilitataAndTipoelezioneId(1,tipoelezioneid);
        List<String> f = fasi.stream().map(x -> x.getCodice()).collect(Collectors.toList());
        modelAndView.addObject("fasi", f);
        return modelAndView;
    }



    @GetMapping(value = "/inserimento/{tipo}")
    public ModelAndView inserimento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("coalizioni/inserimento");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            SindacoJson json = new SindacoJson();
            SindaciWrapper sindaciWrapper = new SindaciWrapper();
            List<SindacoSimple> sindaci = new ArrayList<SindacoSimple>();
            sindaciWrapper.setSindaci(sindaci);
            VotiSindacoJson votiSindacoJson = new VotiSindacoJson();
            modelAndView.addObject("SindacoInserimento", json);
            modelAndView.addObject("Sindaci", votiSindacoJson);
            modelAndView.addObject("SindaciWrapper", sindaciWrapper);
            modelAndView.addObject("buttonSezione", "submitSearch");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
        }else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/modifica/{tipo}")
    public ModelAndView modifica(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("coalizioni/modifica");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "M");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            AffluenzaJson json = new AffluenzaJson();
            modelAndView.addObject("Scrutinio", json);
            modelAndView.addObject("buttonSezione", "submitSearch");
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

}
