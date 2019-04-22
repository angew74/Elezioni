package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.risultati.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoDAO  extends JpaRepository<Candidato, Long> {

    Candidato findById(Integer id);
    List<Candidato> findAllBy();
    List<Candidato> findAllByCognomeAndNomeAndTipoelezioneId(String cognome, String nome, Integer tipoelezioneid);
    Candidato findAllByProgressivoAndListaIdAndTipoelezioneId(int progressivo,int listaid, Integer tipoelezioneid);
    List<Candidato> findAllByListaIdAndTipoelezioneId(Integer lista, Integer tipoelezioneid);

}
