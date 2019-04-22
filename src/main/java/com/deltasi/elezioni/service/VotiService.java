package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IVotiService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.repository.VotiDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class VotiService implements IVotiService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private VotiDAO votiDAO;


    @Override
    public Voti findById(Integer id) {
        return votiDAO.findById(id);
    }

    @Override
    public void SaveAll(List<Voti> list)
    {
        votiDAO.saveAll(list);
    }
    @Override
    public List<Voti> findAllBy() {
        return votiDAO.findAllBy();
    }

    @Override
    public List<Voti> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return votiDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione,tipoelezioneid);
    }

    @Override
    public List<Voti> findByListaIdAndTipoelezioneId(Integer listaid,Integer tipoElezioneId) {
        return votiDAO.findByListaIdAndTipoelezioneId(listaid,tipoElezioneId);
    }

    @Override
    public List<Voti> findByListaProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoElezioneId) {
        return votiDAO.findByListaProgressivoAndTipoelezioneId(progressivo, tipoElezioneId);
    }

    @Override
    public Voti findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid, Integer numerosezione, Integer tipoElezioneId) {
        return votiDAO.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(listaid,numerosezione,tipoElezioneId);
    }

    @Override
    public Voti findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo, Integer numerosezione, Integer tipoElezioneId) {
        return votiDAO.findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(progressivo,numerosezione,tipoElezioneId);
    }

    @Override
    public Voti findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione, Integer numerosezione, Integer tipoElezioneId) {
        return votiDAO.findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(denominazione,numerosezione,tipoElezioneId);
    }


    @Override
    public List<RicalcoloVoti> countListaByMunicipio(int tipoelezioneid, int municipio) {
        List<RicalcoloVoti> l= votiDAO.sumListaByMunicipio(tipoelezioneid, municipio);
        return  l;
      //  return  null;
    }

    @Override
    public List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid,int municipio) {
        List<RicalcoloVoti> l = votiDAO.countPervenuteByMunicipio(tipoelezioneid, municipio);
        return l;
    }

    @Override
    public List<RicalcoloVoti> countPervenute(int tipoelezioneid) {
        return votiDAO.countPervenute(tipoelezioneid);
       // return  null;
    }

    @Override
    public List<RicalcoloVoti> countLista(int tipoelezioneid) {
        return votiDAO.sumLista(tipoelezioneid);
       // return null;
    }

    @Override
    public List<RicalcoloVoti> countListaSingle(int tipoelezioneid, int idlista) {
       return votiDAO.sumListaByLista(tipoelezioneid,idlista);
        //return  null;
    }

    @Override
    public List<RicalcoloVoti> countListaSingleMunicipio(int tipoelezioneid, int idlista) {
       return votiDAO.sumListaMunicipioByLista(tipoelezioneid,idlista);

    }

    @Override
    public  List<RicalcoloVoti> countVotantiPervenute(int tipoelezioneid)
    {
        return  votiDAO.countVotantiPervenute(tipoelezioneid);
    }
    @Override
    public  List<RicalcoloVoti> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio)
    {
        List<RicalcoloVoti> l=  votiDAO.countVotantiPervenuteByMunicipio(tipoelezioneid,municipio);
        return  l;
    }
}
