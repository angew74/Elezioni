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

    public FaseElezione findById(Integer id);
    public FaseElezione findByCodice(String codice);
    public List<FaseElezione> findAllBy();
    public List<FaseElezione> findByAbilitata(Integer abil);
}
