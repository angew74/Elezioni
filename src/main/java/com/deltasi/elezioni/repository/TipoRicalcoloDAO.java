package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.TipoRicalcolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoRicalcoloDAO
        extends JpaRepository<TipoRicalcolo, Long> {

    TipoRicalcolo findById(Integer id);
    void deleteById(Integer id);
    List<TipoRicalcolo> findAllBy();
    List<TipoRicalcolo> findAllByTipoelezioneId(int tipoElezioneId);
    List<TipoRicalcolo> findAllByTipoelezioneIdAndCodicefase(int tipoElezioneId,String codice);
    List<TipoRicalcolo> findAllByTipoelezioneIdAndCodice(int tipoElezioneId,String codice);
    List<TipoRicalcolo> findByCodicefase(String codice);
    List<TipoRicalcolo> findByCodice(String codice);

}
