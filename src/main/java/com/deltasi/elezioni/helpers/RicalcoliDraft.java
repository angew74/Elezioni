package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.state.SessionStateHelper;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class RicalcoliDraft {

    private static final Logger logger = LogManager.getLogger(RicalcoliDraft.class);

    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    ITipoRicalcoloService tipoRicalcoloService;

    @Autowired
    ISezioneService sezioniService;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    IIscrittiService iscrittiService;


    @Autowired
    private Environment env;

    public List<RicalcoloAffluenza> Affluenza(String aggregazione, String codice) {
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<RicalcoloAffluenza> complete = new ArrayList<RicalcoloAffluenza>();
        try {
            switch (codice) {
                case "AF1":
                    switch (aggregazione) {
                        case "MUN":
                            complete = affluenzaService.countAffluenza1ByMunicipio(tipoelezioneid);
                            List<Iscritti> liscritti = iscrittiService.countIscrittiSezioniPervenuteMunicipioAffluenza1(tipoelezioneid);
                            CalcolaRicalcolo(complete, codice, liscritti,1);
                            break;
                        case "COM":
                            List<Long> comune = affluenzaService.countByAffluenza1AndTipoelezioneIdAndTipoelezioneIdIn(1, tipoelezioneid, tipoelezioneid);
                            complete = affluenzaService.countAffluenza1(tipoelezioneid);
                            List<Iscritti> liscrittic = iscrittiService.countIscrittiSezioniPervenuteAllAffluenza3(tipoelezioneid);
                            CalcolaRicalcoloAll(comune,complete, codice,liscrittic, 1);
                            break;
                        case "SEZ":
                            break;
                    }
                    break;
                case "AF2":
                    switch (aggregazione) {
                        case "MUN":
                            complete = affluenzaService.countAffluenza2ByMunicipio(tipoelezioneid);
                            List<Iscritti> liscritti = iscrittiService.countIscrittiSezioniPervenuteMunicipioAffluenza2(tipoelezioneid);
                            CalcolaRicalcolo(complete, codice, liscritti,2);
                            break;
                        case "COM":
                            List<Long> comune = affluenzaService.countByAffluenza2AndTipoelezioneIdAndTipoelezioneIdIn(1, tipoelezioneid, tipoelezioneid);
                            List<Iscritti> liscrittic = iscrittiService.countIscrittiSezioniPervenuteAllAffluenza3(tipoelezioneid);
                            complete = affluenzaService.countAffluenza2(tipoelezioneid);
                            CalcolaRicalcoloAll(comune,complete, codice,liscrittic, 2);
                            break;
                        case "SEZ":
                            break;
                    }
                    break;
                case "AF3":
                    switch (aggregazione) {
                        case "MUN":
                            complete = affluenzaService.countAffluenza3ByMunicipio(tipoelezioneid);
                            List<Iscritti> liscritti = iscrittiService.countIscrittiSezioniPervenuteMunicipioAffluenza3(tipoelezioneid);
                            CalcolaRicalcolo(complete, codice,liscritti, 3);
                            break;
                        case "COM":
                            List<Long> comune = affluenzaService.countByAffluenza3AndTipoelezioneIdAndTipoelezioneIdIn(1, tipoelezioneid, tipoelezioneid);
                            complete = affluenzaService.countAffluenza3(tipoelezioneid);
                            List<Iscritti> liscrittic = iscrittiService.countIscrittiSezioniPervenuteAllAffluenza3(tipoelezioneid);
                            CalcolaRicalcoloAll(comune,complete, codice, liscrittic,3);
                            break;
                        case "SEZ":
                            break;
                    }
                    break;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return complete;
    }

    private void CalcolaRicalcoloAll(List<Long> comune,List<RicalcoloAffluenza> l, String codice,List<Iscritti> liscritti, int i) {
        LocalDateTime oggi = LocalDateTime.now();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        TipoRicalcolo t = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, codice).get(0);
        List<Long> sezioni = sezioniService.countAllByTipoelezioneIdAndTipoelezioneIdIn(tipoelezioneid, tipoelezioneid);
        RicalcoloAffluenza c = l.get(0);
        c.setDataoperazione(oggi);
        c.setUtenteoperazione(user);
        c.setMunicipio(99);
        Long totale = comune.get(0);
        int perv =Integer.parseInt(comune.get(0).toString());
        int num = Integer.parseInt(sezioni.get(0).toString());
        String perctot = calculatePercentage(perv , num);
        c.setNumerosezioni(perv);
        c.setTotalesezioni(num);
        c.setPercentualepervenute(perctot);
        c.setTipoelezione(tipoElezione);
        c.setTiporicalcolo(t);
        Integer imaschi = liscritti.get(0).getIscrittimaschi();
        Integer ifemmine = liscritti.get(0).getIscrittifemmine();
        Integer itotali = liscritti.get(0).getIscrittitotali();
        String perm = calculatePercentage(c.getAffluenzamaschi() , imaschi);
        String perf = calculatePercentage(c.getAffluenzafemmine(), ifemmine);
        String pert = calculatePercentage(c.getAffluenzatotale(), itotali);
        c.setIscrittimaschi(imaschi);
        c.setIscrittifemmine(ifemmine);
        c.setIscrittitotali(itotali);
        c.setPercentualemaschi(perm);
        c.setPercentualefemmine(perf);
        c.setPercentualetotale(pert);
        c.setNumeroaffluenza(i);
    }

    private void CalcolaRicalcolo(List<RicalcoloAffluenza> complete, String codice, List<Iscritti> liscritti, int n) {
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        List<TipoRicalcolo> tt = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, codice);
        TipoRicalcolo t = tt.get(0);
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (int m = 0; m < complete.size(); m++) {
            int municipio = complete.get(m).getMunicipio();
            List<Long> sezionimun = sezioniService.countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(tipoelezioneid, municipio, tipoelezioneid);
            Long totale = sezionimun.get(0);
            complete.get(m).setTotalesezioni(Integer.parseInt(totale.toString()));
            complete.get(m).setDataoperazione(oggi);
            complete.get(m).setUtenteoperazione(user);
            int perv = complete.get(m).getNumerosezioni();
            String perctot = calculatePercentage(perv , totale);
            complete.get(m).setPercentualepervenute(perctot);
            Integer imaschi = liscritti.get(m).getIscrittimaschi();
            Integer ifemmine = liscritti.get(m).getIscrittifemmine();
            Integer itotali = liscritti.get(m).getIscrittitotali();
            String perm =calculatePercentage(complete.get(m).getAffluenzamaschi() , imaschi);
            String perf =calculatePercentage(complete.get(m).getAffluenzafemmine(), ifemmine);
            String pert =calculatePercentage(complete.get(m).getAffluenzatotale() , itotali);
            complete.get(m).setPercentualemaschi(perm);
            complete.get(m).setPercentualefemmine(perf);
            complete.get(m).setIscrittimaschi(imaschi);
            complete.get(m).setIscrittifemmine(ifemmine);
            complete.get(m).setIscrittitotali(itotali);
            complete.get(m).setPercentualetotale(pert);
            complete.get(m).setTiporicalcolo(t);
            complete.get(m).setTipoelezione(tipoElezione);
            complete.get(m).setNumeroaffluenza(n);
        }
    }
    public String calculatePercentage(double obtained, double total) {
        double percentage = obtained * 100 / total;
        NumberFormat nf = NumberFormat.getInstance(); // get instance
        nf.setMaximumFractionDigits(2); // set decimal places
        String s = nf.format(percentage);
        return  s;
    }

    public List<RicalcoloCostApertura> costApertura(String aggregazione, String codice) {
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        List<RicalcoloCostApertura> complete = new ArrayList<RicalcoloCostApertura>();
        List<Iscritti> liscritti = new ArrayList<>();
        try {
            switch (codice) {
                case "AP1":
                    switch (aggregazione) {
                        case "MUN":
                            complete = affluenzaService.countApertura1ByMunicipio(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteMunicipioApertura1(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                        case "SEZ":
                            break;
                        case "COM":
                            complete = affluenzaService.countApertura1(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteAllApertura1(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                    }
                    break;
                case "AP2":
                    switch (aggregazione) {
                        case "MUN":
                            complete = affluenzaService.countApertura2ByMunicipio(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteMunicipioApertura2(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                        case "SEZ":
                            break;
                        case "COM":
                            complete = affluenzaService.countApertura2(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteAllApertura2(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                    }
                    break;
                case "CO1":
                    switch (aggregazione) {
                        case "MUN":
                            complete = affluenzaService.countCostituzione1ByMunicipio(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteMunicipioCostituzione1(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                        case "SEZ":
                            break;
                        case "COM":
                            complete = affluenzaService.countCostituzione1(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteAllCostituzione1(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                    }
                    break;
                case "CO2":
                    switch (aggregazione) {
                        case "MUN":
                            complete= affluenzaService.countCostituzione2(tipoelezioneid);
                            liscritti = iscrittiService.countIscrittiSezioniPervenuteAllCostituzione2(tipoelezioneid);
                            CalcolaRicalcoloCostituzione(complete, codice,liscritti);
                            break;
                        case "SEZ":
                            break;
                        case "COM":
                            break;
                    }
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
        return complete;
    }

    private void CalcolaRicalcoloCostituzione(List<RicalcoloCostApertura> l, String codice, List<Iscritti> iiscritti) {
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        List<TipoRicalcolo> tt = tipoRicalcoloService.findAllByTipoelezioneIdAndCodice(tipoelezioneid, codice);
        TipoRicalcolo t = tt.get(0);
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (int m = 0; m < l.size(); m++) {
            int municipio = l.get(m).getMunicipio();
            List<Long> sezionimun = sezioniService.countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(tipoelezioneid, municipio, tipoelezioneid);
            Long totale = sezionimun.get(0);
            l.get(m).setNumerosezioni(Integer.parseInt(totale.toString()));
            l.get(m).setDataoperazione(oggi);
            l.get(m).setUtenteoperazione(user);
            l.get(m).setTipoelezione(tipoElezione);
            l.get(m).setTiporicalcolo(t);
            String perc =calculatePercentage(l.get(m).getNumerocostituite() ,l.get(m).getNumerosezioni());
            String pera =calculatePercentage(l.get(m).getNumeroaperte() ,l.get(m).getNumerosezioni());
            l.get(m).setPercentualeaperte(pera);
            l.get(m).setPercentualecostituite(perc);
            l.get(m).setIscrittitotali(iiscritti.get(m).getIscrittitotali());
        }
    }
}
