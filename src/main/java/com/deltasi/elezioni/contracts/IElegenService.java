/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Elegen;
import com.deltasi.elezioni.model.configuration.TipoElezione;

/**
 *
 * @author AdminDSI
 */
public interface IElegenService {
    
    public Elegen findById(Integer id);
    public void add(Elegen elegen);
    public void delete(Integer id);
    public Elegen findByIdTipoElezione(Integer idtipoelezione);
    public Elegen findByTipoElezione(TipoElezione tipoelezione);
    
}
