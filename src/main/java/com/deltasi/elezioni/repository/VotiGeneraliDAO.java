package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.risultati.VotiGenerali;
import com.deltasi.elezioni.service.TipoElezioneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotiGeneraliDAO extends JpaRepository<VotiGenerali, Long> {
    VotiGenerali findById(Integer id);
    List<VotiGenerali> findAllBy();
    VotiGenerali findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiGenerali> findBySezionePlessoIdAndTipoelezioneId(int plessoid,int tipoelezioneid);
}
