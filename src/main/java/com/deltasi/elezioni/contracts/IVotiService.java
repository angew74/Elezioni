package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.Voti;


import java.util.List;

public interface IVotiService {

    void SaveAll(List<Voti> list);
    void Save(Voti voti);
    Voti findById(Integer id);
    List<Voti> findAllBy();
    Voti findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Voti> findBySezionePlessoIdAndTipoelezioneId(int plessoid, int tipoelezioneid);
}
