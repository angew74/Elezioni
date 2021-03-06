package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PlessoDAO extends JpaRepository<Plesso, Long> {
    Plesso findById(Integer id);
    void deleteById(Integer id);
    Plesso findByTipoelezioneId(Integer idtipoelezione);
    Plesso findByTipoelezione(TipoElezione tipoelezione);
    Plesso findByMunicipio(Integer mun);
    List<Plesso> findByTipoelezioneIdAndDescrizioneLike(int tipoElezioneId, String descrizione);
    List<Plesso> findByTipoelezioneIdAndUbicazioneLike(int tipoElezioneId,String ubicazione);


}
