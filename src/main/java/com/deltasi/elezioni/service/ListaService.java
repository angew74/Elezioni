package com.deltasi.elezioni.service;

import com.deltasi.elezioni.contracts.IListaService;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.repository.ListaDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ListaService implements IListaService {

    private static final Logger logger = LogManager.getLogger(TipoElezioneService.class);

    @Autowired
    private ListaDAO listaDAO;

    @Override
    public Lista findById(Integer id) {
    return  listaDAO.findById(id);
    }

    @Override
    public List<Lista> findAllBy() {
       return  listaDAO.findAllBy();
    }

    @Override
    public Lista findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid) {
       return  listaDAO.findByDenominazioneAndTipoelezioneId(denominazione,tipoelezioneid);
    }

    @Override
    public Lista findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid) {
       return  listaDAO.findByProgressivoAndTipoelezioneId(progressivo,tipoelezioneid);
    }

    @Override
    public List<Lista> findAllByTipoelezioneId(int tipoElezione)
    {
        return listaDAO.findAllByTipoelezioneId(tipoElezione);
    }

    @Override
    public List<Lista> findByCoalizioneIdAndTipoelezioneId(int idcoalizione, int tipoelezioneid) {
        return listaDAO.findByCoalizioneIdAndTipoelezioneId(idcoalizione,tipoelezioneid);
    }

    @Override
    public List<Lista> findByCoalizioneDenominazioneAndTipoelezioneId(String denominazione, int tipoelezioneid) {
        return listaDAO.findByCoalizioneDenominazioneAndTipoelezioneId(denominazione,tipoelezioneid);
    }

    @Override
    public List<Lista> findByCoalizioneSindacoIdAndTipoelezioneId(int sindacoid, int tipoelezioneid) {
        return listaDAO.findByCoalizioneSindacoIdAndTipoelezioneId(sindacoid,tipoelezioneid);
    }

    @Override
    public List<Lista> findBySindacoIdAndTipoelezioneId(int sindacoid, int tipoelezioneid) {
        return listaDAO.findBySindacoIdAndTipoelezioneId(sindacoid,tipoelezioneid);
    }

    @Override
    public List<Lista> findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(String nome, String cognome, int tipoelezioneid) {
        return listaDAO.findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(nome,cognome,tipoelezioneid);
    }
}
