package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IAbilitazioniService;
import com.deltasi.elezioni.model.configuration.FaseElezione;
import com.deltasi.elezioni.repository.AbilitazioneDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AbilitazioniService implements IAbilitazioniService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private AbilitazioneDAO faseElezioneDAO;

    @Override
    public FaseElezione findFaseElezioneById(Integer id) {
      return  faseElezioneDAO.findById(id);
    }

    @Override
    public FaseElezione findFaseElezioneByCodice(String codice) {
      return  faseElezioneDAO.findByCodice(codice);
    }




    @Override
    public List<FaseElezione> getAll() {
        return  faseElezioneDAO.findAllBy();
    }


    @Override
    public  void Save(FaseElezione fase)
    {
        faseElezioneDAO.save(fase);
    }

    @Override
    public FaseElezione findByCodiceAndTipoelezioneId(String codice, Integer tipoElezioneId)
    {
        return  faseElezioneDAO.findByCodiceAndTipoelezioneId(codice,tipoElezioneId);
    }

    @Override
    public Page<FaseElezione> findAllByTipoelezioneId(Pageable pageable, int tipoelezioneid) {
        return faseElezioneDAO.findAllByTipoelezioneId(pageable,tipoelezioneid);
    }

    @Override
    public Page<FaseElezione> findByAbilitataAndTipoelezioneId(Pageable pageable,Integer abil, int tipoelezioneid) {
        return faseElezioneDAO.findByAbilitataAndTipoelezioneId(pageable,abil,tipoelezioneid);
    }

    @Override
    public List<FaseElezione> findByAbilitataAndTipoelezioneId(int abilitata, int tipoelezioneid) {
        return faseElezioneDAO.findByAbilitataAndTipoelezioneId(abilitata,tipoelezioneid);
    }
}
