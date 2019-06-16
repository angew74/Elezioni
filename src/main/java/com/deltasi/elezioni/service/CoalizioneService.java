package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.ICoalizioneService;
import com.deltasi.elezioni.model.risultati.Coalizione;
import com.deltasi.elezioni.repository.CoalizioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoalizioneService implements ICoalizioneService {


    @Autowired
    CoalizioneDAO coalizioneDAO;

    @Override
    public Coalizione findById(Integer id) {
        return coalizioneDAO.findById(id);
    }

    @Override
    public List<Coalizione> findAllBy() {
        return coalizioneDAO.findAllBy();
    }

    @Override
    public Coalizione findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid) {
        return coalizioneDAO.findByDenominazioneAndTipoelezioneId(denominazione,tipoelezioneid);
    }

    @Override
    public Coalizione findBySindacoIdAndTipoelezioneId(Integer sindacoid, Integer tipoelezioneid) {
        return coalizioneDAO.findBySindacoIdAndTipoelezioneId(sindacoid,tipoelezioneid);
    }

    @Override
    public Coalizione findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(String nome, String cognome, Integer tipoelezioneid) {
        return coalizioneDAO.findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(nome,cognome,tipoelezioneid);
    }

    @Override
    public List<Coalizione> findAllByTipoelezioneId(int tipoElezione) {
        return coalizioneDAO.findAllByTipoelezioneId(tipoElezione);
    }
}
