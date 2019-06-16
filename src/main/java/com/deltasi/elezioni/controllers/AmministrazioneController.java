package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.AffluenzaLoader;
import com.deltasi.elezioni.helpers.VotiLoader;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import com.deltasi.elezioni.model.json.UserJsonResponse;
import com.deltasi.elezioni.model.configuration.*;
import com.deltasi.elezioni.model.json.*;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.model.risultati.Voti;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "/amministrazione")
public class AmministrazioneController {
    private static final Logger logger = LogManager.getLogger(AmministrazioneController.class);

    @Autowired
    IAbilitazioniService abilitazioniService;

    @Autowired
    IPlessoService plessoService;

    @Autowired
    IUserSezioneService userSezioneService;

    @Autowired
    IUserExtendedService userExtendedService;

    @Autowired
    IIscrittiService iscrittiService;

    @Autowired
    ISezioneService sezioneService;

    @Autowired
    IUserService userService;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    private Environment env;

    @Autowired
    IAffluenzaService affluenzeService;

    @Autowired
    IVotiService vctiService;

    @Autowired
    AffluenzaLoader affluenzaLoader;

    @Autowired
    VotiLoader votiLoader;


    @GetMapping(value = "/map/page/{page}")
    @Secured("ROLE_ADMIN")
    public ModelAndView map(@PathVariable("page") int page) {
        ModelAndView modelAndView = new ModelAndView("amministrazione/map");
        modelAndView.addObject("titlepage", "Gestione Abilitazioni fasi");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        Integer utentipagina = Integer.parseInt(env.getProperty("abilitazionipagina"));
        Pageable pageable = PageRequest.of(page - 1, utentipagina);
        try {

            Page<FaseElezione> list = abilitazioniService.findAllByTipoelezioneId(pageable,tipoelezioneid);
            int totalPages = list.getTotalPages();
            if(totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
                modelAndView.addObject("pageNumbers", pageNumbers);
            }
            modelAndView.addObject("Fasi", list.getContent());
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
        ModelAndView modelAndView = new ModelAndView("amministrazione/list");
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
        ModelAndView modelAndView = new ModelAndView("amministrazione/plessi");
        modelAndView.addObject("titlepage", "Gestione Plessi utenti");
        modelAndView.addObject("tipo", "I");
        return modelAndView;
    }

    @GetMapping(value = "/addetti/page/{page}")
    @Secured("ROLE_ADMIN")
    public ModelAndView addetti(@PathVariable("page") int page) {
        Integer utentipagina = Integer.parseInt(env.getProperty("utentipagina"));
        Pageable pageable = PageRequest.of(page - 1, utentipagina);
        List<AddettoJson> jj = new ArrayList<AddettoJson>();
        Map<String, String> errors = null;
        ModelAndView modelAndView = new ModelAndView("amministrazione/addetti");
        modelAndView.addObject("titlepage", "Gestione Addetti sezione");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try
        {
           Page<UserExtended> listu = userExtendedService.findAll(pageable);
            int totalPages = listu.getTotalPages();
            if(totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
                modelAndView.addObject("pageNumbers", pageNumbers);
            }
            for (UserExtended u : listu) {
                List<UserSezione> us = userSezioneService.findByTipoelezioneIdAndUserId(tipoelezioneid,  u.getUser().getId());
                if(us != null && us.size() > 0 ) {
                    List<PlessoJson> listp =  new ArrayList<PlessoJson>();
                    AddettoJson a = new AddettoJson();
                    UserJson j = new UserJson(u.getUser().getId(), u.getUser().getUsername(), u.getNome(), u.getCognome());
                    for (UserSezione z : us) {
                        PlessoJson pj = new PlessoJson();
                        pj.setCabina(z.getSezione().getCabina());
                        pj.setSezione(z.getSezione().getId());
                        pj.setDescrizione(z.getSezione().getPlesso().getDescrizione());
                        pj.setMunicipio(z.getSezione().getMunicipio());
                        pj.setNumero(z.getSezione().getPlesso().getId());
                        pj.setUbicazione(z.getSezione().getPlesso().getUbicazione());
                        pj.setTipo(z.getSezione().getTiposezione().getDescrizione());
                        listp.add(pj);
                    }
                    a.setUser(j);
                    a.setPlessi(listp);
                    jj.add(a);
                }
                else {
                    UserJson j = new UserJson(u.getUser().getId(), u.getUser().getUsername(), u.getNome(), u.getCognome());
                    AddettoJson a = new AddettoJson();
                    a.setUser(j);
                    jj.add(a);
                }
            }
        }
        catch (Exception ex)
        {
            logger.error(ex);
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("errMsg", ex.getMessage());
            return modelAndView;
        }
        modelAndView.addObject("Addetti", jj);
        return modelAndView;
    }

    @GetMapping(value = "/sezioni")
    @Secured("ROLE_ADMIN")
    public ModelAndView sezioni(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("amministrazione/sezioni");
        modelAndView.addObject("titlepage", "Gestione Sezione");
        modelAndView.addObject("tipo", "S");
        modelAndView.addObject("buttonSezione", "submitSearchInt");
        return modelAndView;
    }

    @GetMapping(value = "/mplessi")
    @Secured("ROLE_ADMIN")
    public ModelAndView mplessi(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("amministrazione/plessi");
        modelAndView.addObject("tipo", "M");
        modelAndView.addObject("titlepage", "Modifica Plessi utenti");
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
    public @ResponseBody
    UserJsonResponse associa(@RequestParam("userid") Integer userid, @RequestParam("plessoid") Integer plessoid, @RequestParam("tipo") String tipo) {
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
            if (tipo.equals("M")) {
                userSezioneService.deleteAllBySezioneInAndUser(ss, user);
            } else {
                userSezioneService.SaveAll(l);
            }
            response.setValidated(true);
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }

    @PostMapping(value = "/intsez", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public InterrogazioneJson researchSezione(@RequestBody @ModelAttribute("SezioneJson") SezioneJson sezione, BindingResult result) {
        Iscritti iscritti = new Iscritti();
        Map<String, String> errors = null;
        InterrogazioneJson i = new InterrogazioneJson();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        if (result.hasErrors()) {
            errors = result.getFieldErrors().stream()
                    .collect(
                            Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                    );
            i.setValidated(false);
            i.setErrorMessages(errors);
        }
        try {
            if (sezione.getSezione() == 0 || sezione.getSezione() == null) {
                i.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", "Sezione non può essere zero");
                i.setErrorMessages(errors);
                return i;
            }
            if (sezione.getCabina() == 0 || sezione.getCabina() == null) {
                i.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", "Cabina non può essere zero");
                i.setErrorMessages(errors);
                return i;
            }
            iscritti = iscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid, sezione.getSezione());
            if (!iscritti.getCabina().equals(sezione.getCabina())) {
                sezione.setValidated(false);
                errors = new HashMap<String, String>();
                errors.put("Errore grave", "Sezione cabina non congruenti");
                sezione.setErrorMessages(errors);
                return i;
            }
            UserSezione userSeziones = userSezioneService.findBySezioneIdAndTipoelezioneId(sezione.getSezione(), tipoelezioneid);
            Affluenza a3 = affluenzeService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(sezione.getSezione(), tipoelezioneid, 1);
            AffluenzaJson ajson = new AffluenzaJson();
            if (a3 != null) {
                ajson = affluenzaLoader.convertToJson(a3, iscritti, "3C");
            } else {
                Affluenza a2 = affluenzeService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza2(sezione.getSezione(), tipoelezioneid, 1);
                if (a2 != null) {
                    ajson = affluenzaLoader.convertToJson(a3, iscritti, "2A");
                } else {
                    Affluenza a1 = affluenzeService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza1(sezione.getSezione(), tipoelezioneid, 1);
                    if (a1 != null) {
                        ajson = affluenzaLoader.convertToJson(a3, iscritti, "1A");
                    }
                }
            }
            i.setAffluenzaJson(ajson);
            if(userSeziones != null) {
                i.setUserJson(new UserJson(userSeziones.getUser().getId(), userSeziones.getUser().getUsername()));
            }
            else {
                i.setUserJson(new UserJson(0,"Nessuno"));
            }
            i.setTipoSezione(iscritti.getSezione().getTiposezione().getDescrizione());
            i.setDescrizioneElezione(iscritti.getTipoelezione().getDescrizione());
            List<Voti> v = vctiService.findBySezioneNumerosezioneAndTipoelezioneId(sezione.getSezione(), tipoelezioneid);
            if(v != null && v.size() > 0)
            {
                VotiJson votiJson = votiLoader.ConvertToJson(v,sezione.getSezione(),"");
                i.setVotiJson(votiJson);
            }
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errore grave", ex.getMessage());
            logger.error(ex.getMessage());
            sezione.setValidated(false);
            sezione.setErrorMessages(errors);
        }
        i.getAffluenzaJson().setNumerosezione(sezione.getSezione());
        i.getAffluenzaJson().setCabina(sezione.getCabina());
        i.setValidated(true);
        return i;
    }


}
