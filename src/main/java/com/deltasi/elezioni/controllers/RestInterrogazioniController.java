package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.AffluenzaLoader;
import com.deltasi.elezioni.helpers.RicalcoliDraft;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/interrogazioni")
public class RestInterrogazioniController {

    private static final Logger logger = LogManager.getLogger(RestInterrogazioniController.class);

    @Autowired
    private Environment env;

    @Autowired
    RicalcoliDraft draft;

    @Autowired
    private IRicalcoloAffluenzaService ricalcoloAffluenzaService;

    @Autowired
    private IAffluenzaService affluenzaService;

    @Autowired
    private AffluenzaLoader affluenzaLoader;

    @Autowired
    private ITipoRicalcoloService tipoRicalcoloService;

    @Autowired
    private IRicalcoloVotiService ricalcoloVotiService;

    @Autowired
    private IRicalcoloPreferenzeService ricalcoloPreferenzeService;

    @GetMapping(value = "/affluenza/{aggregazione}/{tipoInterrogazione}/{sezione}/{plesso}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Secured("ROLE_ADMIN")
    public List<RicalcoloAffluenza> ricalcola(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoInterrogazione")
            String tipoInterrogazione, @PathVariable("sezione") Optional<String> sezione,
                                              @PathVariable("plesso") Optional<String> plesso
    ) {
        Map<String, String> errors = null;
        List<RicalcoloAffluenza> l = new ArrayList<RicalcoloAffluenza>();
        Affluenza b = new Affluenza();
        List<Affluenza> listAff = new ArrayList<>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<TipoRicalcolo> tipiRicalcolo = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, tipoInterrogazione);
        try {
            switch (aggregazione)
            {
                case "MUN":
                    l= ricalcoloAffluenzaService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(tipoelezioneid,tipiRicalcolo.get(0).getId(),99);
                    break;
                case "COM":
                   l = ricalcoloAffluenzaService.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoelezioneid,tipiRicalcolo.get(0).getId(),99);
                   break;
                case "SEZ":
                    int n = Integer.parseInt(sezione.get());
                    switch (tipoInterrogazione) {
                        case "AF1":
                        b= affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza1(n, tipoelezioneid, 1);
                        break;
                        case "AF2":
                        b= affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza2(n, tipoelezioneid, 1);
                        break;
                        case  "AF3":
                       b= affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(n, tipoelezioneid, 1);
                    }
                    RicalcoloAffluenza af = affluenzaLoader.affluenzaSplit(b,tipoInterrogazione);
                    l.add(af);
                    break;
                case "PLE":
                    int p = Integer.parseInt(plesso.get());
                    switch (tipoInterrogazione) {
                        case "AF1":
                            listAff = affluenzaService.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza1(p, tipoelezioneid, 1);
                            break;
                        case "AF2":
                            listAff = affluenzaService.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza2(p, tipoelezioneid, 1);
                            break;
                        case "AF3":
                            listAff = affluenzaService.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza3(p, tipoelezioneid, 1);
                            break;
                    }
                    break;
            }
        } catch (AccessDeniedException e) {
            logger.warn("Unauthorized", e);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Risorsa non trovata", ex);
        }
        return l;
    }

}
