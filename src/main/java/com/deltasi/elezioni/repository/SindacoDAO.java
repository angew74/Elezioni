package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.risultati.Sindaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SindacoDAO extends JpaRepository<Sindaco, Long> {

    Sindaco findById(Integer id);
    List<Sindaco> findAllBy();
    Sindaco findByNomeAndCognomeAndTipoelezioneId(String nome, String Cognome, Integer tipoelezioneid);
    Sindaco findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid);
    List<Sindaco> findAllByTipoelezioneId(int tipoElezione);

}
