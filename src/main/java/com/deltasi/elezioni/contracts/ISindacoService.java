package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.Sindaco;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface ISindacoService {
    Sindaco findById(Integer id);
    List<Sindaco> findAllBy();
    Sindaco findByNomeAndCognomeAndTipoelezioneId(String nome, String cognome, Integer tipoelezioneid);
    Sindaco findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid);
    List<Sindaco> findAllByTipoelezioneId(int tipoElezione);
}
