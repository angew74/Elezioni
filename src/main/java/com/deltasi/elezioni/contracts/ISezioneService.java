package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Sezione;

import java.util.List;

public interface ISezioneService {

    Sezione findById(Integer id);
    Sezione findByNumerosezioneAndTipoelezioneId(Integer numeroSezione, Integer tipoElezioneId);
    List<Sezione> findAllBy();
}
