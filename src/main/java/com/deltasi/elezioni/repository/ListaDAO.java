package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.risultati.Sindaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaDAO extends JpaRepository<Lista, Long> {

    Lista findById(Integer id);
    List<Lista> findAllBy();
    Lista findByDenominazioneAndTipoelezioneId(String denominazione, Integer tipoelezioneid);
    Lista findByProgressivoAndTipoelezioneId(Integer progressivo, Integer tipoelezioneid);
    List<Lista> findAllByTipoelezioneId(int tipoElezione);
    List<Lista> findByCoalizioneIdAndTipoelezioneId(int idcoalizione, int tipoelezioneid);
    List<Lista> findByCoalizioneDenominazioneAndTipoelezioneId(String denominazione, int tipoelezioneid);
    List<Lista> findByCoalizioneSindacoIdAndTipoelezioneId(int sindacoid, int tipoelezioneid);
    List<Lista> findBySindacoIdAndTipoelezioneId(int sindacoid, int tipoelezioneid);
    List<Lista> findBySindacoNomeAndSindacoCognomeAndTipoelezioneId(String nome, String cognome, int tipoelezioneid);
    List<Lista> findBySindacoId(int sindacoid);




}
