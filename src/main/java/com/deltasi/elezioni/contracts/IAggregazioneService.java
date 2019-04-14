package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.configuration.Aggregazione;

import java.util.List;

public interface IAggregazioneService {

    Aggregazione findById(Integer id);
    void deleteById(Integer id);
    List<Aggregazione> FindAll();
}
