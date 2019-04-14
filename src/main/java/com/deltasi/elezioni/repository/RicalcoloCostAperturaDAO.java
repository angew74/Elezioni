package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicalcoloCostAperturaDAO extends JpaRepository<RicalcoloCostApertura, Long> {

    List<RicalcoloCostApertura> findAllBy();
    RicalcoloCostApertura findAllById(int id);
    List<RicalcoloCostApertura> findByTipoelezioneId(int tipoElezioneId);
    List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio,int tipoElezioneId, int tipoRicalcoloId);


}
