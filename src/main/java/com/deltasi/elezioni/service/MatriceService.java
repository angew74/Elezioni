/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IMatriceService;
import com.deltasi.elezioni.repository.MatriceDAO;
import com.deltasi.elezioni.model.configuration.Matrice;
import com.deltasi.elezioni.model.configuration.TipoElezione;
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
public class MatriceService implements IMatriceService {

    
   private static final Logger logger = LogManager.getLogger(MatriceService.class);
    
    @Autowired
    private MatriceDAO matriceDAO;
    
    @Override
    public Matrice findMatriceById(Integer id) {
        return matriceDAO.findById(id);
    }

    @Override
    public Matrice findMatriceByMun(Integer mun)
    {
       return matriceDAO.findByMunicipio(mun);
    }

    @Override
    public void add(Matrice matrice) {

        matriceDAO.save(matrice);
    }

    @Override
    public void delete(Integer id) {
        matriceDAO.deleteById(id);
    }

    @Override
    public Matrice findByIdTipoElezione(Integer idtipoelezione) {
    return matriceDAO.findByTipoelezioneId(idtipoelezione);
    }

    @Override
    public Matrice findByTipoElezione(TipoElezione tipoelezione) {
       return
               matriceDAO.findByTipoelezione(tipoelezione);
    }
    
}
