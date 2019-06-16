package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.risultati.Coalizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoalizioneDAO extends JpaRepository<Coalizione, Long> {

    Coalizione findById(Integer id);
    List<Coalizione> findAllBy();
    Coalizione findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid);
    Coalizione findBySindacoIdAndTipoelezioneId(Integer sindacoid, Integer tipoelezioneid);
    Coalizione findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(String nome, String cognome, Integer tipoelezioneid);
    List<Coalizione> findAllByTipoelezioneId(int tipoElezione);
}
