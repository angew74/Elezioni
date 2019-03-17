package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

public interface PlessoDAO extends JpaRepository<Plesso, Long> {
    public Plesso findById(Integer id);
    public void deleteById(Integer id);
    public Plesso findByTipoelezioneId(Integer idtipoelezione);
    public Plesso findByTipoelezione(TipoElezione tipoelezione);
    public Plesso findByMunicipio(Integer mun);

}
