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
    public Affluenza findBySezioneNumerosezioneAndTipoelezioneId(Integer sezione, Integer tipoElezioneId) {
        return affluenzaDAO.findBySezioneNumerosezioneAndTipoelezioneId(sezione,tipoElezioneId);
    }

    @Override
    public Affluenza findById(Integer id) {
      return  affluenzaDAO.findById(id);
    }

    @Override
    public List<Affluenza> findByPlessoMunicipio(Integer municipio) {
        return  affluenzaDAO.findByPlessoMunicipio(municipio);
    }

    @Override
    public Affluenza findBySezioneId(Integer sezioneid) {
        return  affluenzaDAO.findBySezioneId(sezioneid);
    }

    @Override
    public List<Affluenza> findByPlessoId(Integer idplesso) {
        return  affluenzaDAO.findByPlessoId(idplesso);
    }

    @Override
    public List<Affluenza> findByPlesso(Plesso plesso) {
        return  affluenzaDAO.findByPlesso(plesso);
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
    public List<Affluenza> findByApertura1(int a, int idTipoElezione) {
        return  affluenzaDAO.findByApertura1AndTipoelezioneId(a, idTipoElezione);
    }

    @Override
    public List<Affluenza> findByApertura2(int a, int idTipoElezione) {
        return  affluenzaDAO.findByApertura2AndTipoelezioneId(a, idTipoElezione);
    }

    @Override
    public List<Affluenza> findByApertura3(int a, int idTipoElezione) {
        return  affluenzaDAO.findByApertura3AndTipoelezioneId(a,idTipoElezione);
    }

    @Override
    public List<Affluenza> findByCostituzione1(int c,int idTipoElezione) {
        return  affluenzaDAO.findByCostituzione1AndTipoelezioneId(c, idTipoElezione);
    }

    @Override
    public List<Affluenza> findByCostituzione2(int c,int idTipoElezione) {
        return  affluenzaDAO.findByCostituzione2AndTipoelezioneId(c,idTipoElezione);
    }

    @Override
    public List<Affluenza> findByAffluenza1(int a,int idTipoElezione) {
        return  affluenzaDAO.findByAffluenza1AndTipoelezioneId(a,idTipoElezione);
    }

    @Override
    public List<Affluenza> findByAffluenza2(int a,int idTipoElezione) {
        return  affluenzaDAO.findByAffluenza2AndTipoelezioneId(a,idTipoElezione);
    }

    @Override
    public List<Affluenza> findByAffluenza3(int a, int idTipoElezione) {
        return  affluenzaDAO.findByAffluenza3AndTipoelezioneId(a,idTipoElezione);
    }

    @Override
    public List<Affluenza> findByAffluenza4(int a,int idTipoElezione) {
        return  affluenzaDAO.findByAffluenza4AndTipoelezioneId(a,idTipoElezione);
    }

    @Override
    public List<Affluenza> findByAffluenza5(int a, int idTipoElezione) {
        return  affluenzaDAO.findByAffluenza5AndTipoelezioneId(a,idTipoElezione);
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
