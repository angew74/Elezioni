package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IVotiService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.repository.VotiDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class VotiService implements IVotiService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private VotiDAO votiDAO;


    @Override
    public Voti findById(Integer id) {
        return votiDAO.findById(id);
    }

    @Override
    public void SaveAll(List<Voti> list)
    {
        votiDAO.saveAll(list);
    }
    @Override
    public List<Voti> findAllBy() {
        return votiDAO.findAllBy();
    }

    @Override
    public List<Voti> findBySezioneNumerosezioneAndSezioneTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        List<Voti> l = votiDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneId(numerosezione,tipoelezioneid);
        return l;
    }

    @Override
    public List<Voti> findByListaId(Integer listaid) {
        return null;
    }

    @Override
    public List<Voti> findByListaProgressivo(Integer progressivo) {
        return votiDAO.findByListaProgressivo(progressivo);
    }

    @Override
    public Voti findByListaIdAndSezioneNumerosezione(Integer listaid, Integer numerosezione) {
        return votiDAO.findByListaIdAndSezioneNumerosezione(listaid,numerosezione);
    }

    @Override
    public Voti findByListaProgressivoAndSezioneNumerosezione(Integer progressivo, Integer numerosezione) {
        return votiDAO.findByListaProgressivoAndSezioneNumerosezione(progressivo,numerosezione);
    }

    @Override
    public Voti findByListaDenominazioneAndSezioneNumerosezione(String denominazione, Integer numerosezione) {
        return votiDAO.findByListaDenominazioneAndSezioneNumerosezione(denominazione,numerosezione);
    }

    @Override
    public List<Voti> findByListaDenominazione(String denominazione) {
        return votiDAO.findByListaDenominazione(denominazione);
    }

    @Override
    public List<RicalcoloVoti> countListaByMunicipio(int tipoelezioneid) {
        return votiDAO.countListaByMunicipio(tipoelezioneid);
    }

    @Override
    public List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid) {
        return votiDAO.countPervenuteByMunicipio(tipoelezioneid);
    }

    @Override
    public List<RicalcoloVoti> countPervenute(int tipoelezioneid) {
        return votiDAO.countPervenute(tipoelezioneid);
    }

    @Override
    public List<RicalcoloVoti> countLista(int tipoelezioneid) {
        return votiDAO.countLista(tipoelezioneid);
    }

    @Override
    public List<RicalcoloVoti> countListaSingle(int tipoelezioneid, int idlista) {
        return votiDAO.countListaSingle(tipoelezioneid,idlista);
    }

    @Override
    public List<RicalcoloVoti> countListaSingleByMunicipio(int tipoelezioneid, int idlista) {
        return votiDAO.countListaSingle(tipoelezioneid,idlista);
    }
}
