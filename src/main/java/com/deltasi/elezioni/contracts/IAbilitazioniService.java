package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.FaseElezione;

import java.util.List;

public interface IAbilitazioniService {

    FaseElezione findFaseElezioneById(Integer id);
    FaseElezione findFaseElezioneByCodice(String codice);
    List<FaseElezione> findFaseElezioneByAbiltazione(Integer abil);
    List<FaseElezione> getAll();
    void Save(FaseElezione fase);
    FaseElezione findByCodiceAndTipoelezioneId(String codice, Integer tipoElezioneId);
}
