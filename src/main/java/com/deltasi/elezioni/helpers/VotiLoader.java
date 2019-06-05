package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.json.CandidatoJson;
import com.deltasi.elezioni.model.json.ListaJson;
import com.deltasi.elezioni.model.json.ListaSemplice;
import com.deltasi.elezioni.model.json.VotiJson;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.*;
import com.deltasi.elezioni.service.VotiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class VotiLoader {
    private static final Logger logger = LogManager.getLogger(AffluenzaLoader.class);
    @Autowired
    ISezioneService sezioneService;

    @Autowired
    private Environment env;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    ICandidatoService candidatoService;

    @Autowired
    IIscrittiService iIscrittiService;

    @Autowired
    IListaService listaService;

    @Autowired
    IVotiService votiService;

    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    IPreferenzeService preferenzeService;


    public  List<Voti> prepareVoti(List<ListaSemplice> list) {
        List<Voti> votiList = new ArrayList<Voti>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        Sezione sezione = sezioneService.findByNumerosezioneAndTipoelezioneId(list.get(0).getNumerosezione(), tipoelezioneid);
        for (ListaSemplice l:  list) {
            Voti v = new Voti();
            v.setDataoperazione(oggi);
            v.setNumerovoti(l.getVoti());
            v.setUtenteoperazione(user);
            v.setSezione(sezione);
            v.setTipoelezione(tipoElezione);
            Lista lista = listaService.findById(l.getIdlista());
            v.setLista(lista);
            votiList.add(v);
        }
        return  votiList;
    }

    public  List<Voti> prepareVotiR(List<ListaSemplice> list) {
        List<Voti> votiList = new ArrayList<Voti>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (ListaSemplice l:  list) {
            Voti v = votiService.findById(l.getId());
            v.setDataoperazione(oggi);
            v.setNumerovoti(l.getVoti());
            v.setUtenteoperazione(user);
            votiList.add(v);
        }
        return  votiList;
    }

    public List<Preferenze> preparePreferenze(List<CandidatoJson> candidati)
    {
        List<Preferenze> preferenzeList = new ArrayList<Preferenze>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        Sezione sezione = sezioneService.findByNumerosezioneAndTipoelezioneId(candidati.get(0).getNumerosezione(), tipoelezioneid);
        Lista lista = listaService.findById(candidati.get(0).getIdlista());
        for (CandidatoJson c:  candidati) {
            Preferenze p = new Preferenze();
            p.setDataoperazione(oggi);
            p.setNumerovoti(c.getNumerovoti());
            p.setUtenteoperazione(user);
            p.setSezione(sezione);
            p.setTipoelezione(tipoElezione);
            Candidato candidato = candidatoService.findById(c.getIdcandidato());
            p.setCandidato(candidato);
            p.setMunicipio(sezione.getMunicipio());
            p.setLista(lista);
            preferenzeList.add(p);
        }
        return  preferenzeList;
    }

    public List<Preferenze> preparePreferenzeR(List<CandidatoJson> candidati) {
        List<Preferenze> preferenzeList = new ArrayList<Preferenze>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (CandidatoJson c:  candidati) {
            Preferenze p = preferenzeService.findById(c.getId());
            p.setDataoperazione(oggi);
            p.setNumerovoti(c.getNumerovoti());
            p.setUtenteoperazione(user);
            preferenzeList.add(p);
        }
        return  preferenzeList;
    }

    public RicalcoloVoti votiSplit(Voti v, String tipoInterrogazione) {
        RicalcoloVoti r = new RicalcoloVoti();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        Iscritti i = iIscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid,v.getSezione().getNumerosezione());
        Affluenza a = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(v.getSezione().getNumerosezione(),tipoelezioneid,1);
        try {
         r.setMunicipio(v.getSezione().getMunicipio());
         r.setSezione(v.getSezione().getNumerosezione());
         r.setNumerovoti(v.getNumerovoti());
         r.setVotantipervenute(a.getVotantitotali3());
         r.setPercentualevoti(calculatePercentage(r.getNumerovoti(),r.getVotantipervenute()));
         r.setIscrittipervenute(i.getIscrittitotaligen());
         r.setPercentualevotantipervenute(calculatePercentage(r.getVotantipervenute(),r.getIscrittipervenute()));
         r.setDenominazioneLista(v.getLista().getDenominazione());
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }
        return r;
    }

    public String calculatePercentage(double obtained, double total) {
        double percentage = obtained * 100 / total;
        NumberFormat nf = NumberFormat.getInstance(); // get instance
        nf.setMaximumFractionDigits(2); // set decimal places
        String s = nf.format(percentage);
        return s;
    }

    public RicalcoloPreferenze preferenzeSplit(Preferenze v, String tipoInterrogazione) {
        RicalcoloPreferenze r = new RicalcoloPreferenze();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        Iscritti i = iIscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid,v.getSezione().getNumerosezione());
        Affluenza a = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(v.getSezione().getNumerosezione(),tipoelezioneid,1);
        try {
            r.setMunicipio(v.getSezione().getMunicipio());
            r.setSezione(v.getSezione().getNumerosezione());
            r.setNumerovoti(v.getNumerovoti());
            Voti c = votiService.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(v.getLista().getId(),v.getSezione().getNumerosezione(), tipoelezioneid);
            r.setVotantipervenute(c.getNumerovoti());
            r.setPercentualevoti(calculatePercentage(r.getNumerovoti(),r.getVotantipervenute()));
            r.setIscrittipervenute(i.getIscrittitotaligen());
            r.setPercentualevotantipervenute(calculatePercentage(r.getVotantipervenute(),r.getIscrittipervenute()));
            r.setDenominazioneLista(v.getLista().getDenominazione());
            r.setDenominazioneCandidato(v.getCandidato().getNome() + " " + v.getCandidato().getCognome());
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }
        return r;
    }

    public  VotiJson ConvertToJson(List<Voti> l, int sezione,String tipo)    {
        List<ListaJson> listaJsons = new ArrayList<ListaJson>();
        VotiJson json = new VotiJson();
        for (Voti v : l) {
            ListaJson j = new ListaJson();
            j.setId(v.getId());
            j.setDenominazione(v.getLista().getDenominazione());
            j.setProgressivo(v.getLista().getProgressivo());
            j.setVoti(v.getNumerovoti());
            j.setNumerosezione(sezione);
            j.setTipo(tipo);
            j.setIdlista(v.getLista().getId());
            listaJsons.add(j);
        }
        json.setListe(listaJsons);
        return  json;
    }
}
