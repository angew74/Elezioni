package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.ITipoInterrogazioneService;
import com.deltasi.elezioni.model.configuration.TipoInterrogazione;
import com.deltasi.elezioni.repository.TipoInterrogazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class TipoInterrogazioneService implements ITipoInterrogazioneService {

    @Autowired
    TipoInterrogazioneDAO tipoInterrogazioneDAO;

    @Override
    public TipoInterrogazione findById(Integer id) {
        return tipoInterrogazioneDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        tipoInterrogazioneDAO.deleteById(id);
    }

    @Override
    public List<TipoInterrogazione> FindAll() {
        return tipoInterrogazioneDAO.findAll();
    }

    @Override
    public List<TipoInterrogazione> findAllByTipoelezioneId(int tipoElezioneId) {
        return null;
    }

    @Override
    public List<TipoInterrogazione> findAllByTipoelezioneIdAndCodiceFase(int tipoElezioneId, String codice) {
        return tipoInterrogazioneDAO.findAllByTipoelezioneIdAndCodicefase(tipoElezioneId,codice);
    }

    @Override
    public List<TipoInterrogazione> findAllByTipoelezioneIdAndCodice(int tipoElezioneId, String codice) {
        return tipoInterrogazioneDAO.findAllByTipoelezioneIdAndCodice(tipoElezioneId,codice);
    }

    @Override
    public List<TipoInterrogazione> findByCodicefase(String codice) {
        return tipoInterrogazioneDAO.findByCodicefase(codice);
    }

    @Override
    public List<TipoInterrogazione> findByCodice(String codice) {
        return tipoInterrogazioneDAO.findByCodice(codice);
    }
}
