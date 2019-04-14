package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.TipoRicalcolo;

import java.util.List;

public interface ITipoRicalcoloService {

    TipoRicalcolo findById(Integer id);
    void deleteById(Integer id);
    List<TipoRicalcolo> FindAll();
    List<TipoRicalcolo> findAllByTipoelezioneId(int tipoElezioneId);
    List<TipoRicalcolo> findAllByTipoelezioneIdAndCodiceFase(int tipoElezioneId,String codice);
    List<TipoRicalcolo> findAllByTipoelezioneIdAndCodice(int tipoElezioneId,String codice);
    List<TipoRicalcolo> findByCodicefase(String codice);
    List<TipoRicalcolo> findByCodice(String codice);
}
