package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloVotiLista;
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
    List<RicalcoloVotiLista> countListaByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloVotiLista> countPervenuteByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloVotiLista> countPervenute(int tipoelezioneid);
    List<RicalcoloVotiLista> countLista(int tipoelezioneid);
    List<RicalcoloVotiLista> countListaSingle(int tipoelezioneid, int idlista);
    List<RicalcoloVotiLista> countListaSingleMunicipio(int tipoelezioneid, int idlista);
    List<RicalcoloVotiLista> countVotantiPervenute(int tipoelezioneid);
    List<RicalcoloVotiLista> countVotantiPervenuteByMunicipio(int tipoelezioneid,int municipio);
    List<VotiLista> findBySezionePlessoIdAndTipoelezioneId(int plessoid,int tipoelezioneid);
    List<VotiLista> findBySezioneNumerosezioneAndTipoelezioneIdAndListaCoalizioneId(int numerosezione,int tipoelezioneid,int coalizioneid);

}
