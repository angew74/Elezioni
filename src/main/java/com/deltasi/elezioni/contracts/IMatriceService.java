/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Matrice;
import com.deltasi.elezioni.model.configuration.TipoElezione;

/**
 *
 * @author AdminDSI
 */
public interface IMatriceService {
    public Matrice findMatriceById(Integer id);
    public Matrice findMatriceByMun(Integer mun);
    public void add(Matrice matrice);
    public void delete(Integer id);
    public Matrice findByIdTipoElezione(Integer idtipoelezione);
    public Matrice findByTipoElezione(TipoElezione tipoelezione);
}
