package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloSindaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloSindacoDAO extends JpaRepository<RicalcoloSindaco, Long> {

    List<RicalcoloSindaco> findAllBy();
    RicalcoloSindaco findAllById(int id);
    List<RicalcoloSindaco> findFirstByTipoelezioneIdAndSindacoIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    List<RicalcoloSindaco> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloSindaco findFirstByTipoelezioneIdAndMunicipioAndSindacoIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio, int ListaId);
    @Modifying
    @Query("select a from RicalcoloSindaco a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio not in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloSindaco b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio not in (?3))")
    List<RicalcoloSindaco> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloSindaco> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    @Modifying
    @Query("select a from RicalcoloSindaco a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloSindaco b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio in (?3))")
    List<RicalcoloSindaco> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);

}
