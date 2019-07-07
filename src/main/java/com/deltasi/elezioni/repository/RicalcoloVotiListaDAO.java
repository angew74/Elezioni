package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.ricalcoli.RicalcoloVotiLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloVotiListaDAO extends JpaRepository<RicalcoloVotiLista, Long> {


    List<RicalcoloVotiLista> findAllBy();
    RicalcoloVotiLista findAllById(int id);
    List<RicalcoloVotiLista> findFirstByTipoelezioneIdAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    List<RicalcoloVotiLista> findFirstByTipoelezioneIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloVotiLista findFirstByTipoelezioneIdAndMunicipioAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int Municipio, int ListaId);
    @Modifying
    @Query("select a from RicalcoloVotiLista a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio not in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloVotiLista b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio not in (?3))")
    List<RicalcoloVotiLista> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    List<RicalcoloVotiLista> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);
    @Modifying
    @Query("select a from RicalcoloVotiLista a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio in (?3) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloVotiLista b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio in (?3))")
    List<RicalcoloVotiLista> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio);


}
