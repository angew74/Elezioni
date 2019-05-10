package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RicalcoloPreferenzeDAO  extends JpaRepository<RicalcoloPreferenze, Long> {

    List<RicalcoloPreferenze> findAllBy();
    RicalcoloPreferenze findAllById(int id);
    List<RicalcoloPreferenze> findByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloPreferenze findFirstByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);

}
