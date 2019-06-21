package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.helpers.VotiLoader;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.json.*;
import com.deltasi.elezioni.model.risultati.*;
import com.deltasi.elezioni.state.SessionStateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    ISindacoService sindacoService;

    @Autowired
    IVotiService votiService;

    @Autowired
    IVotiListaService votiListaService;

    @Autowired
    IListaService listaService;

    @Autowired
    IVotiSindacoService votiSindacoService;

    @Autowired
    ICoalizioneService coalizioneService;

    @Autowired
    VotiLoader votiLoader;

    @Autowired
    SessionStateHelper stateHelper;



    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("coalizioni/list");
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

    @GetMapping(value = "/scrutinio/{tipo}/{sezione}")
    public ModelAndView scrutinio(@PathVariable String tipo, @PathVariable Integer sezione) {
        ModelAndView modelAndView = new ModelAndView("coalizioni/scrutinio");
        SindaciWrapper sindaciWrapper = new SindaciWrapper();
        int count = 0;
        VotiSindacoJson json = new VotiSindacoJson();
        String titolo = businessRules.getTitoloByFase(tipo, "I");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (tipo.equals("RVS")) {
            List<VotiSindaco> l = votiSindacoService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, tipoelezioneid);
            List<ListaJson> listaJsons = new ArrayList<ListaJson>();
            json = votiLoader.ConvertToJsonSindaci(l,sezione,tipo);
        } else {
            List<Sindaco> l = sindacoService.findAllBy();
            List<SindacoSimple> s = new ArrayList<SindacoSimple>();
            for (Sindaco f : l) {
                SindacoSimple h = new SindacoSimple();
                h.setCognome(f.getCognome());
                h.setNome(f.getNome());
                h.setTipo(tipo);
                h.setNumerosezione(sezione);
                h.setIdsindaco(f.getId());
                s.add(h);
            }
            count = s.size();
            sindaciWrapper.setSindaci(s);
        }

        //  modelAndView.addObject("ListeInserimento", new VotiJson());
        modelAndView.addObject("Sindaci", json);
        modelAndView.addObject("ListWrapper", sindaciWrapper);
        modelAndView.addObject("Count", count);
        modelAndView.addObject("titlepage", titolo);
        return modelAndView;
    }

    @GetMapping(value = "/listecoalizione/{idsindaco}/{sezione}")
    public  String listecoalizione(@PathVariable int idsindaco,@PathVariable int sezione, ModelMap modelMap)
    {
        ListeWrapper listeWrapper = new ListeWrapper();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        String ricalcoloLista = "ricalcolo" + idsindaco;
        List<Lista> l = listaService.findBySindacoId(idsindaco);
        if(stateHelper.get(ricalcoloLista) != null)
        {
            listeWrapper =(ListeWrapper) stateHelper.get(ricalcoloLista);
        }
        else {
            List<ListaSemplice> s = new ArrayList<ListaSemplice>();
            for (Lista f : l) {
                ListaSemplice h = new ListaSemplice();
                h.setDenominazione(f.getDenominazione());
                h.setNumerosezione(sezione);
                h.setIdlista(f.getId());
                h.setIdsindaco(idsindaco);
                s.add(h);
            }
            listeWrapper.setListe(s);
        }
        Coalizione c = coalizioneService.findBySindacoIdAndTipoelezioneId(idsindaco, tipoelezioneid);
        modelMap.addAttribute("ListWrapper",listeWrapper);
        modelMap.addAttribute("coalizione",c.getDenominazione());
        return  "modal/liste :: modalContents";
    }

    @RequestMapping(value = "/liste", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    ListaJson registraliste(@ModelAttribute ListeWrapper form, Model model) {
        String ricalcoloLista = "ricalcolo" + form.getListe().get(0).getIdsindaco();
        stateHelper.add(ricalcoloLista , form);
        ListaJson response = new ListaJson();
        response.setValidated(true);
        return  response;
    }

    @RequestMapping(value = "/coalreg", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    ListaJson registraScrutinioCoalizione(@ModelAttribute ListeWrapper form, Model model) {
        ListaJson response = new ListaJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            switch (form.getListe().get(0).getTipo()) {
                case "VS":
                    List<VotiLista> v = votiLoader.prepareVoti(form.getListe());
                    votiListaService.SaveAll(v);
                    response.setValidated(true);
                    response.setTipo("VL");
                    break;
                case "RVS":
                    List<VotiLista> vr = votiLoader.prepareVotiR(form.getListe());
                    votiListaService.SaveAll(vr);
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
