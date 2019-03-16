/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.ITipoElezioneService;
import com.deltasi.elezioni.repository.TipoElezioneDAO;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;
import javax.transaction.Transactional;
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
public class TipoElezioneService implements ITipoElezioneService {

     private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);
    
    @Autowired
    private TipoElezioneDAO tipoElezineDAO;
    
    @Override
    public TipoElezione findTipoElezioneById(Integer id) {
      return tipoElezineDAO.findById(id);
              }

    @Override
    public TipoElezione findElezioneByDescrizione(String descrizione) {
       return tipoElezineDAO.findByDescrizione(descrizione);
    }

    @Override
    public List<TipoElezione> getAll() {
      return tipoElezineDAO.findAll();
    }
    
}
