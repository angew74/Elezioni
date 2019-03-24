package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.IAbilitazioniService;
import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.contracts.ITipoElezioneService;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import sun.security.util.ManifestEntryVerifier;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class BusinessRules {


    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    IAbilitazioniService abilitazioniService;


    public String IsInsertable(Integer sezione, String codiceFase, Integer idtipoelezione) {
        //    Integer idtipoelezione = Integer.parseInt(env.getProperty("tipoelezioneid"));
        String message = "";
        FaseElezione fase = abilitazioniService.findByCodiceAndTipoelezioneId(codiceFase, idtipoelezione);
        if (fase.getAbilitata().equals(0)) {
            return "Funzionalità non abilitata";
        }
        Affluenza affluenza = affluenzaService.findByNumerosezione(sezione);
        switch (codiceFase) {
            case "AP":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getApertura1() != null && affluenza.getApertura1().equals(1)) {
                    return "Affluenza già inserita usare rettifica";
                }
                if ((affluenza.getCostituzione1() == null) || (affluenza.getCostituzione1().equals(0))) {
                    return "Manca Costituzione";
                }
                break;
            case "CO":
                if(affluenza == null)
                {return  message;}
                if (affluenza != null) {
                    return "Costituzione già inserita usare rettitifica";
                }
                if (affluenza.getApertura1() != null && affluenza.getApertura1().equals(1)) {
                    return "Apertura inserita";
                }
                break;
            case "1A":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza1() != null && affluenza.getAffluenza1().equals(1)) {
                    return "1 Affluenza già registrata";
                }
                if ((affluenza.getApertura1() == null) || (affluenza.getApertura1().equals(0))) {
                    return "Manca Apertura";
                }
                break;
            case "2A":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza2() != null && affluenza.getAffluenza2().equals(1)) {
                    return "2 Affluenza già registrata";
                }
                if ((affluenza.getAffluenza1() == null) || (affluenza.getAffluenza1().equals(0))) {
                    return "Manca 1 Affluenza";
                }
                break;
            case "3C":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza3() != null && affluenza.getAffluenza3().equals(1)) {
                    return "Chiusura già registrata";
                }
                if ((affluenza.getAffluenza2() == null) || (affluenza.getAffluenza2().equals(0))) {
                    return "Manca 2 Affluenza";
                }
                break;
        }
        return message;
    }

    public boolean IsEnabled(String codiceFase, Integer idtipoelezione) {
        // Integer idtipoelezione = Integer.parseInt(env.getProperty("tipoelezioneid"));
        boolean vero = true;
        FaseElezione fase = abilitazioniService.findByCodiceAndTipoelezioneId(codiceFase, idtipoelezione);
        if (fase.getAbilitata().equals(0)) {
            return false;
        } else {
            return true;
        }
    }

    public String getTitoloByFase(String codice, String tipo) {
        String titolo = "Inserimento";
        switch (codice) {
            case "2A":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento 2 Affluenza Seggio";
                        break;
                    case "M":
                        titolo = "Modifica 2 Affluenza Seggio";
                        break;
                    case "A":
                        titolo = "Annullamento 2 Affluenza Seggio";
                        break;
                }
                break;
            case "1A":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento 1 Affluenza Seggio";
                        break;
                    case "A":
                        titolo = "Annullamento 1 Affluenza Seggio";
                        break;
                    case "M":
                        titolo = "Modifica 1 Affluenza Seggio";
                        break;
                }
                break;
            case "AP":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento Apertura Seggio";
                        break;
                    case "A":
                        titolo = "Annullamento Apertura Seggio";
                        break;
                }
                break;
            case "CO":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento Costituzione Seggio";
                        break;
                    case "A":
                        titolo = "Annullamento Costituzione Seggio";
                        break;
                }
                break;
            case "3C":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento Chiusura Seggio";
                        break;
                    case "M":
                        titolo = "Modifica Chiusura Seggio";
                        break;
                    case "A":
                        titolo = "Annullamento Chiusura Seggio";
                        break;
                }
                break;
        }
        return titolo;
    }
}
