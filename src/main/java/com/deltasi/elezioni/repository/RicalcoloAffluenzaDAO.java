package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicalcoloAffluenzaDAO extends JpaRepository<RicalcoloAffluenza, Long> {

    List<RicalcoloAffluenza> findAllBy();
    RicalcoloAffluenza findAllById(int id);
    List<RicalcoloAffluenza> findByTipoelezioneId(int tipoElezioneId);
    List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio, int tipoElezioneId, int tipoRicalcoloId);
}
