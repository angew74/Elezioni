package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IPreferenzeService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.risultati.Preferenze;
import com.deltasi.elezioni.repository.PreferenzeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PreferenzeService implements IPreferenzeService {

    @Autowired
    PreferenzeDAO preferenzeDAO;

    @Override
    public void SaveAll(List<Preferenze> list) {
        preferenzeDAO.saveAll(list);
    }

    @Override
    public Preferenze findById(Integer id) {
        return preferenzeDAO.findById(id);
    }

    @Override
    public List<Preferenze> findAllBy() {
        return preferenzeDAO.findAllBy();
    }

    @Override
    public List<Preferenze> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return preferenzeDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione,tipoelezioneid);
    }

    @Override
    public List<Preferenze> findByListaIdAndTipoelezioneId(Integer listaid,int tipoElezioneId) {
        return preferenzeDAO.findByListaIdAndTipoelezioneId(listaid,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByListaProgressivoAndTipoelezioneId(Integer progressivo,int tipoElezioneId) {
        return preferenzeDAO.findByListaProgressivoAndTipoelezioneId(progressivo,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid, Integer numerosezione,int tipoElezioneId) {
        return preferenzeDAO.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(listaid,numerosezione,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo, Integer numerosezione,int tipoElezioneId) {
        return preferenzeDAO.findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(progressivo, numerosezione,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione, Integer numerosezione,int tipoElezioneId) {
        return preferenzeDAO.findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(denominazione,numerosezione,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByListaDenominazioneAndTipoelezioneId(String denominazione,int tipoElezioneId) {
        return preferenzeDAO.findByListaDenominazioneAndTipoelezioneId(denominazione,tipoElezioneId);
    }


    @Override
    public List<RicalcoloPreferenze> countPervenuteByMunicipio(int tipoelezioneid, int municipio) {
        return preferenzeDAO.countPervenuteByMunicipio(tipoelezioneid,municipio);
    }

    @Override
    public List<RicalcoloPreferenze> countPervenute(int tipoelezioneid) {
        return preferenzeDAO.countPervenute(tipoelezioneid);
    }

    @Override
    public List<RicalcoloPreferenze> sumCandidato(int tipoelezioneid) {
        return preferenzeDAO.sumCandidato(tipoelezioneid);
    }

    @Override
    public List<RicalcoloPreferenze> sumCandidatoByMunicipio(int tipoelezioneid, int municipio) {
        return preferenzeDAO.sumCandidatoByMunicipio(tipoelezioneid,municipio);
    }

    @Override
    public List<RicalcoloPreferenze> sumCandidatoByLista(int tipoelezioneid, int idlista) {
        return preferenzeDAO.sumCandidatoByLista(tipoelezioneid,idlista);
    }

    @Override
    public List<RicalcoloPreferenze> sumCandidatoByListaMunicipio(int tipoelezioneid, int municipio, int idlista) {
        return preferenzeDAO.sumCandidatoByListaMunicipio(tipoelezioneid,municipio,idlista);
    }

    @Override
    public List<RicalcoloPreferenze> countVotantiPervenute(int tipoelezioneid) {
        return
                preferenzeDAO.countVotantiPervenute(tipoelezioneid);
    }

    @Override
    public List<RicalcoloPreferenze> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio) {
        return preferenzeDAO.countVotantiPervenuteByMunicipio(tipoelezioneid,municipio);

    }

    @Override
    public List<Preferenze> findByCandidatoIdAndTipoelezioneId(int id, int tipoElezioneId) {
        return preferenzeDAO.findByCandidatoIdAndTipoelezioneId(id,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByCandidatoIdAndTipoelezioneIdAndSezioneId(int id, int tipoElezioneId, int sezioneId) {
        return preferenzeDAO.findByCandidatoIdAndTipoelezioneIdAndSezioneId(id,tipoElezioneId,sezioneId);
    }

    @Override
    public List<Preferenze> findByCandidatoIdAndTipoelezioneIdAndSezioneMunicipio(int id, int tipoElezioneId, int municipio) {
        return preferenzeDAO.findByCandidatoIdAndTipoelezioneIdAndSezioneMunicipio(id,tipoElezioneId,municipio);
    }
}
