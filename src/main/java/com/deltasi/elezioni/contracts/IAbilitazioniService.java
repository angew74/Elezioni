package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.FaseElezione;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAbilitazioniService {

    FaseElezione findFaseElezioneById(Integer id);
    FaseElezione findFaseElezioneByCodice(String codice);
    List<FaseElezione> getAll();
    void Save(FaseElezione fase);
    FaseElezione findByCodiceAndTipoelezioneId(String codice, Integer tipoElezioneId);
    Page<FaseElezione> findAllByTipoelezioneId(Pageable pageable, int tipoelezioneid);
    Page<FaseElezione> findByAbilitataAndTipoelezioneId(Pageable pageable, Integer abil,int tipoelezioneid);
    List<FaseElezione> findByAbilitataAndTipoelezioneId(int abilitata,int tipoelezioneid);
}

