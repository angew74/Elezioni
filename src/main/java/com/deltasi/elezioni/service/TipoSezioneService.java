/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.ITipoSezioneService;
import com.deltasi.elezioni.repository.TipoSezioneDAO;
import com.deltasi.elezioni.model.configuration.TipoSezione;
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
public class TipoSezioneService implements ITipoSezioneService {

     private static final Logger logger = LogManager.getLogger(UserService.class);
    
    @Autowired
    private TipoSezioneDAO tipoSezioneDAO;
    
    @Override
    public TipoSezione findTipoSezioneById(Integer id) {
      return tipoSezioneDAO.findById(id);
    }

    @Override
    public TipoSezione findTipoSezioneByCodice(String codice) {
      return tipoSezioneDAO.findByCodicesezione(codice);
    }

    @Override
    public List<TipoSezione> getAll() {
        return tipoSezioneDAO.findAllBy();
    }
    
}
