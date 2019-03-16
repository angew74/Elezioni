/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IIscrittiService;
import com.deltasi.elezioni.repository.IscrittiDAO;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;
import java.util.Optional;
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
public class IscrittiService implements IIscrittiService {

    private static final Logger logger = LogManager.getLogger(IscrittiService.class);
    
    @Autowired
    private IscrittiDAO iscrittiDAO;
    
    @Override
    public Optional<Iscritti> findIscrittiById(Integer id)
    {
         return iscrittiDAO.findById(id);
    }

    @Override
    public List<Iscritti> findIscrittiByMun(Integer mun) {
      return
              iscrittiDAO.findByMunicipio(mun);
    }

    @Override
    public Iscritti findIscrittiBySezione(Integer sezione) {

        return iscrittiDAO.findByNumerosezione(sezione);
    }

    @Override
    public void add(Iscritti matrice) {
        iscrittiDAO.save(matrice);
    }

    @Override
    public void delete(Integer id) {
        iscrittiDAO.deleteById(id);
    }

    @Override
    public List<Iscritti> findByIdTipoElezione(Integer idtipoelezione) {
          return iscrittiDAO.findByTipoelezioneId(idtipoelezione);
    }

    @Override
    public List<Iscritti> findByTipoElezione(TipoElezione tipoelezione) {
       return iscrittiDAO.findByTipoelezione(tipoelezione);
    }
    
}
