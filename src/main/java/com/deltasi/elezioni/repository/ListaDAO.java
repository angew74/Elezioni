package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.risultati.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListaDAO extends JpaRepository<Lista, Long> {

    Lista findById(Integer id);
    List<Lista> findAllBy();
    Lista findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid);
    Lista findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid);
}
