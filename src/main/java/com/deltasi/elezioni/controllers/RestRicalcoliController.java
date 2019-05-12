package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.IRicalcoloAffluenzaService;
import com.deltasi.elezioni.contracts.IRicalcoloCostAperturaService;
import com.deltasi.elezioni.contracts.IRicalcoloPreferenzeService;
import com.deltasi.elezioni.contracts.IRicalcoloVotiService;
import com.deltasi.elezioni.helpers.RicalcoliDraft;
import com.deltasi.elezioni.model.json.ListaJson;
import com.deltasi.elezioni.model.json.ListaSemplice;
import com.deltasi.elezioni.model.json.ListeWrapper;
import com.deltasi.elezioni.model.json.VotiJson;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.state.SessionStateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dati")
public class RestRicalcoliController {

    private static final Logger logger = LogManager.getLogger(RestRicalcoliController.class);

    @Autowired
    private Environment env;

    @Autowired
    RicalcoliDraft draft;

    @Autowired
    private IRicalcoloAffluenzaService ricalcoloAffluenzaService;

    @Autowired
    private IRicalcoloCostAperturaService ricalcoloCostAperturaService;

    @Autowired
    private IRicalcoloVotiService ricalcoloVotiService;

    @Autowired
    private IRicalcoloPreferenzeService ricalcoloPreferenzeService;

    @Autowired
    SessionStateHelper stateHelper;

    @Autowired
    private HttpSession httpSession;


    @GetMapping(value = "/ricalcola/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloAffluenza> ricalcola(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo
    ) {
        Map<String, String> errors = null;
        List<RicalcoloAffluenza> l = new ArrayList<RicalcoloAffluenza>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            l = draft.Affluenza(aggregazione, tipoRicalcolo);

        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.add("Ricalcolo", l);
        //httpSession.setAttribute("Ricalcolo",l);
        return l;
    }

    @GetMapping(value = "/ricalcolacostituzione/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloCostApertura> ricalcolacostituzione(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo
    ) {
        Map<String, String> errors = null;
        List<RicalcoloCostApertura> l = new ArrayList<RicalcoloCostApertura>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            l = draft.costApertura(aggregazione, tipoRicalcolo);

        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.add("Ricalcolo", l);
        //httpSession.setAttribute("Ricalcolo",l);
        return l;
    }

    @GetMapping(value = "/ricalcolavoti/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloVoti> SommaVoti(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo
    ) {
        Map<String, String> errors = null;
        List<RicalcoloVoti> l = new ArrayList<RicalcoloVoti>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {

            l = draft.voti(aggregazione, tipoRicalcolo);
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.add("Ricalcolo", l);
        //httpSession.setAttribute("Ricalcolo",l);
        return l;
    }

    @GetMapping(value = "/ricalcolapreferenze/{aggregazione}/{tipoRicalcolo}/{lista}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloPreferenze> SommaPreferenze(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo,@PathVariable("lista") int lista
    ) {
        Map<String, String> errors = null;
            List<RicalcoloPreferenze> l = new ArrayList<RicalcoloPreferenze>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {

            l = draft.preferenze(aggregazione, tipoRicalcolo,lista);
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.add("Ricalcolo", l);
        //httpSession.setAttribute("Ricalcolo",l);
        return l;
    }

    @GetMapping(value = "/salvaricalcolo/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloAffluenza> salvaRicalcolo(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo
    ) {

        List<RicalcoloAffluenza> l = new ArrayList<>();
        try {
            l = (List<RicalcoloAffluenza>) stateHelper.get("Ricalcolo");
            //l =(List<RicalcoloAffluenza>) httpSession.getAttribute("Ricalcolo");
            if (l.get(0).getTiporicalcolo().getCodice().equals(tipoRicalcolo)) {
                ricalcoloAffluenzaService.SaveAll(l);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Ricalcolo non congruente");
            }
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.remove("Ricalcolo");
        return l;
    }

    @GetMapping(value = "/salvaricalcolocostituzione/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloCostApertura> salvaRicalcoloCostAper(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo
    ) {

        List<RicalcoloCostApertura> l = new ArrayList<>();
        try {
            l = (List<RicalcoloCostApertura>) stateHelper.get("Ricalcolo");
            //l =(List<RicalcoloAffluenza>) httpSession.getAttribute("Ricalcolo");
            if (l.get(0).getTiporicalcolo().getCodice().equals(tipoRicalcolo)) {
                ricalcoloCostAperturaService.SaveAll(l);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Ricalcolo non congruente");
            }
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.remove("Ricalcolo");
        return l;
    }

    @GetMapping(value = "/salvaricalcolovoti/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloVoti> salvaRicalcoloVoti(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo
    ) {

        List<RicalcoloVoti> l = new ArrayList<>();
        try {
            l = (List<RicalcoloVoti>) stateHelper.get("Ricalcolo");
            //l =(List<RicalcoloAffluenza>) httpSession.getAttribute("Ricalcolo");
            if (l.get(0).getTiporicalcolo().getCodice().equals(tipoRicalcolo)) {
                ricalcoloVotiService.SaveAll(l);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Ricalcolo non congruente");
            }
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.remove("Ricalcolo");
        return l;
    }

    @GetMapping(value = "/salvaricalcolopreferenze/{aggregazione}/{tipoRicalcolo}/{lista}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloPreferenze> salvaRicalcoloPreferenze(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoRicalcolo") String tipoRicalcolo,@PathVariable("lista") int lista
    ) {

        List<RicalcoloPreferenze> l = new ArrayList<>();
        try {
            l = (List<RicalcoloPreferenze>) stateHelper.get("Ricalcolo");
           if (l.get(0).getTiporicalcolo().getCodice().equals(tipoRicalcolo)) {
                ricalcoloPreferenzeService.SaveAll(l);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Ricalcolo non congruente");
            }
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        stateHelper.remove("Ricalcolo");
        return l;
    }
}
