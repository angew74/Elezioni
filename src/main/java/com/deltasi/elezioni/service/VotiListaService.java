package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IVotiListaService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.VotiLista;
import com.deltasi.elezioni.repository.VotiListaDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class VotiListaService implements IVotiListaService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private VotiListaDAO votiListaDAO;


    @Override
    public VotiLista findById(Integer id) {
        return votiListaDAO.findById(id);
    }

    @Override
    public void SaveAll(List<VotiLista> list)
    {
        votiListaDAO.saveAll(list);
    }
    @Override
    public List<VotiLista> findAllBy() {
        return votiListaDAO.findAllBy();
    }

    @Override
    public List<VotiLista> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return votiListaDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione,tipoelezioneid);
    }

    @Override
    public List<VotiLista> findByListaIdAndTipoelezioneId(Integer listaid,Integer tipoElezioneId) {
        return votiListaDAO.findByListaIdAndTipoelezioneId(listaid,tipoElezioneId);
    }

    @Override
    public List<VotiLista> findByListaProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoElezioneId) {
        return votiListaDAO.findByListaProgressivoAndTipoelezioneId(progressivo, tipoElezioneId);
    }

    @Override
    public VotiLista findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid, Integer numerosezione, Integer tipoElezioneId) {
        return votiListaDAO.findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(listaid,numerosezione,tipoElezioneId);
    }

    @Override
    public VotiLista findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo, Integer numerosezione, Integer tipoElezioneId) {
        return votiListaDAO.findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(progressivo,numerosezione,tipoElezioneId);
    }

    @Override
    public VotiLista findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione, Integer numerosezione, Integer tipoElezioneId) {
        return votiListaDAO.findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(denominazione,numerosezione,tipoElezioneId);
    }


    @Override
    public List<RicalcoloVoti> countListaByMunicipio(int tipoelezioneid, int municipio) {
        List<RicalcoloVoti> l= votiListaDAO.sumListaByMunicipio(tipoelezioneid, municipio);
        return  l;
      //  return  null;
    }

    @Override
    public List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid,int municipio) {
        List<RicalcoloVoti> l = votiListaDAO.countPervenuteByMunicipio(tipoelezioneid, municipio);
        return l;
    }

    @Override
    public List<RicalcoloVoti> countPervenute(int tipoelezioneid) {
        return votiListaDAO.countPervenute(tipoelezioneid);
       // return  null;
    }

    @Override
    public List<RicalcoloVoti> countLista(int tipoelezioneid) {
        return votiListaDAO.sumLista(tipoelezioneid);
       // return null;
    }

    @Override
    public List<RicalcoloVoti> countListaSingle(int tipoelezioneid, int idlista) {
       return votiListaDAO.sumListaByLista(tipoelezioneid,idlista);
        //return  null;
    }

    @Override
    public List<RicalcoloVoti> countListaSingleMunicipio(int tipoelezioneid, int idlista) {
       return votiListaDAO.sumListaMunicipioByLista(tipoelezioneid,idlista);

    }

    @Override
    public  List<RicalcoloVoti> countVotantiPervenute(int tipoelezioneid)
    {
        return  votiListaDAO.countVotantiPervenute(tipoelezioneid);
    }
    @Override
    public  List<RicalcoloVoti> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio)
    {
        List<RicalcoloVoti> l=  votiListaDAO.countVotantiPervenuteByMunicipio(tipoelezioneid,municipio);
        return  l;
    }

    @Override
    public List<VotiLista> findBySezionePlessoIdAndTipoelezioneId(int plessoid, int tipoelezioneid) {
        return votiListaDAO.findBySezionePlessoIdAndTipoelezioneId(plessoid,tipoelezioneid);
    }
}
