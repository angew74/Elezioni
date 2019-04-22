package com.deltasi.elezioni.contracts;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.risultati.Preferenze;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public interface IPreferenzeService {



    void SaveAll(List<Preferenze> list);
    Preferenze findById(Integer id);
    List<Preferenze> findAllBy();
    List<Preferenze> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Preferenze> findByListaIdAndTipoelezioneId(Integer listaid,int tipoElezioneId);
    List<Preferenze> findByListaProgressivoAndTipoelezioneId(Integer progressivo,int tipoElezioneId);
    List<Preferenze> findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid,Integer numerosezione,int tipoElezioneId);
    List<Preferenze> findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione,int tipoElezioneId);
    List<Preferenze> findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione,Integer numerosezione,int tipoElezioneId);
    List<Preferenze> findByListaDenominazioneAndTipoelezioneId(String denominazione,int tipoElezioneId);
    List<RicalcoloPreferenze> countListaByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloPreferenze> countPervenuteByMunicipio(int tipoelezioneid, int municipio);
    List<RicalcoloPreferenze> countPervenute(int tipoelezioneid);
    List<RicalcoloPreferenze> countLista(int tipoelezioneid);
    List<RicalcoloPreferenze> countListaSingle(int tipoelezioneid, int idlista);
    List<RicalcoloPreferenze> countListaSingleMunicipio(int tipoelezioneid, int idlista);
    List<RicalcoloPreferenze> countVotantiPervenute(int tipoelezioneid);
    List<RicalcoloPreferenze> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio);
}
