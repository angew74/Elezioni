package com.deltasi.elezioni.service;


import com.deltasi.elezioni.contracts.IVotiService;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.repository.VotiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VotiService implements IVotiService {

    @Autowired
    VotiDAO votiDAO;

    @Override
    public void SaveAll(List<Voti> list) {
        votiDAO.saveAll(list);
    }

    @Override
    public void Save(Voti voti) {
        votiDAO.save(voti);
    }

    @Override
    public Voti findById(Integer id) {
        return votiDAO.findById(id);
    }

    @Override
    public List<Voti> findAllBy() {
        return votiDAO.findAllBy();
    }

    @Override
    public Voti findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return votiDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione, tipoelezioneid);
    }

    @Override
    public List<Voti> findBySezionePlessoIdAndTipoelezioneId(int plessoid, int tipoelezioneid) {
        return votiDAO.findBySezionePlessoIdAndTipoelezioneId(plessoid, tipoelezioneid);
    }
}
