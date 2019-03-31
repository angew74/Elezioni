package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.risultati.Voti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotiDAO extends JpaRepository<Voti, Long> {

    Voti findById(Integer id);
    List<Voti> findAllBy();
    List<Voti> findBySezioneNumerosezioneAndSezioneTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Voti> findByListaId(Integer listaid);
    List<Voti> findByListaProgressivo(Integer progressivo);
    Voti findByListaIdAndSezioneNumerosezione(Integer listaid,Integer numerosezione);
    Voti findByListaProgressivoAndSezioneNumerosezione(Integer progressivo,Integer numerosezione);
    Voti findByListaDenominazioneAndSezioneNumerosezione(String denominazione,Integer numerosezione);
    List<Voti> findByListaDenominazione(String denominazione);
}

