package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.Voti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VotiDAO extends JpaRepository<Voti, Long> {

    Voti findById(Integer id);
    List<Voti> findAllBy();
    List<Voti> findBySezioneNumerosezioneAndSezioneTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Voti> findByListaId(Integer listaid);
    List<Voti> findByListaProgressivo(Integer progressivo);
    Voti findByListaIdAndSezioneNumerosezione(Integer listaid,Integer numerosezione);
    Voti findByListaProgressivoAndSezioneNumerosezione(Integer progressivo,Integer numerosezione);
    Voti findByListaDenominazioneAndSezioneNumerosezione(String denominazione,Integer numerosezione);
    List<Voti> findByListaDenominazione(String denominazione);
    @Modifying
    @Query("select new RicalcoloVoti(sum(voti) as numerovoti, v.lista,  s.municipio as municipio) from Voti v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            "group by s.municipio,v.lista")
    List<RicalcoloVoti> countListaByMunicipio(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct(idsezione)), s.municipio as municipio) from Voti v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            "group by s.municipio")
    List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct(idsezione))) from Voti v " +
            " where v.tipoelezione.id=?1 ")
    List<RicalcoloVoti> countPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(voti) as numerovoti, v.lista) from Voti v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            "group by v.lista")
    List<RicalcoloVoti> countLista(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(voti) as numerovoti, v.lista) from Voti v " +
            " inner join Lista l on v.lista.id=l.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by v.lista")
    List<RicalcoloVoti> countListaSingle(int tipoelezioneid, int idlista);

    @Modifying
    @Query("select new RicalcoloVoti(sum(voti) as numerovoti, v.lista,s.municipio as municipio) from Voti v " +
            " inner join Lista l on v.lista.id=l.id" +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by v.lista,s.municipio")
    List<RicalcoloVoti> countListaSingleByMunicipio(int tipoelezioneid, int idlista);


}

