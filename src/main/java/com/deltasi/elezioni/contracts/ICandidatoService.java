package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.Candidato;

import java.util.List;

public interface ICandidatoService {

    Candidato findById(Integer id);
    List<Candidato> findAllBy();
    List<Candidato> findByCognomeAndNomeAndTipoelezioneId(String cognome, String nome, Integer tipoelezioneid);
    Candidato findByProgressivoAndListaIdAndTipoelezioneId(int progressivo,int listaid, Integer tipoelezioneid);
    List<Candidato> findByListaIdAndTipoelezioneId(Integer lista, Integer tipoelezioneid);
}
