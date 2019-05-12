package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IRicalcoloCostAperturaService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.repository.RicalcoloCostAperturaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RicalcoloCostAperturaService implements IRicalcoloCostAperturaService {


    @Autowired
    private RicalcoloCostAperturaDAO ricalcoloCostAperturaDAO;

    @Override
    public void SaveAll(List<RicalcoloCostApertura> list)
    {
        ricalcoloCostAperturaDAO.saveAll(list);
    }

    @Override
    public void add(RicalcoloCostApertura cost) {
        ricalcoloCostAperturaDAO.saveAndFlush(cost);
    }

    @Override
    public void update(RicalcoloCostApertura cost) {
        ricalcoloCostAperturaDAO.save(cost);
    }

    @Override
    public void delete(Long id)
    {
        ricalcoloCostAperturaDAO.deleteById(id);
    }

    @Override
    public List<RicalcoloCostApertura> findAllBy() {
        return ricalcoloCostAperturaDAO.findAllBy();
    }

    @Override
    public RicalcoloCostApertura findAllById(int id) {
        return ricalcoloCostAperturaDAO.findAllById(id);
    }

    @Override
    public List<RicalcoloCostApertura> findByTipoelezioneId(int tipoElezioneId) {
        return ricalcoloCostAperturaDAO.findByTipoelezioneId(tipoElezioneId);
    }

    @Override
    public List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId, int tipoElezioneId) {
        return ricalcoloCostAperturaDAO.findByTiporicalcoloIdAndTipoelezioneId(tipoRicalcoloId,tipoElezioneId);
    }

    @Override
    public List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId, int tipoElezioneId) {
        return ricalcoloCostAperturaDAO.findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(tipoRicalcoloId,tipoElezioneId);
    }


    @Override
    public List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneId(int municipio, int tipoElezioneId) {
        return ricalcoloCostAperturaDAO.findByMunicipioAndTipoelezioneId(municipio,tipoElezioneId);
    }

    @Override
    public List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoElezioneId) {
        return ricalcoloCostAperturaDAO.findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(municipio,tipoElezioneId);
    }

    @Override
    public List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio,int tipoElezioneId, int tipoRicalcoloId) {
        return ricalcoloCostAperturaDAO.findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(municipio,tipoElezioneId, tipoRicalcoloId);
    }

    @Override
    public List<RicalcoloCostApertura> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloCostAperturaDAO.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(tipoElezioneId,tipoRicalcoloId,municipio);
    }

    @Override
    public List<RicalcoloCostApertura> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloCostAperturaDAO.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,municipio);
    }

    @Override
    public List<RicalcoloCostApertura> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloCostAperturaDAO.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,municipio);
    }


}
