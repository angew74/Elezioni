package com.deltasi.elezioni.controllers;

import com.deltasi.elezioni.helpers.BusinessRules;
import com.deltasi.elezioni.model.json.*;
import com.deltasi.elezioni.model.risultati.Candidato;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.risultati.Preferenze;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.service.CandidatoService;
import com.deltasi.elezioni.service.ListaService;
import com.deltasi.elezioni.service.PreferenzeService;
import com.deltasi.elezioni.service.VotiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/preferenze")
public class PreferenzeController {

    private static final Logger logger = LogManager.getLogger(VotiController.class);

    @Autowired
    private Environment env;

    @Autowired
    BusinessRules businessRules;

    @Autowired
    ListaService listaService;

    @Autowired
    VotiService votiService;

    @Autowired
    CandidatoService candidatoService;

    @Autowired
    PreferenzeService prefrenzeService;

    @GetMapping(value = "/inserimento/{tipo}")
    public ModelAndView inserimento(@PathVariable String tipo, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("preferenze/inserimento");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<CandidatoJson> candidatijson = new ArrayList<CandidatoJson>();
        CandidatiWrapper wrapper = new CandidatiWrapper();
        if (businessRules.IsEnabled(tipo, tipoelezioneid)) {
            String titolo = businessRules.getTitoloByFase(tipo, "I");
            modelAndView.addObject("titlepage", titolo);
            modelAndView.addObject("tipo", tipo);
            List<Lista> liste = new ArrayList<Lista>();
            liste = listaService.findAllByTipoelezioneId(tipoelezioneid);
            modelAndView.addObject("ListeCandidati", liste);
            modelAndView.addObject("CandidatiWrapper",wrapper);
            modelAndView.addObject("Candidati",candidatijson);
        } else {
            modelAndView = new ModelAndView("common/unauthorized");
            modelAndView.addObject("errMsg", "Fase non abilitata");
        }
        return modelAndView;
    }

    @GetMapping(value = "/spoglio/{idlista}/{tipo}/{sezione}")
    public ModelAndView spoglio(@PathVariable String idlista, @PathVariable String tipo, @PathVariable Integer sezione) {
        ModelAndView modelAndView = new ModelAndView("preferenze/spoglio");
        CandidatiWrapper wrapper = new CandidatiWrapper();
        CandidatiWrapper wrapperFull = new CandidatiWrapper();
        int count=0;
        String titolo = businessRules.getTitoloByFase(tipo, "I");
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        Integer id = Integer.parseInt(idlista);
        Lista l = listaService.findById(id);
        List<CandidatoJson> candidatijson = new ArrayList<CandidatoJson>();
        Voti v = votiService.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(id,sezione,tipoelezioneid);
        if (tipo.equals("RVL")) {
            List<Preferenze> p = prefrenzeService.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(id,sezione,tipoelezioneid);
            for (int i = 0; i < p.size(); i++) {
                CandidatoJson j = new CandidatoJson();
                j.setNumerosezione(sezione);
                j.setTipo(tipo);
                j.setIdlista(p.get(i).getLista().getId());
                j.setDenominazionelista(p.get(i).getLista().getDenominazione());
                j.setNome(p.get(i).getCandidato().getNome());
                j.setCognome(p.get(i).getCandidato().getCognome());
                j.setNumerovotilista(v.getNumerovoti());
                j.setNumerovoti(p.get(i).getNumerovoti());
                j.setId(p.get(i).getId());
                j.setIdcandidato(p.get(i).getCandidato().getId());
                j.setNomecognome(p.get(i).getCandidato().getNome() + " " + p.get(i).getCandidato().getCognome());
                candidatijson.add(j);
            }
            wrapperFull.setCandidati(candidatijson);
        }
        else {
            List<Candidato> candidatoes = candidatoService.findByListaIdAndTipoelezioneId(id,tipoelezioneid);
            for (int i = 0; i < candidatoes.size(); i++) {
                CandidatoJson j = new CandidatoJson();
                j.setNumerosezione(sezione);
                j.setTipo(tipo);
                j.setIdlista(id);
                j.setDenominazionelista(l.getDenominazione());
                j.setNome(candidatoes.get(i).getNome());
                j.setCognome(candidatoes.get(i).getCognome());
                j.setNumerovotilista(v.getNumerovoti());
                j.setIdcandidato(candidatoes.get(i).getId());
                j.setNomecognome(candidatoes.get(i).getNome() + " " + candidatoes.get(i).getCognome());
                candidatijson.add(j);
            }
            wrapper.setCandidati(candidatijson);        }


        count = candidatijson.size();
        modelAndView.addObject("titlepage", titolo);
        modelAndView.addObject("Count", count);
        modelAndView.addObject("CandidatiWrapper",wrapper);
        modelAndView.addObject("CandidatiWrapperFull", wrapperFull);
        return modelAndView;
    }
}
