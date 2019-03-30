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
    public Iscritti findById(long id);
    public List<Iscritti> findByMunicipio(Integer mun);
    public List<Iscritti> findByNumerosezione(Integer numerosezione);
    public Iscritti findByNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoElezioneId);
    public void deleteById(Integer id);
    public List<Iscritti> findByTipoelezioneId(Integer idtipoelezione);
    public List<Iscritti> findByTipoelezione(TipoElezione tipoElezione);


}
