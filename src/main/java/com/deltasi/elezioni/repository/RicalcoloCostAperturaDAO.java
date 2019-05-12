package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloCostAperturaDAO extends JpaRepository<RicalcoloCostApertura, Long> {

    List<RicalcoloCostApertura> findAllBy();
    RicalcoloCostApertura findAllById(int id);
    List<RicalcoloCostApertura> findByTipoelezioneId(int tipoElezioneId);
    List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloCostApertura> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId);
    List<RicalcoloCostApertura> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio,int tipoElezioneId, int tipoRicalcoloId);
    @Modifying
    @Query("select a from RicalcoloCostApertura a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio not in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloCostApertura b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio not in (?3))")
    List<RicalcoloCostApertura> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloCostApertura> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloCostApertura> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);


}
