/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.controllers;


import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.deltasi.elezioni.contracts.IAuthorityService;
import com.deltasi.elezioni.contracts.IUserExtendedService;
import com.deltasi.elezioni.contracts.IUserService;
import com.deltasi.elezioni.model.authentication.Authorities;
import com.deltasi.elezioni.model.authentication.User;
import com.deltasi.elezioni.model.authentication.UserExtended;
import com.deltasi.elezioni.model.authentication.UserJsonResponse;
import com.deltasi.elezioni.model.json.UserJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    IUserService userservice;

    @Autowired
    IUserExtendedService userExtendedService;

    @Autowired
    IAuthorityService authorityservice;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/manage")
    public ModelAndView index(Model model, Principal principal) {

        List<User> list = null;
        ModelAndView modelAndView = new ModelAndView("users/manage");
        modelAndView.addObject("titlepage", "Amministrazione");
        try {
            list = userservice.getAllUtenti();
            modelAndView.addObject("Users", list);
            modelAndView.addObject("userscount", list.size());
        } catch (Exception ex) {
            String error = ex.getMessage();
            ModelAndView errormodelAndView = new ModelAndView("common/error");
            errormodelAndView.addObject("titlepage", "Pagina Errore");
            errormodelAndView.addObject("Error", error);
            return errormodelAndView;
        }

        return modelAndView;
        /* model.addAttribute("titlepage", "Homepage");
    model.addAttribute("message", "You are logged in as " + principal.getName());
    return "users/manage.html";*/
    }

    @PostMapping(value = "/view", produces = {MediaType.APPLICATION_JSON_VALUE})
    // @ResponseBody
    public @ResponseBody
    UserJsonResponse viewUser(@RequestParam("id") String id) {

        Integer idf = Integer.parseInt(id);
        Map<String, String> errors = null;
        UserJsonResponse response = new UserJsonResponse();
        try {
            User user = userservice.getUtente(idf);
            response.setValidated(true);
            response.setUser(user);
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/register", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView register(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("users/register", "user", new User());
        modelAndView.addObject("titlepage", "Registrazione utente");
        return modelAndView;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    // @ResponseBody
    public @ResponseBody
    UserJsonResponse AddUser(@ModelAttribute UserJson user,
                             BindingResult result, ModelMap mode) {

        UserJsonResponse response = new UserJsonResponse();
        User userModel  = new User();
        UserExtended userExtended = new UserExtended();
        Map<String, String> errors = null;
        try {
            if (result.hasErrors()) {
                errors = result.getFieldErrors().stream()
                        .collect(
                                Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                        );

                response.setValidated(false);
                response.setErrorMessages(errors);
            }
            User useripo = userservice.getByUsername(user.getUsername().toLowerCase());
            if (useripo != null && useripo.getUsername() != null) {
                errors = new HashMap<String, String>();
                errors.put("Errore in archivio", "Username già esistente");
                response.setValidated(false);
                response.setErrorMessages(errors);
            } else {
                String passwordhash = user.getPassword();
                userModel.setPassword(passwordEncoder.encode(passwordhash));
                userModel.setUsername(user.getUsername().toLowerCase());
                userModel.setEnabled(true);
                userModel.setMailaziendale(user.getMailaziendale());
                userservice.addUtente(userModel);
                Authorities authority = new Authorities();
                authority.setAuthority("USER");
                authority.setUser(userModel);
                authorityservice.addUtenteToAuthority(authority);
                response.setValidated(true);
                response.setUser(userModel);
                userExtended.setUser(userModel);
                userExtended.setCognome(user.getCognome());
                userExtended.setNome(user.getNome());
                userExtended.setSesso(user.getSesso());
                userExtended.setCodicefiscale(user.getCodiceficale());
                userExtendedService.addUtente(userExtended);
            }
        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/modify", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = (MediaType.APPLICATION_JSON_VALUE))
    // @ResponseBody
    public @ResponseBody
    UserJsonResponse ModifyUser(@RequestBody User user,
                                BindingResult result, ModelMap mode) {

        UserJsonResponse response = new UserJsonResponse();
        Map<String, String> errors = null;
        try {
            if (result.hasErrors()) {
                errors = result.getFieldErrors().stream()
                        .collect(
                                Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
                        );
                response.setValidated(false);
                response.setErrorMessages(errors);
                return response;
            }
            User useripo = userservice.getByUsername(user.getUsername().toLowerCase());
            Boolean ok = true;
            if (useripo.getId() == user.getId()) {
                ok = true;
            } else if (useripo.getUsername() == user.getUsername().toLowerCase()) {
                ok = false;
                errors = new HashMap<String, String>();
                errors.put("Errore in archivio", "Username già esistente");
                response.setValidated(false);
                response.setErrorMessages(errors);
            }
            if (ok == true) {
                String passwordhash = user.getPassword();
                user.setPassword(passwordEncoder.encode(passwordhash));
                user.setUsername(user.getUsername().toLowerCase());
                userservice.updateUtente(user);
                response.setValidated(true);
                response.setUser(user);
            }


        } catch (Exception ex) {
            errors = new HashMap<String, String>();
            errors.put("Errrore in banca dati", ex.getMessage());
            response.setValidated(false);
            response.setErrorMessages(errors);
        }
        return response;
    }
}

