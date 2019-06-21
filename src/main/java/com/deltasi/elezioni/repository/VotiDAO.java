package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.service.TipoElezioneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotiDAO extends JpaRepository<Voti, Long> {
    Voti findById(Integer id);
    List<Voti> findAllBy();
    Voti findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Voti> findBySezionePlessoIdAndTipoelezioneId(int plessoid,int tipoelezioneid);
}
