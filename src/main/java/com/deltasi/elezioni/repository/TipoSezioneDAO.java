/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.TipoSezione;
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
public interface TipoSezioneDAO extends JpaRepository<TipoSezione, Long> {

    public TipoSezione findById(Integer id);
    public TipoSezione findByCodicesezione(String codice);
    public List<TipoSezione> findAllBy();

    
}
