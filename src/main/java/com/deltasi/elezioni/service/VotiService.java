package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.IVotiService;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.repository.VotiDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VotiService implements IVotiService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private VotiDAO votiDAO;


    @Override
    public void SaveAll(List<com.deltasi.elezioni.model.risultati.Voti> list) {
        votiDAO.saveAll(list);
    }

    @Override
    public com.deltasi.elezioni.model.risultati.Voti findById(Integer id) {
        return votiDAO.findById(id);
    }

    @Override
    public List<com.deltasi.elezioni.model.risultati.Voti> findAllBy() {
        return votiDAO.findAllBy();
    }

    @Override
    public Voti findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return votiDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione,tipoelezioneid);
    }

    @Override
    public List<com.deltasi.elezioni.model.risultati.Voti> findBySezionePlessoIdAndTipoelezioneId(int plessoid, int tipoelezioneid) {
        return votiDAO.findBySezionePlessoIdAndTipoelezioneId(plessoid,tipoelezioneid);
    }
}
