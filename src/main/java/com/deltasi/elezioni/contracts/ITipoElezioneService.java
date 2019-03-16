/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;

/**
 *
 * @author AdminDSI
 */
public interface ITipoElezioneService {
    public TipoElezione findTipoElezioneById(Integer id);    
    public TipoElezione findElezioneByDescrizione(String codice);    
    public List<TipoElezione> getAll();
    
}
