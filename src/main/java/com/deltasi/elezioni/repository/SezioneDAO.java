package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.Sezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SezioneDAO extends JpaRepository<Sezione, Long> {

    Sezione findById(Integer id);
    Sezione findByNumerosezioneAndTipoelezioneId(Integer numeroSezione, Integer tipoElezioneId);
    List<Sezione> findAllBy();
    List<Integer> countAllByTipoelezioneIdAndTipoelezioneIdIn(int tipoElezione, int tipoElezione1);
    List<Integer> countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(int tipoElezioneId, int municipio,int tipoElezione1);


}
