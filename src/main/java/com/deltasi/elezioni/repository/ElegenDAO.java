/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.Elegen;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface ElegenDAO extends JpaRepository<Elegen, Long> {

    public Elegen findById(Integer id);
    public void deleteById(Integer id);
    public Elegen findByTipoelezioneId(Integer idtipoelezione);
    public Elegen findByTipoelezione(TipoElezione tipoelezione);
    
}
