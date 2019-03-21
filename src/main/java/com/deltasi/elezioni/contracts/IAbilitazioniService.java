package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.FaseElezione;

import java.util.List;

public interface IAbilitazioniService {

    public FaseElezione findFaseElezioneById(Integer id);
    public FaseElezione findFaseElezioneByCodice(String codice);
    public List<FaseElezione> findFaseElezioneByAbiltazione(Integer abil);
    public List<FaseElezione> getAll();
    public void Save(FaseElezione fase);
}
