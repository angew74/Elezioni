package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;

import java.util.List;

public interface IPlessoService {
    Plesso findById(Integer id);
    void deleteById(Integer id);
    Plesso findByTipoelezioneId(Integer idtipoelezione);
    Plesso findByTipoelezione(TipoElezione tipoelezione);
    Plesso findByMunicipio(Integer mun);
    List<Plesso> findByTipoelezioneIdAndDescrizioneLike(int tipoElezioneId, String descrizione);
    List<Plesso> findByTipoelezioneIdAndUbicazioneLike(int tipoElezioneId,String ubicazione);
}
