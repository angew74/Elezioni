/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;

import java.util.List;
import java.util.Optional;

/**
 * @author AdminDSI
 */
public interface IIscrittiService {

    Optional<Iscritti> findIscrittiById(Integer id);

    List<Iscritti> findIscrittiByMun(Integer mun);

     List<Iscritti> findIscrittiBySezione(Integer sezione);

    void add(Iscritti matrice);

    void delete(Integer id);

    List<Iscritti> findByIdTipoElezione(Integer idtipoelezione);

    List<Iscritti> findByTipoElezione(TipoElezione tipoelezione);

    Iscritti findByNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoElezioneId);

}
