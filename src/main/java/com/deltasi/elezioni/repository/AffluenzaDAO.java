package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.authentication.Authorities;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffluenzaDAO extends JpaRepository<Affluenza, Long> {

    Affluenza findById(Integer id);
    Affluenza findByNumerosezione(Integer num);
    List<Affluenza> findByPlessoId(Integer idplesso);
    List<Affluenza> findByPlessoMunicipio(Integer municipio);
    List<Affluenza> findByPlesso(Plesso plesso);
    List<Affluenza> findByTipoelezione(TipoElezione tipoElezione);
    List<Affluenza> findByTipoelezioneId(Integer idTipoElezione);
    List<Affluenza> findByApertura1(int a);
    List<Affluenza> findByApertura2(int a);
    List<Affluenza> findByApertura3(int a);
    List<Affluenza> findByCostituzione1(int c);
    List<Affluenza> findByCostituzione2(int c);
    List<Affluenza> findByAffluenza1(int a);
    List<Affluenza> findByAffluenza2(int a);
    List<Affluenza> findByAffluenza3(int a);
    List<Affluenza> findByAffluenza4(int a);
    List<Affluenza> findByAffluenza5(int a);
}
