/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface TipoElezioneDAO extends JpaRepository<TipoElezione, Long> {
    public TipoElezione findById(Integer id);
    public TipoElezione findByDescrizione(String descrizione);
    public List<TipoElezione> getAllBy();
    
}
