package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IRicalcoloAffluenzaService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.repository.RicalcoloAffluenzaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RicalcoloAffluenzaService implements IRicalcoloAffluenzaService {

    @Autowired
    private RicalcoloAffluenzaDAO ricalcoloAffluenzaDAO;

    @Override
    public List<RicalcoloAffluenza> findAllBy() {
        return ricalcoloAffluenzaDAO.findAllBy();
    }

    @Override
    public RicalcoloAffluenza findAllById(int id) {
        return ricalcoloAffluenzaDAO.findAllById(id);
    }

    @Override
    public List<RicalcoloAffluenza> findByTipoelezioneId(int tipoElezioneId) {
        return ricalcoloAffluenzaDAO.findByTipoelezioneId(tipoElezioneId);
    }

    @Override
    public List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneId(int tipoRicalcoloId, int tipoElezioneId) {
        return ricalcoloAffluenzaDAO.findByTiporicalcoloIdAndTipoelezioneId(tipoRicalcoloId,tipoElezioneId);
    }

    @Override
    public List<RicalcoloAffluenza> findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(int tipoRicalcoloId, int tipoElezioneId) {
        return ricalcoloAffluenzaDAO.findByTiporicalcoloIdAndTipoelezioneIdOrderByDataoperazioneDesc(tipoRicalcoloId,tipoElezioneId);
    }

    @Override
    public List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneId(int municipio, int tipoRicalcoloId) {
        return ricalcoloAffluenzaDAO.findByMunicipioAndTipoelezioneId(municipio,tipoRicalcoloId);
    }

    @Override
    public List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(int municipio, int tipoRicalcoloId) {
        return ricalcoloAffluenzaDAO.findByMunicipioAndTipoelezioneIdOrderByDataoperazioneDesc(municipio,tipoRicalcoloId);
    }

    @Override
    public List<RicalcoloAffluenza> findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int municipio,int tipoElezioneId, int tipoRicalcoloId) {
        return ricalcoloAffluenzaDAO.findByMunicipioAndTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(municipio,tipoElezioneId, tipoRicalcoloId);
    }
}
