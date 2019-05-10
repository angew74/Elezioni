package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.TipoInterrogazione;

import java.util.List;

public interface ITipoInterrogazioneService {
    TipoInterrogazione findById(Integer id);
    void deleteById(Integer id);
    List<TipoInterrogazione> FindAll();
    List<TipoInterrogazione> findAllByTipoelezioneId(int tipoElezioneId);
    List<TipoInterrogazione> findAllByTipoelezioneIdAndCodiceFase(int tipoElezioneId,String codice);
    List<TipoInterrogazione> findAllByTipoelezioneIdAndCodice(int tipoElezioneId,String codice);
    List<TipoInterrogazione> findByCodicefase(String codice);
    List<TipoInterrogazione> findByCodice(String codice);

}

