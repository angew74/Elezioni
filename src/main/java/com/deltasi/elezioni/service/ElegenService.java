/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IElegenService;
import com.deltasi.elezioni.model.configuration.Elegen;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import javax.transaction.Transactional;

import com.deltasi.elezioni.repository.ElegenDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AdminDSI
 */
@Service
@Transactional
public class ElegenService implements IElegenService {

    
    private static final Logger logger = LogManager.getLogger(ElegenService.class);
    
    @Autowired
    private ElegenDAO elegenDAO;
    
    @Override
    public Elegen findElegenById(Integer id) {

        return elegenDAO.findById(id);
    }

    @Override
    public void add(Elegen elegen) {
        elegenDAO.save(elegen);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Elegen findByIdTipoElezione(Integer idtipoelezione) {
       return  elegenDAO.findByTipoelezioneId(idtipoelezione);
    }

    @Override
    public Elegen findByTipoElezione(TipoElezione tipoelezione) {

        return elegenDAO.findByTipoelezione(tipoelezione);
    }
    
    
}
