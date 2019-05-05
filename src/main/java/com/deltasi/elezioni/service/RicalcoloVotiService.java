package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IRicalcoloVotiService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.repository.RicalcoloAffluenzaDAO;
import com.deltasi.elezioni.repository.RicalcoloVotiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RicalcoloVotiService implements IRicalcoloVotiService {

    @Autowired
    private RicalcoloVotiDAO ricalcoloVotiDAO;

    @Override
    public List<RicalcoloVoti> findAllBy() {
        return ricalcoloVotiDAO.findAllBy();
    }

    @Override
    public RicalcoloVoti findAllById(int id) {
        return ricalcoloVotiDAO.findAllById(id);
    }

    @Override
    public void SaveAll(List<RicalcoloVoti> list) {
        ricalcoloVotiDAO.saveAll(list);
    }

    @Override
    public List<RicalcoloVoti> findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId)
    {
        return ricalcoloVotiDAO.findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(tipoElezioneId,ListaId);
    }

    @Override
    public RicalcoloVoti findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio,int ListaId)
    {
        return  ricalcoloVotiDAO.findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(tipoElezioneId, Municipio, ListaId);
    }

    @Override
    public List<RicalcoloVoti> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId) {
        return  ricalcoloVotiDAO.findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(tipoElezioneId,ListaId);
    }

}
