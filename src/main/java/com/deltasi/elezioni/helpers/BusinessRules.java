package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.model.risultati.Preferenze;
import com.deltasi.elezioni.model.risultati.Voti;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import sun.security.util.ManifestEntryVerifier;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Component
public class BusinessRules {


    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    IVotiService votiService;

    @Autowired
    IPreferenzeService preferenzeService;

    @Autowired
    IAbilitazioniService abilitazioniService;

    @Autowired
    ISezioneService sezioneService;


    public String IsInsertable(Integer sezione, String codiceFase, Integer cabina, Integer idtipoelezione) {
        //    Integer idtipoelezione = Integer.parseInt(env.getProperty("tipoelezioneid"));
        String message = "";
        FaseElezione fase = abilitazioniService.findByCodiceAndTipoelezioneId(codiceFase, idtipoelezione);
        if (fase.getAbilitata().equals(0)) {
            return "Funzionalità non abilitata";
        }
        if(cabina != 0) {
            Sezione sezioneControllo = sezioneService.findByNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
            if (sezioneControllo != null) {
                if (!(sezioneControllo.getCabina().equals(cabina))) {
                    return "cabina sezione non corrette";
                }
            } else {
                return " sezione non corretta";
            }
        }
        Affluenza affluenza = affluenzaService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
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
            case "RAP":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getApertura1() != null && affluenza.getApertura1().equals(0)) {
                    return "Apertura non inserita usare funzione inserimento";
                }
                if (affluenza.getAffluenza1() != null && affluenza.getAffluenza1().equals(1)) {
                    return "Affluenza già inserita impossibile annullare";
                }
                if ((affluenza.getCostituzione1() == null) || (affluenza.getCostituzione1().equals(0))) {
                    return "Manca Costituzione";
                }
                if (affluenza.getApertura1().equals(0)) {
                    return message;
                }
                break;
            case "CO":
                if (affluenza == null) {
                    return message;
                }
                if (affluenza != null) {
                    if (affluenza.getCostituzione1().equals(1)) {
                        return "Costituzione già inserita usare rettitifica";
                    }
                }
                if (affluenza.getApertura1() != null && affluenza.getApertura1().equals(1)) {
                    return "Apertura inserita";
                }
                break;
            case "RCO":
                if (affluenza == null) {
                    return "Costituzione non effettuata usare inserimento";
                }
                if (affluenza.getApertura1() != null && affluenza.getApertura1().equals(1)) {
                    return "Apertura già inserita impossibile annullare costituzione";
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
            case "R1A":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza1() == null || affluenza.getAffluenza1().equals(0)) {
                    return "1 Affluenza non registrata usare inserimento";
                }
                if (affluenza.getAffluenza2() != null && affluenza.getAffluenza2().equals(1)) {
                    return "2 Affluenza inserita impossibile annullare";
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
            case "R2A":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza2() == null || affluenza.getAffluenza2().equals(0)) {
                    return "2 Affluenza non registrata usare inserimento";
                }
                if ((affluenza.getAffluenza1() == null) || (affluenza.getAffluenza1().equals(0))) {
                    return "Manca 1 Affluenza";
                }
                if (affluenza.getAffluenza3() != null && affluenza.getAffluenza3().equals(1)) {
                    return "3 Affluenza inserita impossibile annullare";
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
            case "R3C":
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza3() == null || affluenza.getAffluenza3().equals(0)) {
                    return "Chiusura non registrata usare inserimento";
                }
                break;
            case "VL":
                List<Voti> lvoti = votiService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza3() == null || affluenza.getAffluenza3().equals(0)) {
                    return "Chiusura non registrata";
                }
                if (lvoti != null && lvoti.size() > 0) {
                    return "Scrutinio già registrato usare rettifica";
                }
                break;
            case "RVL":
                List<Voti> lvotir = votiService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza3() == null || affluenza.getAffluenza3().equals(0)) {
                    return "Chiusura non registrata";
                }
                if ((lvotir == null) || (lvotir.size() == 0)) {
                    return "Scrutinio non registrato usare inserimento";
                }
                break;
            case "PE":
                List<Voti> lvotip = votiService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
                List<Preferenze> lpreferenze = preferenzeService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza3() == null && affluenza.getAffluenza3().equals(0)) {
                    return "Chiusura non registrata";
                }
                if ((lvotip == null) || (lvotip.size() == 0)) {
                    return "Scrutinio non registrato impossibile inserire preferenze";
                }
                if (lpreferenze != null && lpreferenze.size() > 0) {
                    return "Preferenze già registrate usare rettifica";
                }
                break;
            case "RPE":
                List<Preferenze> rlpreferenze = preferenzeService.findBySezioneNumerosezioneAndTipoelezioneId(sezione, idtipoelezione);
                if (affluenza == null) {
                    return "Sezione non costitutita";
                }
                if (affluenza.getAffluenza3() == null || affluenza.getAffluenza3().equals(0)) {
                    return "Chiusura non registrata";
                }
                if ((rlpreferenze == null) || (rlpreferenze.size() == 0)) {
                    return "Preferenze non registrate usare inserimento";
                }
                // todo aggiungere controllo preferenze
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
                }
            case "R2A":
                switch (tipo) {
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
                }
            case "R1A":
                switch (tipo) {
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
                }
            case "RAP":
                switch (tipo) {
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
                }
            case "RCO":
                switch (tipo) {
                    case "A":
                    case "M":
                        titolo = "Annullamento Costituzione Seggio";
                        break;
                }
                break;
            case "3C":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento Chiusura Seggio";
                        break;
                }
            case "VL":
                switch (tipo) {
                    case "I":
                        titolo = "Inserimento Voti Lista";
                        break;
                }
            case "R3C":
                switch (tipo) {
                    case "M":
                        titolo = "Modifica Chiusura Seggio";
                        break;
                    case "A":
                        titolo = "Annullamento Chiusura Seggio";
                        break;
                }
                break;
            case "RVL":
                titolo = "Rettifica Voti Lista";
                break;

            case "AVL":
                titolo = "Annullamento Voti Lista";
                break;
            case "RIC":
                titolo = "Ricalcolo Affluenze";
                break;
            case "RIL":
                titolo = "Ricalcolo Voti Lista";
                break;
            case "RIP":
                titolo = "Ricalcolo Preferenze";
                break;
            case "RIA":
                titolo = "Ricalcolo Costituzione Apertura";
                break;

        }
        return titolo;
    }
}
