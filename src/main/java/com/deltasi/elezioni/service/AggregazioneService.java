package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IAggregazioneService;
import com.deltasi.elezioni.model.configuration.Aggregazione;
import com.deltasi.elezioni.repository.AggregazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AggregazioneService implements IAggregazioneService {

    @Autowired
    private AggregazioneDAO aggregazioneDAO;

    @Override
    public Aggregazione findById(Integer id) {
        return aggregazioneDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        aggregazioneDAO.deleteById(id);
    }

    @Override
    public List<Aggregazione> FindAllBytipoElezioneId(int tipoElezioneId) {
        return aggregazioneDAO.findAllByTipoelezioneId(tipoElezioneId);
    }
}
