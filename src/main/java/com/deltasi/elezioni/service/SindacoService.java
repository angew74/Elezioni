package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.ISindacoService;
import com.deltasi.elezioni.model.risultati.Sindaco;
import com.deltasi.elezioni.repository.SindacoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SindacoService implements ISindacoService {

    @Autowired
    SindacoDAO sindacoDAO;

    @Override
    public Sindaco findById(Integer id) {
        return sindacoDAO.findById(id);
    }

    @Override
    public List<Sindaco> findAllBy() {
        return sindacoDAO.findAllBy();
    }

    @Override
    public Sindaco findByNomeAndCognomeAndTipoelezioneId(String nome, String cognome, Integer tipoelezioneid) {
        return sindacoDAO.findByNomeAndCognomeAndTipoelezioneId(nome,cognome,tipoelezioneid);
    }

    @Override
    public Sindaco findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid) {
        return sindacoDAO.findByProgressivoAndTipoelezioneId(progressivo,tipoelezioneid);
    }

    @Override
    public List<Sindaco> findAllByTipoelezioneId(int tipoElezione) {
        return sindacoDAO.findAllByTipoelezioneId(tipoElezione);
    }
}
