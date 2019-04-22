package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.ICandidatoService;
import com.deltasi.elezioni.model.risultati.Candidato;
import com.deltasi.elezioni.repository.CandidatoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CandidatoService implements ICandidatoService {

    @Autowired
    CandidatoDAO candidatoDAO;

    @Override
    public Candidato findById(Integer id) {
        return candidatoDAO.findById(id);
    }

    @Override
    public List<Candidato> findAllBy() {
        return candidatoDAO.findAllBy();
    }

    @Override
    public List<Candidato> findByCognomeAndNomeAndTipoelezioneId(String cognome, String nome, Integer tipoelezioneid) {
        return candidatoDAO.findAllByCognomeAndNomeAndTipoelezioneId(cognome,nome,tipoelezioneid);
    }

    @Override
    public Candidato findByProgressivoAndListaIdAndTipoelezioneId(int progressivo, int listaid, Integer tipoelezioneid) {
        return candidatoDAO.findAllByProgressivoAndListaIdAndTipoelezioneId(progressivo,listaid,tipoelezioneid);
    }

    @Override
    public List<Candidato> findByListaIdAndTipoelezioneId(Integer lista, Integer tipoelezioneid) {
        return candidatoDAO.findAllByListaIdAndTipoelezioneId(lista,tipoelezioneid);
    }
}
