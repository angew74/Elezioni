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

    }

    @Override
    public Preferenze findById(Integer id) {
        return null;
    }

    @Override
    public List<Preferenze> findAllBy() {
        return null;
    }

    @Override
    public List<Preferenze> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return null;
    }

    @Override
    public List<Preferenze> findByListaIdAndTipoelezioneId(Integer listaid,int tipoElezioneId) {
        return null;
    }

    @Override
    public List<Preferenze> findByListaProgressivoAndTipoelezioneId(Integer progressivo,int tipoElezioneId) {
        return null;
    }

    @Override
    public List<Preferenze> findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid, Integer numerosezione,int tipoElezioneId) {
        return preferenzeDAO.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(listaid,numerosezione,tipoElezioneId);
    }

    @Override
    public List<Preferenze> findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo, Integer numerosezione,int tipoElezioneId) {
        return null;
    }

    @Override
    public List<Preferenze> findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione, Integer numerosezione,int tipoElezioneId) {
        return null;
    }

    @Override
    public List<Preferenze> findByListaDenominazioneAndTipoelezioneId(String denominazione,int tipoElezioneId) {
        return null;
    }


    @Override
    public List<RicalcoloPreferenze> countListaByMunicipio(int tipoelezioneid, int municipio) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countPervenuteByMunicipio(int tipoelezioneid, int municipio) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countPervenute(int tipoelezioneid) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countLista(int tipoelezioneid) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countListaSingle(int tipoelezioneid, int idlista) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countListaSingleMunicipio(int tipoelezioneid, int idlista) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countVotantiPervenute(int tipoelezioneid) {
        return null;
    }

    @Override
    public List<RicalcoloPreferenze> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio) {
        return null;
    }
}
