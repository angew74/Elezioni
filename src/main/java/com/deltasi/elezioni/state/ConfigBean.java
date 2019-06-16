package com.deltasi.elezioni.state;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.service.TipoElezioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean
{
    @Autowired
    private Environment env;

    @Autowired
    private TipoElezioneService tipoElezioneService;


    private String ApplicationName;
    private String DataElezione;

    public String getApplicationName() {
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        TipoElezione tip =tipoElezioneService.findTipoElezioneById(tipoelezioneid);
        ApplicationName = tip.getDescrizione();
        DataElezione = tip.getDataelezione().toString();
        return ApplicationName;
    }

    public void setApplicationName(String applicationName) {
        ApplicationName = applicationName;
    }
}
