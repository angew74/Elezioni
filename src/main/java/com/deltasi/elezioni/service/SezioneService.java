package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.ISezioneService;
import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.repository.SezioneDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SezioneService implements ISezioneService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private SezioneDAO sezioneDAO;

    @Override
    public Sezione findById(Integer id) {
        return  sezioneDAO.findById(id);
    }

    @Override
    public Sezione findByNumerosezioneAndTipoelezioneId(Integer numeroSezione, Integer tipoElezioneId) {
       return  sezioneDAO.findByNumerosezioneAndTipoelezioneId(numeroSezione,tipoElezioneId);
    }

    @Override
    public List<Sezione> findAllBy() {
        return  findAllBy();
    }

    @Override
    public List<Long> countAllByTipoelezioneIdAndTipoelezioneIdIn(int tipoElezione, int tipoElezione1) {
        return sezioneDAO.countAllByTipoelezioneIdAndTipoelezioneIdIn(tipoElezione,tipoElezione1);
    }

    @Override
    public List<Long> countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(int tipoElezioneId, int municipio, int tipoElezioneId1) {
        return sezioneDAO.countAllByTipoelezioneIdAndMunicipioAndTipoelezioneIdIn(tipoElezioneId, municipio, tipoElezioneId1);
    }

    @Override
    public Sezione findByNumerosezioneAndCabinaAndTipoelezioneId(int numeroSezione, int cabina, int tipoElezioneId)
    {
        return sezioneDAO.findByNumerosezioneAndCabinaAndTipoelezioneId(numeroSezione,cabina,tipoElezioneId);
    }
}
