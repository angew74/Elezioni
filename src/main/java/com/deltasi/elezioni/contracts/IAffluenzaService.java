package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.risultati.Affluenza;

import java.util.List;

public interface IAffluenzaService {


    public void add(Affluenza affluenza);
    public void update(Affluenza affluenza);
    public void delete(Long id);
    Affluenza findByNumerosezioneAndTipoelezioneId(Integer sezione, Integer tipoElezioneId);
    Affluenza findById(Integer id);
    List<Affluenza> findByPlessoMunicipio(Integer municipio);
    Affluenza findByNumerosezione(Integer num);
    List<Affluenza> findByPlessoId(Integer idplesso);
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
