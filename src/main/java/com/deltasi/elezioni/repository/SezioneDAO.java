package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.Sezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SezioneDAO extends JpaRepository<Sezione, Long> {

    Sezione findById(Integer id);
    Sezione findByNumerosezioneAndTipoelezioneId(Integer numeroSezione, Integer tipoElezioneId);
    List<Sezione> findAllBy();
    List<Long> countAllByTipoelezioneIdAndTipoelezioneIdIn(int tipoElezione, int tipoElezione1);
    List<Long> countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(int tipoElezioneId, int municipio,int tipoElezione1);
    Sezione findByNumerosezioneAndCabinaAndTipoelezioneId(int numeroSezione,int cabina, int tipoElezione);


}
