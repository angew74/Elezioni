package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.json.SezioneJson;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class ResearchRestController {


    @PostMapping("search/sezione")
    public Iscritti research(@Valid @ModelAttribute("sezione") SezioneJson sezione, Principal principal)
    {
        return  null;
    }

}
