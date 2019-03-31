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
}
