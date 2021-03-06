/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.controllers;

import java.security.Principal;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.deltasi.elezioni.PDeltaUrlAuthenticationSuccessHandler;
import com.deltasi.elezioni.state.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class LoginController {


    @Autowired
    ConfigBean configBean;

    @Resource(name = "authenticationManager")
    private AuthenticationManager authManager;

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String dologin(@RequestParam("username") final String username, @RequestParam("password") final String password, Model model, final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authManager.authenticate(authReq);
        boolean isauth = auth.isAuthenticated();
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
        model.addAttribute("titlepage", "Homepage");
        String loggedInUserName = auth.getName();
        model.addAttribute("user", loggedInUserName);
        session.setAttribute("applicationName", configBean.getApplicationName());
        return "/home";

    }


    @GetMapping(value = "/login")
    public String login(Model model, Principal principal) {
        model.addAttribute("titlepage", "Login");
        return "login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model, Principal principal) {
        model.addAttribute("message",
                "La tua sessione è stata chiusa correttamente!");
        return "logout";

    }

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";

    }
}

