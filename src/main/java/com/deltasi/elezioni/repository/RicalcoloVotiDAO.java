package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloVotiDAO extends JpaRepository<RicalcoloVoti, Long> {


    List<RicalcoloVoti> findAllBy();
    RicalcoloVoti findAllById(int id);
    List<RicalcoloVoti> findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    List<RicalcoloVoti> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloVoti findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio, int ListaId);
    @Modifying
    @Query("select a from RicalcoloVoti a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio not in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloVoti b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio not in (?3))")
    List<RicalcoloVoti> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloVoti> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    @Modifying
    @Query("select a from RicalcoloVoti a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloVoti b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio in (?3))")
    List<RicalcoloVoti> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);


}
