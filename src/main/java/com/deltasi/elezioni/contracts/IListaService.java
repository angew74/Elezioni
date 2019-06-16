package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.Lista;

import java.util.List;

public interface IListaService {

    Lista findById(Integer id);
    List<Lista> findAllBy();
    Lista findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid);
    Lista findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid);
    List<Lista> findAllByTipoelezioneId(int tipoElezione);
    List<Lista> findByCoalizioneIdAndTipoelezioneId(int idcoalizione, int tipoelezioneid);
    List<Lista> findByCoalizioneDenominazioneAndTipoelezioneId(String denominazione, int tipoelezioneid);
    List<Lista> findByCoalizioneSindacoIdAndTipoelezioneId(int sindacoid, int tipoelezioneid);
    List<Lista> findBySindacoIdAndTipoelezioneId(int sindacoid, int tipoelezioneid);
    List<Lista> findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(String nome, String cognome, int tipoelezioneid);
}
