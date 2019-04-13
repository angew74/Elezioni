package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.model.json.ListaJson;
import com.deltasi.elezioni.model.json.ListaSemplice;
import com.deltasi.elezioni.model.json.ListeWrapper;
import com.deltasi.elezioni.model.json.VotiJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
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
public class RestVotiController {

    private static final Logger logger = LogManager.getLogger(AffluenzeController.class);

    @Autowired
    private Environment env;

    @PostMapping(value = "/lreg", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ListaJson registraScrutinio(String liste
                                       ) {
        ListaJson response = new ListaJson();
        Map<String, String> errors = null;
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
          /*  for (ListaSemplice l: liste.getListe()
            ) {
                switch (l.getTipo()) {
                    case "VL":
                        break;
                    case "RVL":
                        response.setValidated(true);
                        break;
                    default:
                        errors = new HashMap<String, String>();
                        errors.put("Errore grave", "Parametri non validi");
                        response.setValidated(false);
                        response.setErrorMessages(errors);
                        break;
                }

            }*/

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
