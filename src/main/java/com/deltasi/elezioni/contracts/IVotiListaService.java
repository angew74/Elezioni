package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.VotiLista;

import java.util.HashSet;
import java.util.List;

public interface IVotiListaService {

    void SaveAll(HashSet<VotiLista> list);
    VotiLista findById(Integer id);
    List<VotiLista> findAllBy();
    List<VotiLista> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiLista> findByListaIdAndTipoelezioneId(Integer listaid, Integer tipoElezioneId);
    List<VotiLista> findByListaProgressivoAndTipoelezioneId(Integer progressivo,Integer tipoElezioneId);
    VotiLista findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid,Integer numerosezione, Integer tipoElezioneId);
    VotiLista findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione, Integer tipoElezioneId);
    VotiLista findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione,Integer numerosezione, Integer tipoElezioneId);
    List<RicalcoloVoti> countListaByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloVoti> countPervenute(int tipoelezioneid);
    List<RicalcoloVoti> countLista(int tipoelezioneid);
    List<RicalcoloVoti> countListaSingle(int tipoelezioneid, int idlista);
    List<RicalcoloVoti> countListaSingleMunicipio(int tipoelezioneid, int idlista);
    List<RicalcoloVoti> countVotantiPervenute(int tipoelezioneid);
    List<RicalcoloVoti> countVotantiPervenuteByMunicipio(int tipoelezioneid,int municipio);
    List<VotiLista> findBySezionePlessoIdAndTipoelezioneId(int plessoid,int tipoelezioneid);

}
