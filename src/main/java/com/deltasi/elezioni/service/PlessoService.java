package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IPlessoService;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.repository.PlessoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlessoService implements IPlessoService {

    @Autowired
    PlessoDAO plessoDAO;
    @Override
    public Plesso findById(Integer id) {
        return plessoDAO.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
           plessoDAO.deleteById(id);
    }

    @Override
    public Plesso findByTipoelezioneId(Integer idtipoelezione) {
        return plessoDAO.findByTipoelezioneId(idtipoelezione);
    }

    @Override
    public Plesso findByTipoelezione(TipoElezione tipoelezione) {
        return plessoDAO.findByTipoelezione(tipoelezione);
    }

    @Override
    public Plesso findByMunicipio(Integer mun) {
        return plessoDAO.findByMunicipio(mun);
    }

    @Override
    public List<Plesso> findByTipoelezioneIdAndDescrizioneLike(int tipoElezioneId, String descrizione) {
        return  plessoDAO.findByTipoelezioneIdAndDescrizioneLike(tipoElezioneId,descrizione);
    }

    @Override
    public List<Plesso> findByTipoelezioneIdAndUbicazioneLike(int tipoElezioneId, String ubicazione) {
        return plessoDAO.findByTipoelezioneIdAndUbicazioneLike(tipoElezioneId,ubicazione);
    }
}
