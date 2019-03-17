package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.repository.AffluenzaDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AffluenzaService implements IAffluenzaService {

    private static final Logger logger = LogManager.getLogger(ElegenService.class);

    @Autowired
    private AffluenzaDAO affluenzaDAO;



    @Override
    public void add(Affluenza affluenza) {
        affluenzaDAO.saveAndFlush(affluenza);
    }

    @Override
    public void update(Affluenza affluenza) {
        affluenzaDAO.save(affluenza);
    }

    @Override
    public void delete(Long id) {
        affluenzaDAO.deleteById(id);
    }

    @Override
    public Affluenza findById(Integer id) {
      return  affluenzaDAO.findById(id);
    }

    @Override
    public List<Affluenza> findByPlessoMunicipio(Integer municipio) {
        return  affluenzaDAO.findByPlessoMunicipio(municipio);
    }

    @Override
    public Affluenza findByNumerosezione(Integer num) {
        return  affluenzaDAO.findByNumerosezione(num);
    }

    @Override
    public List<Affluenza> findByPlessoId(Integer idplesso) {
        return  affluenzaDAO.findByPlessoId(idplesso);
    }

    @Override
    public List<Affluenza> findByPlesso(Plesso plesso) {
        return  affluenzaDAO.findByPlesso(plesso);
    }

    @Override
    public List<Affluenza> findByTipoelezione(TipoElezione tipoElezione) {
        return  affluenzaDAO.findByTipoelezione(tipoElezione);
    }

    @Override
    public List<Affluenza> findByTipoelezioneId(Integer idTipoElezione) {
        return  affluenzaDAO.findByTipoelezioneId(idTipoElezione);
    }

    @Override
    public List<Affluenza> findByApertura1(int a) {
        return  affluenzaDAO.findByApertura1(a);
    }

    @Override
    public List<Affluenza> findByApertura2(int a) {
        return  affluenzaDAO.findByApertura2(a);
    }

    @Override
    public List<Affluenza> findByApertura3(int a) {
        return  affluenzaDAO.findByApertura3(a);
    }

    @Override
    public List<Affluenza> findByCostituzione1(int c) {
        return  affluenzaDAO.findByCostituzione1(c);
    }

    @Override
    public List<Affluenza> findByCostituzione2(int c) {
        return  affluenzaDAO.findByCostituzione2(c);
    }

    @Override
    public List<Affluenza> findByAffluenza1(int a) {
        return  affluenzaDAO.findByAffluenza1(a);
    }

    @Override
    public List<Affluenza> findByAffluenza2(int a) {
        return  affluenzaDAO.findByAffluenza2(a);
    }

    @Override
    public List<Affluenza> findByAffluenza3(int a) {
        return  affluenzaDAO.findByAffluenza3(a);
    }

    @Override
    public List<Affluenza> findByAffluenza4(int a) {
        return  affluenzaDAO.findByAffluenza4(a);
    }

    @Override
    public List<Affluenza> findByAffluenza5(int a) {
        return  affluenzaDAO.findByAffluenza5(a);
    }

}
