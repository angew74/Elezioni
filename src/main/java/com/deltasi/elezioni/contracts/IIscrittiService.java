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

    Iscritti findBySezioneId(Integer idsezione);

    Iscritti findByTipoelezioneIdAndSezioneNumerosezione(Integer tipoElezioneId, Integer numerosezione);

    void add(Iscritti matrice);

    void delete(Integer id);

    List<Iscritti> findByIdTipoElezione(Integer idtipoelezione);

    List<Iscritti> findByTipoElezione(TipoElezione tipoelezione);

    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza1(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza1(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza2(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza2(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza3(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza3(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura1(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllApertura1(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura2(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllApertura2(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione1(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione1(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione2(int tipoelezioneid);


    List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione2(int tipoelezioneid);

}
