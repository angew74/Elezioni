package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IAggregazioneInterrogazioneService;
import com.deltasi.elezioni.model.configuration.AggregazioneInterrogazione;
import com.deltasi.elezioni.repository.AggregazioneInterrogazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AggregazioneInterrogazioneService implements IAggregazioneInterrogazioneService {

    @Autowired
    AggregazioneInterrogazioneDAO aggregazioneInterrogazioneDAO;

    @Override
    public AggregazioneInterrogazione findById(Integer id) {
        return aggregazioneInterrogazioneDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
aggregazioneInterrogazioneDAO.deleteById(id);
    }

    @Override
    public List<AggregazioneInterrogazione> findAllByTipoelezioneId(int tipoElezioneId) {
        return aggregazioneInterrogazioneDAO.findAllByTipoelezioneId(tipoElezioneId);
    }
}
