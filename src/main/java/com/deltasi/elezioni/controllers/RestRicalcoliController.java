package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.helpers.RicalcoliDraft;
import com.deltasi.elezioni.model.json.ListaJson;
import com.deltasi.elezioni.model.json.ListaSemplice;
import com.deltasi.elezioni.model.json.ListeWrapper;
import com.deltasi.elezioni.model.json.VotiJson;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dati")
public class RestRicalcoliController {

    private static final Logger logger = LogManager.getLogger(AffluenzeController.class);

    @Autowired
    private Environment env;

    @Autowired
    RicalcoliDraft draft;




    @GetMapping(value = "/ricalcola/{aggregazione}/{tipoRicalcolo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public ListaJson ricalcola(@PathVariable("aggregazione") String aggregazione,@PathVariable("tipoRicalcolo") String tipoRicalcolo
                                       ) {
        ListaJson response = new ListaJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            draft.Affluenza(aggregazione,tipoRicalcolo);

        } catch(AccessDeniedException e) {
            logger.warn("Unauthorized", e);
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
