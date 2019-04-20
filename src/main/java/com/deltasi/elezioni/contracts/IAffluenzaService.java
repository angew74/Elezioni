package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.risultati.Affluenza;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAffluenzaService {


    void add(Affluenza affluenza);

    void update(Affluenza affluenza);

    void delete(Long id);

    Affluenza findBySezioneNumerosezioneAndTipoelezioneId(Integer sezione, Integer tipoElezioneId);

    Affluenza findById(Integer id);

    List<Affluenza> findByPlessoMunicipio(Integer municipio);

    Affluenza findBySezioneId(Integer sezioneid);

    List<Affluenza> findByPlessoId(Integer idplesso);

    List<Affluenza> findByPlesso(Plesso plesso);

    List<Affluenza> findByTipoelezione(TipoElezione tipoElezione);

    List<Affluenza> findByTipoelezioneId(Integer idTipoElezione);

    List<Affluenza> findByApertura1(int a, int idTipoElezione);

    List<Affluenza> findByApertura2(int a, int idTipoElezione);

    List<Affluenza> findByApertura3(int a, int idTipoElezione);

    List<Affluenza> findByCostituzione1(int c, int idTipoElezione);

    List<Affluenza> findByCostituzione2(int c, int idTipoElezione);

    List<Affluenza> findByAffluenza1(int a, int idTipoElezione);

    List<Affluenza> findByAffluenza2(int a, int idTipoElezione);

    List<Affluenza> findByAffluenza3(int a, int idTipoElezione);

    List<Affluenza> findByAffluenza4(int a, int idTipoElezione);

    List<Affluenza> findByAffluenza5(int a, int idTipoElezione);

    /* count totali */
    /* interrogazioni per sezione */
    List<Affluenza> findByAffluenza1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    List<Affluenza> findByAffluenza2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    List<Affluenza> findByAffluenza3AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    List<Affluenza> findByCostituzione1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    List<Affluenza> findByCostituzione2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    List<Affluenza> findByApertura1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    List<Affluenza> findByApertura2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione);

    /* interrogazione per Municipio*/
    List<Affluenza> findByAffluenza1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Affluenza> findByAffluenza2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Affluenza> findByAffluenza3AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Affluenza> findByCostituzione1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Affluenza> findByCostituzione2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Affluenza> findByApertura1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Affluenza> findByApertura2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio);

    List<Integer> countByAffluenza1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByAffluenza2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByAffluenza3AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1);
    /* count per sola tipologia */
    List<Long> countByAffluenza1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Long> countByAffluenza2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Long> countByAffluenza3AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByApertura2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<Integer> countByCostituzione2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1);
    List<RicalcoloAffluenza> countAffluenza1(int tipoelezioneid);
    List<RicalcoloAffluenza> countAffluenza1ByMunicipio(int tipoelezioneid);
    List<RicalcoloAffluenza> countAffluenza2(int tipoelezioneid);
    List<RicalcoloAffluenza> countAffluenza2ByMunicipio(int tipoelezioneid);
    List<RicalcoloAffluenza> countAffluenza3(int tipoelezioneid);
    List<RicalcoloAffluenza> countAffluenza3ByMunicipio(int tipoelezioneid);
    List<RicalcoloCostApertura> countApertura1(int tipoelezioneid);
    List<RicalcoloCostApertura> countApertura2(int tipoelezioneid);
    List<RicalcoloCostApertura> countCostituzione1(int tipoelezioneid);
    List<RicalcoloCostApertura> countCostituzione2(int tipoelezioneid);
    List<RicalcoloCostApertura> countApertura1ByMunicipio(int tipoelezioneid);
    List<RicalcoloCostApertura> countApertura2ByMunicipio(int tipoelezioneid);
    List<RicalcoloCostApertura> countCostituzione1ByMunicipio(int tipoelezioneid);
    List<RicalcoloCostApertura> countCostituzione2ByMunicipio(int tipoelezioneid);

}
