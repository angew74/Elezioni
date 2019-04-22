package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioDAO extends JpaRepository<Municipio, Long> {

    Municipio findById(Integer id);
    Municipio findByMunicipio(Integer mun);
    List<Municipio> findAllBy();
}
