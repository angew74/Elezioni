package com.deltasi.elezioni.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class GeneralController {

    @GetMapping(value = "/home")
    public String index(Model model, Principal principal) {
        model.addAttribute("titlepage", "Homepage");
        String loggedInUserName = principal.getName();
        model.addAttribute("user", loggedInUserName);
        return "home";
    }


    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        String loggedInUserName = principal.getName();
        model.addAttribute("user", loggedInUserName);
        model.addAttribute("titlepage", "Amministrazione Home");
        return "admin";
    }

        @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
            model.addAttribute("titlepage", "Errore applicativo");
        return "error";

    }

}
