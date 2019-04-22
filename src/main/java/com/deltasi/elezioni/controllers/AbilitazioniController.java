package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.IAbilitazioniService;
import com.deltasi.elezioni.model.authentication.UserJsonResponse;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/abilitazioni")
public class AbilitazioniController {
    private static final Logger logger = LogManager.getLogger(AbilitazioniController.class);

    @Autowired
    IAbilitazioniService abilitazioniService;


    @GetMapping(value = "/map")
    @Secured("ROLE_ADMIN")
    public ModelAndView map(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("abilitazioni/map");
        modelAndView.addObject("titlepage", "Gestione Abilitazioni fasi");
        List<FaseElezione> list = new ArrayList<FaseElezione>();
        try {
            list = abilitazioniService.getAll();
            modelAndView.addObject("Fasi", list);
            modelAndView.addObject("fasicount", list.size());
        } catch (Exception ex) {
            String error = ex.getMessage();
            ModelAndView errormodelAndView = new ModelAndView("common/error");
            modelAndView.addObject("titlepage", "Pagina Errore");
            modelAndView.addObject("Error", error);
            return errormodelAndView;
        }
        return modelAndView;
    }

    @GetMapping(value = "/list")
    @Secured("ROLE_ADMIN")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("abilitazioni/list");
        modelAndView.addObject("titlepage", "Gestione Generale");
        List<FaseElezione> list = new ArrayList<FaseElezione>();
        try {
            list = abilitazioniService.getAll();
            modelAndView.addObject("Fasi", list);
            modelAndView.addObject("fasicount", list.size());
        } catch (Exception ex) {
            String error = ex.getMessage();
            ModelAndView errormodelAndView = new ModelAndView("common/error");
            modelAndView.addObject("titlepage", "Pagina Errore");
            modelAndView.addObject("Error", error);
            return errormodelAndView;
        }
        return modelAndView;
    }


    @PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Secured("ROLE_ADMIN")
    public @ResponseBody
    UserJsonResponse viewUser(@RequestParam("id") Integer id, @RequestParam("abilitazione") Integer abilitazione) {
        Map<String, String> errors = null;
        UserJsonResponse response = new UserJsonResponse();
        try {
            FaseElezione fase = abilitazioniService.findFaseElezioneById(id);
            fase.setAbilitata(abilitazione);
            abilitazioniService.Save(fase);
            response.setValidated(true);
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }


}
