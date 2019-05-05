package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloAffluenzaDAO extends JpaRepository<RicalcoloAffluenza, Long> {

    List<RicalcoloAffluenza> findAllBy();
    RicalcoloAffluenza findAllById(int id);
    List<RicalcoloAffluenza> findByTipoelezioneId(int tipoElezioneId);
    List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId,int tipoElezioneId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio, int tipoElezioneId, int tipoRicalcoloId);
    List<RicalcoloAffluenza> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int Municipio);
    RicalcoloAffluenza findFirstByTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId);
    @Modifying
    @Query("select a from RicalcoloAffluenza a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio not in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloAffluenza b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio not in (?3))")
    List<RicalcoloAffluenza> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloAffluenza> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloAffluenza> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);

}
