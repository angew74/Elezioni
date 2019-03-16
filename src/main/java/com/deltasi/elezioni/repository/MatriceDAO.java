/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.configuration.Matrice;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface MatriceDAO extends JpaRepository<Matrice, Long> {

    public Matrice findById(Integer id);
    public Matrice findByMunicipio(Integer mun);
    public void deleteById(Integer id);
    public Matrice findByTipoelezioneId(Integer idtipoelezione);
    public Matrice findByTipoelezione(TipoElezione tipoElezione);
    
}
