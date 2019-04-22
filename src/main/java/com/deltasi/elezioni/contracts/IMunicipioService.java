package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Municipio;

import java.util.List;

public interface IMunicipioService {

    Municipio findById(Integer id);
    void add(Municipio elegen);
    void delete(Integer id);
    Municipio findBymunicipio(Integer id);
    List<Municipio> getAll();
}
