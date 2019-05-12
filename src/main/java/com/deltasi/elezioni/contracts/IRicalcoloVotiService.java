package com.deltasi.elezioni.contracts;



import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;

import java.util.List;

public interface IRicalcoloVotiService {

    List<RicalcoloVoti> findAllBy();
    RicalcoloVoti findAllById(int id);
    void SaveAll(List<RicalcoloVoti> list);
    List<RicalcoloVoti> findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloVoti findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio,int ListaId);
    List<RicalcoloVoti> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    List<RicalcoloVoti> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloVoti> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloVoti> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
}
