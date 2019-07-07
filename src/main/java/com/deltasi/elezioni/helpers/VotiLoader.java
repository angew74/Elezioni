package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.*;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.json.*;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVotiLista;
import com.deltasi.elezioni.model.risultati.*;
import com.deltasi.elezioni.state.SessionStateHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    ISindacoService sindacoService;


    @Autowired
    IVotiListaService votiListaService;

    @Autowired
    IVotiSindacoService votiSindacoService;


    @Autowired
    IVotiGeneraliService votiGeneraliService;


    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    IPreferenzeService preferenzeService;

    @Autowired
    SessionStateHelper stateHelper;


    public  HashSet<VotiLista> prepareVoti(List<ListaSemplice> list) {
        HashSet<VotiLista> votiList = new HashSet<>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        Sezione sezione = sezioneService.findByNumerosezioneAndTipoelezioneId(list.get(0).getNumerosezione(), tipoelezioneid);
        for (ListaSemplice l:  list) {
            VotiLista v = new VotiLista();
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

    public HashSet<VotiSindaco> prepareVotiSindaco(List<SindacoSimple> list, VotiGenerali vg) {
        HashSet<VotiSindaco> votiList = new HashSet<VotiSindaco>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        Sezione sezione = sezioneService.findByNumerosezioneAndTipoelezioneId(list.get(0).getNumerosezione(), tipoelezioneid);
        for (SindacoSimple l:  list) {
            VotiSindaco v = new VotiSindaco();
            v.setDataoperazione(oggi);
            v.setNumerovoti(l.getVoti());
            v.setNumerovotisolosindaco(l.getSolosindaco());
            v.setUtenteoperazione(user);
            v.setSezione(sezione);
            v.setTipoelezione(tipoElezione);
            Sindaco sindaco = sindacoService.findById(l.getIdsindaco());
            v.setSindaco(sindaco);
            v.setVotiGenerali(vg);
            votiList.add(v);
        }
        return  votiList;
    }

    public HashSet<VotiSindaco> prepareVotiSindacoR(List<SindacoSimple> list)
    {
        HashSet<VotiSindaco> votiList = new HashSet<>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (SindacoSimple l:  list) {
            VotiSindaco v = votiSindacoService.findById(l.getId());
            v.setDataoperazione(oggi);
            v.setNumerovoti(l.getVoti());
            v.setNumerovotisolosindaco(l.getSolosindaco());
            v.setUtenteoperazione(user);
            votiList.add(v);
        }
        return  votiList;   
    }
    
    public  HashSet<VotiLista> prepareVotiR(List<ListaSemplice> list) {
        HashSet<VotiLista> votiList = new HashSet<>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (ListaSemplice l:  list) {
            VotiLista v = votiListaService.findById(l.getId());
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

    public RicalcoloVotiLista votiSplit(VotiLista v, String tipoInterrogazione) {
        RicalcoloVotiLista r = new RicalcoloVotiLista();
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
            VotiLista c = votiListaService.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(v.getLista().getId(),v.getSezione().getNumerosezione(), tipoelezioneid);
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

    public  VotiJson ConvertToJson(List<VotiLista> l, int sezione,String tipo)    {
        List<ListaJson> listaJsons = new ArrayList<ListaJson>();
        VotiJson json = new VotiJson();
        for (VotiLista v : l) {
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

    public VotiSindacoJson ConvertToJsonSindaci(List<VotiSindaco> l, Integer sezione, String tipo) {
        List<SindacoJson> sindaciJsons = new ArrayList<SindacoJson>();
        VotiSindacoJson json = new VotiSindacoJson();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        VotiGenerali v = votiGeneraliService.findBySezioneNumerosezioneAndTipoelezioneId(sezione,tipoelezioneid);
        int votanti = affluenzaService.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(sezione,tipoelezioneid,1).getVotantitotali3();
        json.setBianche(v.getBianche());
        json.setContestate(v.getContestate());
        json.setNulle(v.getNulle());
        json.setSolosindaco(v.getSolosindaco());
        json.setTotale(v.getTotale());
        json.setTotalevalide(v.getTotalevalide());
        json.setVotanti(votanti);
        json.setId(v.getId());
        Integer totaleListe = v.getTotalevalide() - v.getSolosindaco();
        json.setValideliste(totaleListe);
        for (VotiSindaco vs : l) {
            SindacoJson j = new SindacoJson();
            j.setId(vs.getSindaco().getId());
            j.setCognome(vs.getSindaco().getCognome());
            j.setNome(vs.getSindaco().getNome());
            j.setProgressivo(vs.getSindaco().getProgressivo());
            j.setVoti(vs.getNumerovoti());
            j.setIscoalizione("S");
            j.setSolosindaco(vs.getNumerovotisolosindaco());
            j.setNumerosezione(sezione);
            j.setTipo(tipo);
            j.setIdsindaco(vs.getSindaco().getId());
            j.setId(vs.getSindaco().getId());
            sindaciJsons.add(j);
        }
        json.setSindaci(sindaciJsons);
        return  json;
    }

    public HashSet<VotiLista> prepareVotiLista(List<SindacoSimple> sindaci, VotiGenerali vg) {
        HashSet<VotiLista> l = new HashSet<VotiLista>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        Sezione sezione = sezioneService.findByNumerosezioneAndTipoelezioneId(sindaci.get(0).getNumerosezione(), tipoelezioneid);
        for (SindacoSimple s : sindaci) {
            String ricalcoloLista = "ricalcolo" + s.getIdsindaco();
            ListeWrapper r =(ListeWrapper) stateHelper.get(ricalcoloLista);
            VotiLista v = new VotiLista();
            v.setDataoperazione(oggi);
            v.setNumerovoti(r.getListe().get(0).getVoti());
            v.setUtenteoperazione(user);
            v.setSezione(sezione);
            v.setTipoelezione(tipoElezione);
            Lista lista = listaService.findById(r.getListe().get(0).getIdlista());
            v.setLista(lista);
            v.setVotiGenerali(vg);
            l.add(v);
        }
        return  l;
    }

    public HashSet<VotiLista> prepareVotiListaR(List<SindacoSimple> sindaci) {
        HashSet<VotiLista> l = new HashSet<VotiLista>();
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        for (SindacoSimple s : sindaci) {
            String ricalcoloLista = "ricalcolo" + s.getIdsindaco();
            ListeWrapper r =(ListeWrapper) stateHelper.get(ricalcoloLista);
            VotiLista v = votiListaService.findById(r.getListe().get(0).getId());
            v.setDataoperazione(oggi);
            v.setNumerovoti(r.getListe().get(0).getVoti());
            v.setUtenteoperazione(user);
            l.add(v);
        }
        return  l;
    }

    public VotiGenerali prepareVotiG(SindaciWrapper form) {
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tipoElezione = tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        Sezione sezione = sezioneService.findByNumerosezioneAndTipoelezioneId(form.getSindaci().get(0).getNumerosezione(), tipoelezioneid);
        VotiGenerali v = new VotiGenerali();
        v.setBianche(form.getBianche());
        v.setContestate(form.getContestate());
        v.setDataoperazione(oggi);
        v.setUtenteoperazione(user);
        v.setNulle(form.getNulle());
        v.setSezione(sezione);
        v.setSolosindaco(form.getSolosindaco());
        v.setTotale(form.getTotale());
        v.setTotalevalide(form.getTotalevalide());
        v.setTipoelezione(tipoElezione);
        v.setMunicipio(sezione.getMunicipio());
        return  v;
    }

    public VotiGenerali prepareVotiGR(SindaciWrapper form) {

        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        VotiGenerali v =votiGeneraliService.findBySezioneNumerosezioneAndTipoelezioneId(form.getSindaci().get(0).getNumerosezione(), tipoelezioneid);
        v.setBianche(form.getBianche());
        v.setContestate(form.getContestate());
        v.setDataoperazione(oggi);
        v.setUtenteoperazione(user);
        v.setNulle(form.getNulle());
        v.setSolosindaco(form.getSolosindaco());
        return  v;
    }
}
