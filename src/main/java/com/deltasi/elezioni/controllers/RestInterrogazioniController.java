package com.deltasi.elezioni.controllers;


import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.helpers.AffluenzaLoader;
import com.deltasi.elezioni.helpers.RicalcoliDraft;
import com.deltasi.elezioni.helpers.VotiLoader;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.model.risultati.Preferenze;
import com.deltasi.elezioni.model.risultati.Voti;
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
    private VotiLoader votiLoader;

    @Autowired
    private IVotiService votiService;

    @Autowired
    private IPreferenzeService preferenzeService;


    @Autowired
    private IRicalcoloCostAperturaService ricalcoloCostAperturaService;

    @Autowired
    private AffluenzaLoader affluenzaLoader;

    @Autowired
    private ITipoRicalcoloService tipoRicalcoloService;

    @Autowired
    private IRicalcoloVotiService ricalcoloVotiService;

    @Autowired
    private IRicalcoloPreferenzeService ricalcoloPreferenzeService;


    @GetMapping(value = "/affluenza/{aggregazione}/{tipoInterrogazione}/{sezione}/{plesso}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RicalcoloAffluenza> affluenza(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoInterrogazione")
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
            switch (aggregazione) {
                case "MUN":
                    l = ricalcoloAffluenzaService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99);
                    break;
                case "COM":
                    l = ricalcoloAffluenzaService.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99);
                    break;
                case "SEZ":
                    int n = Integer.parseInt(sezione.get());
                    switch (tipoInterrogazione) {
                        case "AF1":
                            b = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza1(n, tipoelezioneid, 1);
                            break;
                        case "AF2":
                            b = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza2(n, tipoelezioneid, 1);
                            break;
                        case "CHI":
                            b = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(n, tipoelezioneid, 1);
                    }
                    RicalcoloAffluenza af = affluenzaLoader.affluenzaSplit(b, tipoInterrogazione);
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
                    for (Affluenza aff : listAff
                    ) {
                        RicalcoloAffluenza r = affluenzaLoader.affluenzaSplit(aff, tipoInterrogazione);
                        l.add(r);
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

    @GetMapping(value = "/voti/{aggregazione}/{tipoInterrogazione}/{sezione}/{plesso}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RicalcoloVoti> voti(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoInterrogazione")
            String tipoInterrogazione, @PathVariable("sezione") Optional<String> sezione,
                                    @PathVariable("plesso") Optional<String> plesso
    ) {
        Map<String, String> errors = null;
        List<RicalcoloVoti> l = new ArrayList<RicalcoloVoti>();
        List<Voti> b = new ArrayList<Voti>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<TipoRicalcolo> tipiRicalcolo = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, tipoInterrogazione);
        try {
            switch (aggregazione) {
                case "MUN":
                    l = ricalcoloVotiService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99);
                    break;
                case "COM":
                    l = ricalcoloVotiService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99);
                    break;
                case "SEZ":
                    int n = Integer.parseInt(sezione.get());
                    b = votiService.findBySezioneNumerosezioneAndTipoelezioneId(n, tipoelezioneid);
                    for (Voti v : b
                    ) {
                        RicalcoloVoti r = votiLoader.votiSplit(v, tipoInterrogazione);
                        l.add(r);
                    }
                    break;
                case "PLE":
                    int p = Integer.parseInt(plesso.get());
                    b = votiService.findBySezionePlessoIdAndTipoelezioneId(p, tipoelezioneid);
                    for (Voti v : b
                    ) {
                        RicalcoloVoti r = votiLoader.votiSplit(v, tipoInterrogazione);
                        l.add(r);
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


    @GetMapping(value = "/preferenze/{aggregazione}/{tipoInterrogazione}/{sezione}/{plesso}/{idlista}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RicalcoloPreferenze> preferenze(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoInterrogazione")
            String tipoInterrogazione, @PathVariable("sezione") Optional<String> sezione,
                                          @PathVariable("plesso") Optional<String> plesso,
                                          @PathVariable("idlista") String idlista
    ) {
        Map<String, String> errors = null;
        List<RicalcoloPreferenze> l = new ArrayList<RicalcoloPreferenze>();
        List<Preferenze> b = new ArrayList<Preferenze>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<TipoRicalcolo> tipiRicalcolo = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, tipoInterrogazione);
        try {
            int id = Integer.parseInt(idlista);
            switch (aggregazione) {
                case "MUN":
                    l = ricalcoloPreferenzeService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99,id);
                    break;
                case "COM":
                    l = ricalcoloPreferenzeService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoelezioneid, tipiRicalcolo.get(0).getId(),99, id);
                    break;
                case "SEZ":
                    int n = Integer.parseInt(sezione.get());
                    b = preferenzeService.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(id,n, tipoelezioneid);
                    for (Preferenze v : b
                    ) {
                        RicalcoloPreferenze r = votiLoader.preferenzeSplit(v, tipoInterrogazione);
                        l.add(r);
                    }
                    break;
                case "PLE":
                   throw new Exception("ricerca non implementata");
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


    @GetMapping(value = "/costituzione/{aggregazione}/{tipoInterrogazione}/{sezione}/{plesso}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RicalcoloCostApertura> costituzione(@PathVariable("aggregazione") String aggregazione, @PathVariable("tipoInterrogazione")
            String tipoInterrogazione, @PathVariable("sezione") Optional<String> sezione,
                                                    @PathVariable("plesso") Optional<String> plesso
    ) {
        Map<String, String> errors = null;
        List<RicalcoloCostApertura> l = new ArrayList<RicalcoloCostApertura>();
        Affluenza b = new Affluenza();
        List<Affluenza> listAff = new ArrayList<>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<TipoRicalcolo> tipiRicalcolo = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, tipoInterrogazione);
        try {
            switch (aggregazione) {
                case "MUN":
                    l = ricalcoloCostAperturaService.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99);
                    break;
                case "COM":
                    l = ricalcoloCostAperturaService.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoelezioneid, tipiRicalcolo.get(0).getId(), 99);
                    break;
                case "SEZ":
                    int n = Integer.parseInt(sezione.get());
                    switch (tipoInterrogazione) {
                        case "CO1":
                            b = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndCostituzione1(n, tipoelezioneid, 1);
                            break;
                        case "AP1":
                            b = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndApertura1(n, tipoelezioneid, 1);
                            break;
                    }
                    RicalcoloCostApertura af = affluenzaLoader.costituzioneSplit(b, tipoInterrogazione);
                    l.add(af);
                    break;
                case "PLE":
                    int p = Integer.parseInt(plesso.get());
                    switch (tipoInterrogazione) {
                        case "CO1":
                            listAff = affluenzaService.findBySezionePlessoIdAndTipoelezioneIdAndCostituzione1(p, tipoelezioneid, 1);
                            break;
                        case "AP1":
                            listAff = affluenzaService.findBySezionePlessoIdAndTipoelezioneIdAndApertura1(p, tipoelezioneid, 1);
                            break;
                    }
                    for (Affluenza aff : listAff
                    ) {
                        RicalcoloCostApertura r = affluenzaLoader.costituzioneSplit(aff, tipoInterrogazione);
                        l.add(r);
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
