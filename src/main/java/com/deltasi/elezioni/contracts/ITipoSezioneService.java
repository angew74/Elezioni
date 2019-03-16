/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.TipoSezione;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface ITipoSezioneService {
    
    public TipoSezione findTipoSezioneById(Integer id);    
    public TipoSezione findTipoSezioneByCodice(String codice);    
    public List<TipoSezione> getAll();
    
}
