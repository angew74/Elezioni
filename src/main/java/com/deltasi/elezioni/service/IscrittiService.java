/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IIscrittiService;
import com.deltasi.elezioni.repository.IscrittiDAO;
import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AdminDSI
 */
@Service
@Transactional
public class IscrittiService implements IIscrittiService {

    private static final Logger logger = LogManager.getLogger(IscrittiService.class);

    @Autowired
    private IscrittiDAO iscrittiDAO;

    @Override
    public Optional<Iscritti> findIscrittiById(Integer id) {
        return iscrittiDAO.findById(id);
    }

    @Override
    public List<Iscritti> findIscrittiByMun(Integer mun) {
        return
                iscrittiDAO.findByMunicipio(mun);
    }

    @Override
    public Iscritti findBySezioneId(Integer idsezione) {
        return iscrittiDAO.findBySezioneId(idsezione);
    }

    @Override
    public Iscritti findByTipoelezioneIdAndSezioneNumerosezione(Integer tipoElezioneId, Integer numerosezione) {
        return iscrittiDAO.findByTipoelezioneIdAndSezioneNumerosezione(tipoElezioneId, numerosezione);
    }

    @Override
    public void add(Iscritti matrice) {
        iscrittiDAO.save(matrice);
    }

    @Override
    public void delete(Integer id) {
        iscrittiDAO.deleteById(id);
    }

    @Override
    public List<Iscritti> findByIdTipoElezione(Integer idtipoelezione) {
        return iscrittiDAO.findByTipoelezioneId(idtipoelezione);
    }

    @Override
    public List<Iscritti> findByTipoElezione(TipoElezione tipoelezione) {
        return iscrittiDAO.findByTipoelezione(tipoelezione);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza1(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioAffluenza1(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza1(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllAffluenza1(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza2(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioAffluenza2(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza2(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllAffluenza2(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza3(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioAffluenza3(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza3(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllAffluenza3(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura1(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioApertura1(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllApertura1(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllApertura1(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura2(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioApertura2(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllApertura2(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllApertura2(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione1(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioCostituzione1(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione1(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllCostituzione1(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione2(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteMunicipioCostituzione2(tipoelezioneid);
    }

    @Override
    public List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione2(int tipoelezioneid) {
        return iscrittiDAO.countIscrittiSezioniPervenuteAllCostituzione2(tipoelezioneid);
    }

}
