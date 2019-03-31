/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface IscrittiDAO extends JpaRepository<Iscritti, Integer> {
    Iscritti findById(long id);
    List<Iscritti> findByMunicipio(Integer mun);
    Iscritti findBySezioneId(Integer idsezione);
    Iscritti findByTipoelezioneIdAndSezioneNumerosezione(Integer tipoElezioneId,Integer numerosezione);
    void deleteById(Integer id);
    List<Iscritti> findByTipoelezioneId(Integer idtipoelezione);
    List<Iscritti> findByTipoelezione(TipoElezione tipoElezione);


}
