package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.contracts.IElegenService;
import com.deltasi.elezioni.contracts.IIscrittiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users")
public class AffluenzeController {

    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    IElegenService elegenService;

    @Autowired
    IIscrittiService iscrittiService;
}
