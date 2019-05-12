package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;

import java.util.List;

public interface IRicalcoloPreferenzeService {
    List<RicalcoloPreferenze> findAllBy();
    void SaveAll(List<RicalcoloPreferenze> list);
    RicalcoloPreferenze findAllById(int id);
    List<RicalcoloPreferenze> findByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloPreferenze findFirstByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    List<RicalcoloPreferenze> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio,int idlista);
    List<RicalcoloPreferenze> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio, int idlista);
    List<RicalcoloPreferenze> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio, int idlista);


}
