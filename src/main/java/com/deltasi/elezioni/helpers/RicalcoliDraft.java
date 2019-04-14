package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.contracts.ISezioneService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class RicalcoliDraft {

    @Autowired
    IAffluenzaService affluenzaService;

    @Autowired
    ISezioneService sezioniService;

    @Autowired
    private Environment env;

    public List<RicalcoloAffluenza> Affluenza(String aggregazione, String codice)
    {
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        LocalDateTime oggi = LocalDateTime.now();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        List<RicalcoloAffluenza> complete = new ArrayList<RicalcoloAffluenza>();
        switch (codice)
        {
            case "AF1":
                switch (aggregazione)
                {
                    case "MUN":
                        complete = affluenzaService.countAffluenza1ByMunicipio(tipoelezioneid);
                        for(int m=1;m<16;m++) {
                            // List<Integer> list = affluenzaService.countByAffluenza1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(1, m, tipoelezioneid, tipoelezioneid);
                            List<Integer> sezionimun = sezioniService.countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(tipoelezioneid,m,tipoelezioneid);
                            int k=  m-1;
                            complete.get(k).setTotalesezioni(sezionimun.get(k));
                           // complete.get(k).setNumerosezioni(list.get(k));
                            complete.get(k).setDataoperazione(oggi);
                            complete.get(k).setUtenteoperazione(user);
                        }
                        break;
                    case "COM":
                       List<Integer> comune = affluenzaService.countByAffluenza1AndTipoelezioneIdAndTipoelezioneIdIn(1,tipoelezioneid,tipoelezioneid);
                     if(comune.size() == 0)
                     {return  complete;}
                     else {
                         List<Integer> sezioni = sezioniService.countAllByTipoelezioneIdAndTipoelezioneIdIn(tipoelezioneid,tipoelezioneid);
                         List<RicalcoloAffluenza> l = affluenzaService.countAffluenza1(tipoelezioneid);
                         if(l.size() ==0)
                         {return  complete;}
                         else {
                             RicalcoloAffluenza c = l.get(0);
                             c.setDataoperazione(oggi);
                             c.setUtenteoperazione(user);
                             c.setMunicipio(99);
                             c.setNumerosezioni(comune.get(0));
                             c.setTotalesezioni(sezioni.get(0));
                             complete.add(c);
                         }
                     }
                        break;
                    case "SEZ":
                        break;
                }
                break;
            case "AF2":
                break;
            case "AF3":
                break;
        }
        return  complete;
    }

    public RicalcoloCostApertura costApertura(String aggregazione, String codice) {
        switch (codice) {
            case "AP1":
                break;
            case "AP2":
                break;
            case "CO1":
                break;
            case "CO2":
                break;
        }
        return  null;
    }
}
