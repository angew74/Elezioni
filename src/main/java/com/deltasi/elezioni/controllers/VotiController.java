package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.helpers.VotiLoader;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.json.*;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.risultati.Voti;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/voti")
public class VotiController {

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

    @Autowired
    IVotiService votiService;

    @Autowired
    IListaService listaService;


    @Autowired
    VotiLoader votiLoader;

    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("voti/list");
        modelAndView.addObject("titlepage", "Gestione Scrutinio");
        List<FaseElezione> fasi = abilitazioniService.findFaseElezioneByAbiltazione(1);
        List<String> f = fasi.stream().map(x -> x.getCodice()).collect(Collectors.toList());
        modelAndView.addObject("fasi", f);
        return modelAndView;
    }


    @GetMapping(value = "/scrutinio/{tipo}/{sezione}")
    public ModelAndView scrutinio(@PathVariable String tipo, @PathVariable Integer sezione) {
        ModelAndView modelAndView = new ModelAndView("voti/scrutinio");
        ListeWrapper listeWrapper = new ListeWrapper();
        int count=0;
        VotiJson json = new VotiJson();
        String titolo = businessRules.getTitoloByFase(tipo, "I");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (tipo.equals("RVL")) {
            List<Voti> l = votiService.findBySezioneNumerosezioneAndSezioneTipoelezioneId(sezione, tipoelezioneid);
            List<ListaJson> listaJsons = new ArrayList<ListaJson>();
            for (Voti v : l) {
                ListaJson j = new ListaJson();
                j.setId(v.getId());
                j.setDenominazione(v.getLista().getDenominazione());
                j.setProgressivo(v.getLista().getProgressivo());
                j.setVoti(v.getNumerovoti());
                j.setNumerosezione(sezione);
                j.setTipo(tipo);
                j.setIdlista(v.getLista().getId());
                listaJsons.add(j);
            }
            json.setListe(listaJsons);
        } else {
            List<Lista> l = listaService.findAllBy();
            List<ListaSemplice> s = new ArrayList<ListaSemplice>();
            for (Lista f : l) {
                ListaSemplice h = new ListaSemplice();
                h.setDenominazione(f.getDenominazione());
                h.setTipo(tipo);
                h.setNumerosezione(sezione);
                h.setIdlista(f.getId());
                s.add(h);
            }
            count = s.size();
            listeWrapper.setListe(s);
        }

      //  modelAndView.addObject("ListeInserimento", new VotiJson());
        modelAndView.addObject("Liste", json);
        modelAndView.addObject("ListWrapper",listeWrapper);
        modelAndView.addObject("Count",count);
        modelAndView.addObject("titlepage", titolo);
        return modelAndView;
    }

    @GetMapping(value = "/inserimento/{tipo}")
    public ModelAndView inserimento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("voti/inserimento");
        VotiJson votijson = new VotiJson();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            ListaJson json = new ListaJson();
          //  List<ListaJson> listevuote = new ArrayList<ListaJson>();
            ListeWrapper listeWrapper = new ListeWrapper();
            List<ListaSemplice> liste = new ArrayList<ListaSemplice>();
            listeWrapper.setListe(liste);
            modelAndView.addObject("ListaInserimento", json);
            modelAndView.addObject("Liste", votijson);
            modelAndView.addObject("ListeWrapper", listeWrapper);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/modifica/{tipo}")
    public ModelAndView modifica(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("voti/modifica");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        VotiJson votijson = new VotiJson();
        ListeWrapper listeWrapper = new ListeWrapper();
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "M");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            modelAndView.addObject("Liste", votijson);
            modelAndView.addObject("ListeWrapper", listeWrapper);
            AffluenzaJson json = new AffluenzaJson();
            modelAndView.addObject("Scrutinio", json);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/annullamento/{tipo}")
    public ModelAndView annullamento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("voti/annullamento");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "A");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            AffluenzaJson json = new AffluenzaJson();
            modelAndView.addObject("Scrutinio", json);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }


   // @PostMapping(value = "/lreg" ,consumes = da)
    @RequestMapping(value = "/lreg", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public  @ResponseBody ListaJson registraScrutinio(@ModelAttribute ListeWrapper form, Model model) {
        ListaJson response = new ListaJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
          /*  if (result.hasErrors()) {
                errors = result.getFieldErrors().stream()
                        .collect(
                                Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                        );

                response.setValidated(false);
                response.setErrorMessages(errors);
            }*/
                switch (form.getListe().get(0).getTipo()) {
                    case "VL":
                      List<Voti> v = votiLoader.prepareVoti(form.getListe());
                      votiService.SaveAll(v);
                      response.setValidated(true);
                      response.setTipo("VL");
                        break;
                    case "RVL":
                        List<Voti> vr = votiLoader.prepareVotiR(form.getListe());
                        votiService.SaveAll(vr);
                        response.setValidated(true);
                        response.setTipo("RVL");
                        break;
                    default:
                        errors = new HashMap<String, String>();
                        errors.put("Errore grave", "Parametri non validi");
                        response.setValidated(false);
                        response.setErrorMessages(errors);
                        break;
                }

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
