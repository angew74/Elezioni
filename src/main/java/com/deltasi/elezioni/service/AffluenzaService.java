package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IAffluenzaService;
import com.deltasi.elezioni.model.configuration.Plesso;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloAffluenza;
import com.deltasi.elezioni.model.ricalcoli.RicalcoloCostApertura;
import com.deltasi.elezioni.model.risultati.Affluenza;
import com.deltasi.elezioni.repository.AffluenzaDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AffluenzaService implements IAffluenzaService {

    private static final Logger logger = LogManager.getLogger(ElegenService.class);

    @Autowired
    private AffluenzaDAO affluenzaDAO;



    @Override
    public void add(Affluenza affluenza) {
        affluenzaDAO.saveAndFlush(affluenza);
    }

    @Override
    public void update(Affluenza affluenza) {
        affluenzaDAO.save(affluenza);
    }

    @Override
    public void delete(Long id) {
        affluenzaDAO.deleteById(id);
    }

    @Override
    public Affluenza findById(Integer id) {
      return  affluenzaDAO.findById(id);
    }


    @Override
    public List<Affluenza> findByTipoelezione(TipoElezione tipoElezione) {
        return  affluenzaDAO.findByTipoelezione(tipoElezione);
    }

    @Override
    public List<Affluenza> findByTipoelezioneId(Integer idTipoElezione) {
        return  affluenzaDAO.findByTipoelezioneId(idTipoElezione);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndTipoelezioneId(Integer sezione,Integer tipoElezioneId)
    {
        return affluenzaDAO.findBySezioneNumerosezioneAndTipoelezioneId(sezione,tipoElezioneId);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza1(Integer sezione, Integer tipoElezioneId, Integer a) {
        return  affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza1(sezione,tipoElezioneId,a);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza2(Integer sezione, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza2(sezione,tipoElezioneId,a);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(Integer sezione, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza3(sezione,tipoElezioneId,a);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza4(Integer sezione, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza4(sezione,tipoElezioneId,a);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza5(Integer sezione, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndAffluenza5(sezione,tipoElezioneId,a);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndApertura1(Integer sezione, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndApertura1(sezione,tipoElezioneId,a);
    }

    @Override
    public Affluenza findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndCostituzione1(Integer sezione, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezioneNumerosezioneAndSezioneTipoelezioneIdAndCostituzione1(sezione,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndAffluenza1(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza1(plessoid,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndAffluenza2(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza2(plessoid,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndAffluenza3(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza3(plessoid,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndAffluenza4(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza4(plessoid,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndAffluenza5(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndAffluenza5(plessoid,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndCostituzione1(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndCostituzione1(plessoid,tipoElezioneId,a);
    }

    @Override
    public List<Affluenza> findBySezionePlessoIdAndTipoelezioneIdAndApertura1(Integer plessoid, Integer tipoElezioneId, Integer a) {
        return affluenzaDAO.findBySezionePlessoIdAndTipoelezioneIdAndApertura1(plessoid,tipoElezioneId,a);
    }


    @Override
    public List<Affluenza> findByAffluenza1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByAffluenza1AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByAffluenza2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByAffluenza2AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByAffluenza3AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByAffluenza3AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByCostituzione1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByCostituzione1AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByCostituzione2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByCostituzione2AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByApertura1AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByApertura1AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByApertura2AndTipoelezioneIdAndSezione_Numerosezione(int a, int idTipoElezione, int numeroSezione) {
        return affluenzaDAO.findByApertura2AndTipoelezioneIdAndSezione_Numerosezione(a,idTipoElezione,numeroSezione);
    }

    @Override
    public List<Affluenza> findByAffluenza1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByAffluenza1AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }

    @Override
    public List<Affluenza> findByAffluenza2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByAffluenza2AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }

    @Override
    public List<Affluenza> findByAffluenza3AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByAffluenza3AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }

    @Override
    public List<Affluenza> findByCostituzione1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByCostituzione1AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }

    @Override
    public List<Affluenza> findByCostituzione2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByCostituzione2AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }

    @Override
    public List<Affluenza> findByApertura1AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByApertura1AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }

    @Override
    public List<Affluenza> findByApertura2AndTipoelezioneIdAndSezione_Municipio(int a, int idTipoElezione, int municipio) {
        return affluenzaDAO.findByApertura2AndTipoelezioneIdAndSezione_Municipio(a,idTipoElezione,municipio);
    }


    @Override
    public List<Integer> countByAffluenza1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByAffluenza1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByAffluenza2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByAffluenza2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione, tipoElezione1);
    }

    @Override
        public List<Integer> countByAffluenza3AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByAffluenza3AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByApertura1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByApertura1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByApertura2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByApertura2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione,  tipoElezione1) ;
    }

    @Override
    public List<Integer> countByCostituzione1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByCostituzione1AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByCostituzione2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(int a, int municipio, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByCostituzione2AndSezione_MunicipioAndTipoelezioneIdAndTipoelezioneIdIn(a, municipio, tipoElezione,  tipoElezione1);
    }

    @Override
    public List<Long> countByAffluenza1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByAffluenza1AndTipoelezioneIdAndTipoelezioneIdIn(a, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Long> countByAffluenza2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByAffluenza2AndTipoelezioneIdAndTipoelezioneIdIn(a, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Long> countByAffluenza3AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByAffluenza3AndTipoelezioneIdAndTipoelezioneIdIn(a, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByApertura1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByApertura1AndTipoelezioneIdAndTipoelezioneIdIn(a, tipoElezione,  tipoElezione1);
    }

    @Override
    public List<Integer> countByApertura2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByApertura2AndTipoelezioneIdAndTipoelezioneIdIn(a, tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByCostituzione1AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByCostituzione1AndTipoelezioneIdAndTipoelezioneIdIn( a,  tipoElezione, tipoElezione1);
    }

    @Override
    public List<Integer> countByCostituzione2AndTipoelezioneIdAndTipoelezioneIdIn(int a, int tipoElezione, int tipoElezione1) {
        return affluenzaDAO.countByCostituzione2AndTipoelezioneIdAndTipoelezioneIdIn(a, tipoElezione, tipoElezione1);
    }

    @Override
    public List<RicalcoloAffluenza> countAffluenza1(int tipoelezioneid)
    {
        return affluenzaDAO.countAffluenza1(tipoelezioneid);
    }
    @Override
    public List<RicalcoloAffluenza> countAffluenza1ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countAffluenza1ByMunicipio(tipoelezioneid);
    }
    @Override
    public List<RicalcoloAffluenza> countAffluenza2(int tipoelezioneid)
    {
        return affluenzaDAO.countAffluenza2(tipoelezioneid);
    }
    @Override
    public List<RicalcoloAffluenza> countAffluenza2ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countAffluenza2ByMunicipio(tipoelezioneid);
    }
    @Override
    public List<RicalcoloAffluenza> countAffluenza3(int tipoelezioneid)
    {
        return affluenzaDAO.countAffluenza3(tipoelezioneid);
    }
    @Override
    public List<RicalcoloAffluenza> countAffluenza3ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countAffluenza3ByMunicipio(tipoelezioneid);
    }

    @Override
    public List<RicalcoloCostApertura> countApertura1(int tipoelezioneid)
    {
        return affluenzaDAO.countApertura1(tipoelezioneid);
    }
    @Override
    public List<RicalcoloCostApertura> countApertura1ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countApertura1ByMunicipio(tipoelezioneid);
    }
    @Override
    public List<RicalcoloCostApertura> countApertura2(int tipoelezioneid)
    {
        return affluenzaDAO.countApertura2(tipoelezioneid);
    }
    @Override
    public List<RicalcoloCostApertura> countApertura2ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countApertura2ByMunicipio(tipoelezioneid);
    }

    @Override
    public List<RicalcoloCostApertura> countCostituzione1(int tipoelezioneid)
    {
        return affluenzaDAO.countCostituzione1(tipoelezioneid);
    }
    @Override
    public List<RicalcoloCostApertura> countCostituzione1ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countCostituzione1ByMunicipio(tipoelezioneid);
    }
    @Override
    public List<RicalcoloCostApertura> countCostituzione2(int tipoelezioneid)
    {
        return affluenzaDAO.countCostituzione2(tipoelezioneid);
    }
    @Override
    public List<RicalcoloCostApertura> countCostituzione2ByMunicipio(int tipoelezioneid)
    {
        return  affluenzaDAO.countCostituzione2ByMunicipio(tipoelezioneid);
    }

}
