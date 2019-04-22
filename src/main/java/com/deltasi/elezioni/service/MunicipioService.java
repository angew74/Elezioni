package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IMunicipioService;
import com.deltasi.elezioni.model.configuration.Municipio;
import com.deltasi.elezioni.repository.MunicipioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MunicipioService implements IMunicipioService {

    @Autowired
    MunicipioDAO municipioDAO;

    @Override
    public Municipio findById(Integer id) {
        return municipioDAO.findById(id);
    }

    @Override
    public void add(Municipio elegen) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Municipio findBymunicipio(Integer mun) {
        return municipioDAO.findByMunicipio(mun);
    }

    @Override
    public List<Municipio> getAll() {
        return municipioDAO.findAll();
    }
}
