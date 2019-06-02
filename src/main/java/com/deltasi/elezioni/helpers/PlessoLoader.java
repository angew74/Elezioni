package com.deltasi.elezioni.helpers;


import com.deltasi.elezioni.contracts.IPlessoService;
import com.deltasi.elezioni.contracts.ISezioneService;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.json.PlessoJson;
import com.deltasi.elezioni.model.json.SezioneJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlessoLoader {

    @Autowired
    IPlessoService plessoService;

    @Autowired
    ISezioneService sezioneService;

    @Autowired
    private Environment env;

    public List<PlessoJson> convert(List<Plesso> pp) {
        List<PlessoJson> ppj = new ArrayList<>();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        for (Plesso p :pp
             ) {
            PlessoJson j = new PlessoJson();
            j.setDescrizione(p.getDescrizione());
            j.setUbicazione(p.getUbicazione());
            j.setNumero(p.getId());
            j.setMunicipio(p.getMunicipio());
            List<Sezione> s = sezioneService.findByPlessoIdAndTipoelezioneId(j.getNumero(),tipoelezioneid);
            j.setSezioni(convertSezioni(s));
            ppj.add(j);
        }
        return ppj;
    }

    private List<SezioneJson> convertSezioni(List<Sezione> s) {
        List<SezioneJson> sj = new ArrayList<>();
        for(Sezione su:s)
        {
            SezioneJson j = new SezioneJson();
            j.setCabina(su.getCabina());
            j.setSezione(su.getNumerosezione());
            sj.add(j);
        }
        return sj;
    }
}
