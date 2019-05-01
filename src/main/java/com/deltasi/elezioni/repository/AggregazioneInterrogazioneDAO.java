package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.AggregazioneInterrogazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AggregazioneInterrogazioneDAO  extends JpaRepository<AggregazioneInterrogazione, Long> {
    AggregazioneInterrogazione findById(Integer id);
    void deleteById(Integer id);
    List<AggregazioneInterrogazione> findAllByTipoelezioneId(int tipoElezioneId);
}
