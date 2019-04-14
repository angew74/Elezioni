package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.ITipoRicalcoloService;
import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import com.deltasi.elezioni.repository.TipoRicalcoloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TipoRicalcoloService implements ITipoRicalcoloService {

    @Autowired
    private TipoRicalcoloDAO tipoRicalcoloDAO;

    @Override
    public TipoRicalcolo findById(Integer id) {
        return tipoRicalcoloDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        tipoRicalcoloDAO.deleteById(id);
    }

    @Override
    public List<TipoRicalcolo> FindAll() {
        return tipoRicalcoloDAO.findAll();
    }

    @Override
    public List<TipoRicalcolo> findByCodice(String codice) {
        return tipoRicalcoloDAO.findByCodice(codice);
    }
    @Override
    public List<TipoRicalcolo> findAllByTipoelezioneId(int tipoElezioneId)
    {
        return tipoRicalcoloDAO.findAllByTipoelezioneId(tipoElezioneId);
    }

    @Override
    public List<TipoRicalcolo> findAllByTipoelezioneIdAndCodiceFase(int tipoElezioneId, String codice) {
        return tipoRicalcoloDAO.findAllByTipoelezioneIdAndCodicefase(tipoElezioneId,codice);
    }

    @Override
    public List<TipoRicalcolo> findAllByTipoelezioneIdAndCodice(int tipoElezioneId,String codice)
    {
        return tipoRicalcoloDAO.findAllByTipoelezioneIdAndCodice(tipoElezioneId, codice);
    }

    @Override
    public List<TipoRicalcolo> findByCodicefase(String codice) {
        return tipoRicalcoloDAO.findByCodicefase(codice);
    }
}
