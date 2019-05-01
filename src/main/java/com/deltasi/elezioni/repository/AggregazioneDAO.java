package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.configuration.Aggregazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AggregazioneDAO extends JpaRepository<Aggregazione, Long> {

    Aggregazione findById(Integer id);
    void deleteById(Integer id);
    List<Aggregazione> findAllByTipoelezioneId(int tipoElezioneId);

}
