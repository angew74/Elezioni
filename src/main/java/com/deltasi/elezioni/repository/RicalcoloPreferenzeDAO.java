package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloPreferenzeDAO  extends JpaRepository<RicalcoloPreferenze, Long> {

    List<RicalcoloPreferenze> findAllBy();
    RicalcoloPreferenze findAllById(int id);
    List<RicalcoloPreferenze> findByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloPreferenze findFirstByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    @Modifying
    @Query("select a from RicalcoloPreferenze a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio not in (?3) and a.lista.id in (?4) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloPreferenze b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio not in (?3) and b.lista.id in (?4))")
    List<RicalcoloPreferenze> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(int tipoElezioneId, int tipoRicalcoloId,int municipio, int idlista);
    //List<RicalcoloPreferenze> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio, int idlista);
    @Modifying
    @Query("select a from RicalcoloPreferenze a " +
            "  where a.tipoelezione.id=?1 and a.tiporicalcolo.id=?2 and a.municipio in (?3) and a.lista.id in (?4) "+
            " and a.dataoperazione=(select max(dataoperazione) from RicalcoloPreferenze b where b.tipoelezione.id=?1 and b.tiporicalcolo.id=?2 and b.municipio in (?3) and b.lista.id in (?4))")
    List<RicalcoloPreferenze> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio, int idlista);

}
