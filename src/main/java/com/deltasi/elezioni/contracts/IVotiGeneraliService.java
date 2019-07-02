package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.risultati.VotiGenerali;

import java.util.List;

public interface IVotiGeneraliService {

    void SaveAll(List<VotiGenerali> list);
    void Save(VotiGenerali voti);
    VotiGenerali findById(Integer id);
    List<VotiGenerali> findAllBy();
    VotiGenerali findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiGenerali> findBySezionePlessoIdAndTipoelezioneId(int plessoid,int tipoelezioneid);
}
