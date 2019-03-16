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
 *
 * @author AdminDSI
 */
public interface IIscrittiService {
    
    public Optional<Iscritti> findIscrittiById(Integer id);
    public List<Iscritti> findIscrittiByMun(Integer mun);
    public Iscritti findIscrittiBySezione(Integer sezione);
    public void add(Iscritti matrice);
    public void delete(Integer id);
    public List<Iscritti> findByIdTipoElezione(Integer idtipoelezione);
    public List<Iscritti> findByTipoElezione(TipoElezione tipoelezione);
    
}
