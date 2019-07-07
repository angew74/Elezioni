package com.deltasi.elezioni.contracts;



import com.deltasi.elezioni.model.ricalcoli.RicalcoloVotiLista;

import java.util.List;

public interface IRicalcoloVotiListaService {

    List<RicalcoloVotiLista> findAllBy();
    RicalcoloVotiLista findAllById(int id);
    void SaveAll(List<RicalcoloVotiLista> list);
    List<RicalcoloVotiLista> findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloVotiLista findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio,int ListaId);
    List<RicalcoloVotiLista> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    List<RicalcoloVotiLista> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloVotiLista> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloVotiLista> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
}
