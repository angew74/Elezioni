package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;

import java.util.List;

public interface IRicalcoloAffluenzaService {

    List<RicalcoloAffluenza> findAllBy();
    RicalcoloAffluenza findAllById(int id);
    List<RicalcoloAffluenza> findByTipoelezioneId(int tipoElezioneId);
    List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio,int tipoElezioneId, int tipoRicalcoloId);
    void SaveAll(List<RicalcoloAffluenza> list);
    List<RicalcoloAffluenza> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int Municipio);
    RicalcoloAffluenza findFirstByTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloAffluenza> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloAffluenza> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(int tipoElezioneId, int tipoRicalcoloId,int municipio);
}
