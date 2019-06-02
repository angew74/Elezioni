package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserJsonResponse;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.UserSezione;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    @Autowired
    IUserSezioneService userSezioneService;

    @Autowired
    ISezioneService sezioneService;

    @Autowired
    IUserService userService;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    private Environment env;


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


    @GetMapping(value = "/plessi")
    @Secured("ROLE_ADMIN")
    public ModelAndView plessi(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("abilitazioni/plessi");
        modelAndView.addObject("titlepage", "Gestione Plessi utenti");
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

    @GetMapping(value = "/associa", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Secured("ROLE_ADMIN")
    public @ResponseBody UserJsonResponse associa(@RequestParam("userid") Integer userid, @RequestParam("plessoid") Integer plessoid)
    {
        Map<String, String> errors = null;
        UserJsonResponse response = new UserJsonResponse();
        List<UserSezione> l = new ArrayList<>();
        try {
            Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
            TipoElezione t = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
            User user = userService.getUtente(userid);
            List<Sezione> ss = sezioneService.findByPlessoIdAndTipoelezioneId(plessoid, tipoelezioneid);
            for (Sezione s : ss
            ) {
                UserSezione u = new UserSezione();
                u.setTipoelezione(t);
                u.setUser(user);
                u.setSezione(s);
                l.add(u);
            }
            userSezioneService.SaveAll(l);
            response.setValidated(true);
        }catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }


}
