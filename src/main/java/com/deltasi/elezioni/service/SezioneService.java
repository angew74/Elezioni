package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.ISezioneService;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.repository.SezioneDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SezioneService implements ISezioneService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private SezioneDAO sezioneDAO;

    @Override
    public Sezione findById(Integer id) {
        return  sezioneDAO.findById(id);
    }

    @Override
    public Sezione findByNumerosezioneAndTipoelezioneId(Integer numeroSezione, Integer tipoElezioneId) {
       return  sezioneDAO.findByNumerosezioneAndTipoelezioneId(numeroSezione,tipoElezioneId);
    }

    @Override
    public List<Sezione> findAllBy() {
        return  findAllBy();
    }
}
