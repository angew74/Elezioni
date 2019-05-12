package com.deltasi.elezioni.helpers;

import com.deltasi.elezioni.contracts.IIscrittiService;
import com.deltasi.elezioni.controllers.RestInterrogazioniController;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;

@Component
public class AffluenzaLoader {

    private static final Logger logger = LogManager.getLogger(AffluenzaLoader.class);

    @Autowired
    private Environment env;

    @Autowired
    private IIscrittiService iIscrittiService;

    public RicalcoloAffluenza affluenzaSplit(Affluenza a,String tipoInterrogazione)
    {
        RicalcoloAffluenza r = new RicalcoloAffluenza();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            Iscritti i = iIscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid,a.getSezione().getNumerosezione());
            switch (tipoInterrogazione) {
                case "AF1":
                    r.setAffluenzamaschi(a.getVotantimaschi1());
                    r.setAffluenzafemmine(a.getVotantifemmine1());
                    r.setAffluenzatotale(a.getVotantitotali1());
                    break;
                case "AF2":
                    r.setAffluenzamaschi(a.getVotantimaschi1());
                    r.setAffluenzafemmine(a.getVotantifemmine1());
                    r.setAffluenzatotale(a.getVotantitotali1());
                    break;
                case "CHI":
                    r.setAffluenzamaschi(a.getVotantimaschi3());
                    r.setAffluenzafemmine(a.getVotantifemmine3());
                    r.setAffluenzatotale(a.getVotantitotali3());
                    break;
            }
            r.setIscrittifemmine(i.getIscrittifemminegen());
            r.setIscrittimaschi(i.getIscrittimaschigen());
            r.setIscrittitotali(i.getIscrittitotaligen());
            r.setMunicipio(i.getMunicipio());
            r.setPercentualemaschi(calculatePercentage(r.getAffluenzamaschi(),r.getIscrittimaschi()));
            r.setPercentualefemmine(calculatePercentage(r.getAffluenzafemmine(),r.getIscrittifemmine()));
            r.setPercentualetotale(calculatePercentage(r.getAffluenzatotale(),r.getIscrittitotali()));
            r.setSezione(a.getSezione().getNumerosezione());
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

    public RicalcoloCostApertura costituzioneSplit(Affluenza a, String tipoInterrogazione) {
        RicalcoloCostApertura r = new RicalcoloCostApertura();
        Integer tipoelezioneid = Integer.parseInt(env.getProperty("tipoelezioneid"));
        try {
            Iscritti i = iIscrittiService.findByTipoelezioneIdAndSezioneNumerosezione(tipoelezioneid,a.getSezione().getNumerosezione());
            r.setIscrittifemmine(i.getIscrittifemminegen());
            r.setIscrittimaschi(i.getIscrittimaschigen());
            r.setIscrittitotali(i.getIscrittitotaligen());
            r.setMunicipio(i.getMunicipio());
            r.setSezione(a.getSezione().getNumerosezione());
            switch (tipoInterrogazione)
            {
                case "CO1":
                    r.setStatus("Costituita");
                    break;
                case "AP1":
                    r.setStatus("Aperta");
                    break;
            }
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }
        return r;

    }
}
