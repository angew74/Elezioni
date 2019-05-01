package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.AggregazioneInterrogazione;

import java.util.List;

public interface IAggregazioneInterrogazioneService {
    AggregazioneInterrogazione findById(Integer id);
    void deleteById(Integer id);
    List<AggregazioneInterrogazione> findAllByTipoelezioneId(int tipoElezioneId);
}
