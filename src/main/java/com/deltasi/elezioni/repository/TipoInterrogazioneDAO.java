package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.TipoInterrogazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoInterrogazioneDAO
        extends JpaRepository<TipoInterrogazione, Long> {

    TipoInterrogazione findById(Integer id);
    void deleteById(Integer id);
    List<TipoInterrogazione> findAllBy();
    List<TipoInterrogazione> findAllByTipoelezioneId(int tipoElezioneId);
    List<TipoInterrogazione> findAllByTipoelezioneIdAndCodicefase(int tipoElezioneId,String codice);
    List<TipoInterrogazione> findAllByTipoelezioneIdAndCodice(int tipoElezioneId, String codice);
    List<TipoInterrogazione> findByCodicefase(String codice);
    List<TipoInterrogazione> findByCodice(String codice);

}

