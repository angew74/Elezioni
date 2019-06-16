package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.FaseElezione;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AbilitazioneDAO  extends JpaRepository<FaseElezione, Long> {

     FaseElezione findById(Integer id);
     FaseElezione findByCodice(String codice);
     FaseElezione findByCodiceAndTipoelezioneId(String codice, Integer tipoElezioneId);
     List<FaseElezione> findAllBy();
     Page<FaseElezione> findAllByTipoelezioneId(Pageable pageable,int tipoelezioneid);
     Page<FaseElezione> findByAbilitataAndTipoelezioneId(Pageable pageable,Integer abil,int tipoelezioneid);
     List<FaseElezione> findByAbilitataAndTipoelezioneId(int abilitata,int tipoelezioneid);

}
