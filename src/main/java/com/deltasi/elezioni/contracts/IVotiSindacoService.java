package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloSindaco;
import com.deltasi.elezioni.model.risultati.VotiSindaco;

import java.util.List;

public interface IVotiSindacoService {


    void SaveAll(List<VotiSindaco> list);
    VotiSindaco findById(Integer id);
    List<VotiSindaco> findAllBy();
    List<VotiSindaco> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiSindaco> findBySindacoIdAndTipoelezioneId(Integer sindacoid, Integer tipoElezioneId);
    List<VotiSindaco> findBySindacoProgressivoAndTipoelezioneId(Integer progressivo,Integer tipoElezioneId);
    VotiSindaco findBySindacoIdAndSezioneNumerosezioneAndTipoelezioneId(Integer sindacoid,Integer numerosezione, Integer tipoElezioneId);
    VotiSindaco findBySindacoProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione, Integer tipoElezioneId);
    VotiSindaco findBySindacoNomeAndSindacoCognomeAndSezioneNumerosezioneAndTipoelezioneId(String nome, String cognome, Integer numerosezione, Integer tipoElezioneId);
    List<RicalcoloSindaco> countSindacoByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloSindaco> countPervenuteByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloSindaco> countPervenute(int tipoelezioneid);
    List<RicalcoloSindaco> countSindaco(int tipoelezioneid);
    List<RicalcoloSindaco> countSindacoSingle(int tipoelezioneid, int idlista);
    List<RicalcoloSindaco> countSindacoSingleMunicipio(int tipoelezioneid, int idlista);
    List<RicalcoloSindaco> countVotantiPervenute(int tipoelezioneid);
    List<RicalcoloSindaco> countVotantiPervenuteByMunicipio(int tipoelezioneid,int municipio);
    List<VotiSindaco> findBySezionePlessoIdAndTipoelezioneId(int plessoid,int tipoelezioneid);

}
