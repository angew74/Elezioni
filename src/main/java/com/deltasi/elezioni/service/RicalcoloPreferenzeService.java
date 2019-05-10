package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IRicalcoloPreferenzeService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.repository.RicalcoloPreferenzeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RicalcoloPreferenzeService implements IRicalcoloPreferenzeService {

    @Autowired
    RicalcoloPreferenzeDAO ricalcoloPreferenzeDAO;

    @Override
     public List<RicalcoloPreferenze> findAllBy()
    {
        return  ricalcoloPreferenzeDAO.findAllBy();
    }

    @Override
    public void SaveAll(List<RicalcoloPreferenze> list) {
        ricalcoloPreferenzeDAO.saveAll(list);
    }

    @Override
    public RicalcoloPreferenze findAllById(int id)
    {
        return  ricalcoloPreferenzeDAO.findAllById(id);
    }

    @Override
    public List<RicalcoloPreferenze> findByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId)
    {
        return  ricalcoloPreferenzeDAO.findByTipoelezioneAndListaIdOrderByDataoperazioneDesc(tipoElezioneId,ListaId);
    }

    @Override
    public RicalcoloPreferenze findFirstByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId)
    {
        return ricalcoloPreferenzeDAO.findFirstByTipoelezioneAndListaIdOrderByDataoperazioneDesc(tipoElezioneId,ListaId);
    }

}
