package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IRicalcoloAffluenzaService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.repository.RicalcoloAffluenzaDAO;
import org.omg.CORBA.PUBLIC_MEMBER;
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
    public void SaveAll(List<RicalcoloAffluenza> list)
    {
        ricalcoloAffluenzaDAO.saveAll(list);
    }

    @Override
    public List<RicalcoloAffluenza> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int Municipio) {
        return ricalcoloAffluenzaDAO.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,Municipio);
    }

    @Override
    public RicalcoloAffluenza findFirstByTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId) {
        return ricalcoloAffluenzaDAO.findFirstByTipoelezioneIdAndTiporicalcoloIdOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId);
    }

    @Override
    public List<RicalcoloAffluenza> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId,int municipio)
    {
        return ricalcoloAffluenzaDAO.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioInOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,municipio);
    }

    @Override
    public List<RicalcoloAffluenza> findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInAndDataoperazioneMax(int tipoElezioneId, int tipoRicalcoloId,int municipio)
    {
        return ricalcoloAffluenzaDAO.findByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotIn(tipoElezioneId,tipoRicalcoloId,municipio);
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



    @Override
    public List<RicalcoloAffluenza> findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(int tipoElezioneId, int tipoRicalcoloId, int municipio) {
        return ricalcoloAffluenzaDAO.findTopByTipoelezioneIdAndTiporicalcoloIdAndMunicipioNotInOrderByDataoperazioneDesc(tipoElezioneId,tipoRicalcoloId,municipio);
    }
}
