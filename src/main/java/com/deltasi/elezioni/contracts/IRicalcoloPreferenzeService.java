package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;

import java.util.List;

public interface IRicalcoloPreferenzeService {
    List<RicalcoloPreferenze> findAllBy();
    void SaveAll(List<RicalcoloPreferenze> list);
    RicalcoloPreferenze findAllById(int id);
    List<RicalcoloPreferenze> findByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);
    RicalcoloPreferenze findFirstByTipoelezioneAndListaIdOrderByDataoperazioneDesc(int tipoElezioneId, int ListaId);


}
