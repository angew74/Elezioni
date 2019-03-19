package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.contracts.IElegenService;
import com.deltasi.elezioni.contracts.IIscrittiService;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.configuration.Iscritti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/affluenze")
public class AffluenzeController {

    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    IElegenService elegenService;

    @Autowired
    IIscrittiService iscrittiService;


    @GetMapping(value = "/list")
    public ModelAndView list(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("affluenze/list");
        modelAndView.addObject("titlepage", "Gestione Andamento");
        return modelAndView;
    }

    @GetMapping(value ="/inserimento/{tipo}")
    public  ModelAndView inserimento(@PathVariable String tipo, Principal principal)
    {
        ModelAndView modelAndView = new ModelAndView("affluenze/inserimento");
        String titolo = "Inserimento";
        switch (tipo)
        {
            case "2A":
                titolo ="Inserimento 2 Affluenza Seggio";
                break;
            case "1A":
                titolo = "Inserimento 1 Affluenza Seggio";
                break;
            case  "A":
                titolo = "Inserimento Apertura Seggio";
                break;
            case "C":
                titolo = "Inserimento Costituzione Seggio";
                break;
            case "3C":
                titolo = "Inserimento Chiusura Seggio";
                break;
        }
        modelAndView.addObject("titlepage", titolo);
        modelAndView.addObject("tipo",tipo);
        return modelAndView;
    }



}
