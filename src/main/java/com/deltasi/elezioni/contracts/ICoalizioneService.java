package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.Coalizione;

import java.util.List;

public interface ICoalizioneService {

    Coalizione findById(Integer id);
    List<Coalizione> findAllBy();
    Coalizione findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid);
    Coalizione findBySindacoIdAndTipoelezioneId(Integer sindacoid, Integer tipoelezioneid);
    Coalizione findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(String nome, String cognome, Integer tipoelezioneid);
    List<Coalizione> findAllByTipoelezioneId(int tipoElezione);
}
