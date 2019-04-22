package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.Voti;

import java.util.List;

public interface IVotiService {

    void SaveAll(List<Voti> list);
    Voti findById(Integer id);
    List<Voti> findAllBy();
    List<Voti> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Voti> findByListaIdAndTipoelezioneId(Integer listaid, Integer tipoElezioneId);
    List<Voti> findByListaProgressivoAndTipoelezioneId(Integer progressivo,Integer tipoElezioneId);
    Voti findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid,Integer numerosezione, Integer tipoElezioneId);
    Voti findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione, Integer tipoElezioneId);
    Voti findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione,Integer numerosezione, Integer tipoElezioneId);
    List<RicalcoloVoti> countListaByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloVoti> countPervenute(int tipoelezioneid);
    List<RicalcoloVoti> countLista(int tipoelezioneid);
    List<RicalcoloVoti> countListaSingle(int tipoelezioneid, int idlista);
    List<RicalcoloVoti> countListaSingleMunicipio(int tipoelezioneid, int idlista);
    List<RicalcoloVoti> countVotantiPervenute(int tipoelezioneid);
    List<RicalcoloVoti> countVotantiPervenuteByMunicipio(int tipoelezioneid,int municipio);

}
