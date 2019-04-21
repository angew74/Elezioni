package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.IListaService;
import com.deltasi.elezioni.contracts.ISezioneService;
import com.deltasi.elezioni.contracts.ITipoElezioneService;
import com.deltasi.elezioni.contracts.IVotiService;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.json.ListaSemplice;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.risultati.Voti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class VotiLoader {

    @Autowired
    ISezioneService sezioneService;

    @Autowired
    private Environment env;

    @Autowired
    ITipoElezioneService tipoElezioneService;

    @Autowired
    IListaService listaService;

    @Autowired
    IVotiService votiService;


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
}
