package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.Lista;

import java.util.List;

public interface IListaService {

    Lista findById(Integer id);
    List<Lista> findAllBy();
    Lista findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid);
    Lista findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid);
    List<Lista> findAllByTipoelezioneId(int tipoElezione);
}
