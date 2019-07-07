package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.IRicalcoloVotiListaService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVotiLista;
import com.deltasi.elezioni.repository.RicalcoloAffluenzaDAO;
import com.deltasi.elezioni.repository.RicalcoloVotiListaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RicalcoloVotiListaService implements IRicalcoloVotiListaService {

    @Autowired
    private RicalcoloVotiListaDAO ricalcoloVotiListaDAO;

    @Override
    public List<RicalcoloVotiLista> findAllBy() {
        return ricalcoloVotiListaDAO.findAllBy();
    }

    @Override
    public RicalcoloVotiLista findAllById(int id) {
        return ricalcoloVotiListaDAO.findAllById(id);
    }

    @Override
    public void SaveAll(List<RicalcoloVotiLista> list) {
        ricalcoloVotiListaDAO.saveAll(list);
    }

    @Override
    public List<RicalcoloVotiLista> findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId)
    {
        return ricalcoloVotiListaDAO.findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(tipoElezioneId,ListaId);
    }

    @Override
    public RicalcoloVotiLista findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio,int ListaId)
    {
        return  ricalcoloVotiListaDAO.findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(tipoElezioneId, Municipio, ListaId);
    }

    @Override
    public List<RicalcoloVotiLista> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId) {
        return  ricalcoloVotiListaDAO.findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(tipoElezioneId,ListaId);
    }

    @Override
    public List<RicalcoloVotiLista> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloVotiListaDAO.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(tipoElezioneId,tipoRicalcoloId,municipio);
    }

    @Override
    public List<RicalcoloVotiLista> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloVotiListaDAO.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,municipio);
    }

    @Override
    public List<RicalcoloVotiLista> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloVotiListaDAO.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,municipio);
    }

}
