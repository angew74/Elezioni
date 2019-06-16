package com.deltasi.elezioni.service;



import com.deltasi.elezioni.contracts.IVotiSindacoService;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloSindaco;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.model.risultati.VotiSindaco;
import com.deltasi.elezioni.repository.VotiSindacoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VotiSindacoService implements IVotiSindacoService {


    @Autowired
    private VotiSindacoDAO votiSindacoDAO;

    @Override
    public void SaveAll(List<VotiSindaco> list) {
        votiSindacoDAO.saveAll(list);
    }

    @Override
    public VotiSindaco findById(Integer id) {
        return votiSindacoDAO.findById(id);
    }

    @Override
    public List<VotiSindaco> findAllBy() {
        return votiSindacoDAO.findAllBy();
    }

    @Override
    public List<VotiSindaco> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid) {
        return votiSindacoDAO.findBySezioneNumerosezioneAndTipoelezioneId(numerosezione,tipoelezioneid);
    }

    @Override
    public List<VotiSindaco> findBySindacoIdAndTipoelezioneId(Integer sindacoid, Integer tipoElezioneId) {
        return votiSindacoDAO.findBySindacoIdAndTipoelezioneId(sindacoid,tipoElezioneId);
    }

    @Override
    public List<VotiSindaco> findBySindacoProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoElezioneId) {
        return votiSindacoDAO.findBySindacoProgressivoAndTipoelezioneId(progressivo,tipoElezioneId);
    }

    @Override
    public VotiSindaco findBySindacoIdAndSezioneNumerosezioneAndTipoelezioneId(Integer sindacoid, Integer numerosezione, Integer tipoElezioneId) {
        return votiSindacoDAO.findBySindacoIdAndSezioneNumerosezioneAndTipoelezioneId(sindacoid,numerosezione,tipoElezioneId);
    }

    @Override
    public VotiSindaco findBySindacoProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo, Integer numerosezione, Integer tipoElezioneId) {
        return votiSindacoDAO.findBySindacoProgressivoAndSezioneNumerosezioneAndTipoelezioneId(progressivo,numerosezione,tipoElezioneId);
    }

    @Override
    public VotiSindaco findBySindacoNomeAndSindacoCognomeAndSezioneNumerosezioneAndTipoelezioneId(String nome, String cognome, Integer numerosezione, Integer tipoElezioneId) {
        return votiSindacoDAO.findBySindacoNomeAndSindacoCognomeAndSezioneNumerosezioneAndTipoelezioneId(nome,cognome,numerosezione,tipoElezioneId);
    }

    @Override
    public List<RicalcoloSindaco> countSindacoByMunicipio(int tipoelezioneid, int municipio) {
        return votiSindacoDAO.sumSindacoByMunicipio(tipoelezioneid,municipio);
    }

    @Override
    public List<RicalcoloSindaco> countPervenuteByMunicipio(int tipoelezioneid, int municipio) {
        return votiSindacoDAO.countPervenuteByMunicipio(tipoelezioneid,municipio);
    }

    @Override
    public List<RicalcoloSindaco> countPervenute(int tipoelezioneid) {
        return votiSindacoDAO.countPervenute(tipoelezioneid);
    }

    @Override
    public List<RicalcoloSindaco> countSindaco(int tipoelezioneid) {
        return votiSindacoDAO.sumSindaco(tipoelezioneid);
    }

    @Override
    public List<RicalcoloSindaco> countSindacoSingle(int tipoelezioneid, int idsindaco) {
        return votiSindacoDAO.sumSindacoBySindaco(tipoelezioneid,idsindaco);
    }

    @Override
    public List<RicalcoloSindaco> countSindacoSingleMunicipio(int tipoelezioneid, int idsindaco) {
        return votiSindacoDAO.sumSindacoMunicipioBySindaco(tipoelezioneid,idsindaco);
    }

    @Override
    public List<RicalcoloSindaco> countVotantiPervenute(int tipoelezioneid) {
        return votiSindacoDAO.countVotantiPervenute(tipoelezioneid);
    }

    @Override
    public List<RicalcoloSindaco> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio) {
        return votiSindacoDAO.countVotantiPervenuteByMunicipio(tipoelezioneid,municipio);
    }

    @Override
    public List<VotiSindaco> findBySezionePlessoIdAndTipoelezioneId(int plessoid, int tipoelezioneid) {
        return votiSindacoDAO.findBySezionePlessoIdAndTipoelezioneId(plessoid,tipoelezioneid);
    }
}
