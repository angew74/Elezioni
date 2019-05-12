package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;

import java.util.List;

public interface IRicalcoloCostAperturaService {
    void add(RicalcoloCostApertura cost);
    void update(RicalcoloCostApertura cost);
    void SaveAll(List<RicalcoloCostApertura> list);
    void delete(Long id);
    List<RicalcoloCostApertura> findAllBy();
    RicalcoloCostApertura findAllById(int id);
    List<RicalcoloCostApertura> findByTipoelezioneId(int tipoElezioneId);
    List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio, int tipoElezioneId, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloCostApertura> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloCostApertura> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
}
