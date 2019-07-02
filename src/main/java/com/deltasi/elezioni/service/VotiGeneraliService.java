package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.IVotiGeneraliService;
import com.deltasi.elezioni.contracts.IVotiGeneraliService;
import com.deltasi.elezioni.model.risultati.VotiGenerali;
import com.deltasi.elezioni.model.risultati.VotiGenerali;
import com.deltasi.elezioni.repository.VotiGeneraliDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VotiGeneraliService implements IVotiGeneraliService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private VotiGeneraliDAO votiGeneraliDAO;


    @Override
    public void SaveAll(List<VotiGenerali> list) {
        votiGeneraliDAO.saveAll(list);
    }

    @Override
    public VotiGenerali findById(Integer id) {
        return votiGeneraliDAO.findById(id);
    }

    @Override
    public List<VotiGenerali> findAllBy() {
        return votiGeneraliDAO.findAllBy();
    }

    @Override
    public VotiGenerali findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return votiGeneraliDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione,tipoelezioneid);
    }

    @Override
    public List<VotiGenerali> findBySezionePlessoIdAndTipoelezioneId(int plessoid, int tipoelezioneid) {
        return votiGeneraliDAO.findBySezionePlessoIdAndTipoelezioneId(plessoid,tipoelezioneid);
    }
}
