package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.VotiLista;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.configuration.Sezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Repository
public interface VotiListaDAO extends JpaRepository<VotiLista, Long> {

    VotiLista findById(Integer id);
    List<VotiLista> findAllBy();
    List<VotiLista> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiLista> findBySezionePlessoIdAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiLista> findByListaIdAndTipoelezioneId(Integer listaid, Integer tipoElezioneId);
    List<VotiLista> findByListaProgressivoAndTipoelezioneId(Integer progressivo,Integer tipoElezioneId);
    VotiLista findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid,Integer numerosezione, Integer tipoElezioneId);
    VotiLista findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione, Integer tipoElezioneId);
    VotiLista findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione,Integer numerosezione, Integer tipoElezioneId);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct idsezione) as numeroPervenute, s.municipio as municipio) from VotiLista v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            "group by s.municipio order by  s.municipio asc ")
    List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid, Integer municipio);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct idsezione) as numeroPervenute) from VotiLista v " +
            " where v.tipoelezione.id=?1 ")
    List<RicalcoloVoti> countPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute) from Affluenza f " +
            " inner join Sezione s on f.sezione.id=s.id" +
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where s.tipoelezione.id=?1 " +
            " and f.sezione.id in (select sezione.id from VotiLista v where numerovoti is not null) " +
            " and f.tipoelezione.id=?1 " )
    List<RicalcoloVoti> countVotantiPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute, s.municipio as Municipio) " +
            " from Affluenza f " +
             " inner join Sezione s on f.sezione.id=s.id" +
            " and f.tipoelezione.id=s.tipoelezione.id "+
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where s.tipoelezione.id=?1 " +
            " and f.tipoelezione.id=?1 "+
            " and f.sezione.id in (select sezione.id from VotiLista v where numerovoti is not null) " +
            " and s.municipio=?2" +
            " group by  s.municipio order by  s.municipio asc ")
    List<RicalcoloVoti> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio);


    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti,  l.id as idlista, l.denominazione as denominazione) from Lista l " +
            " inner join VotiLista v on l.id=v.lista.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            "group by l.id, l.denominazione")
    List<RicalcoloVoti> sumLista(Integer tipoelezioneid);


    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti,  l.id as idlista, l.denominazione as denominazione, s.municipio as municipio) from Lista l " +
            " inner join VotiLista v on l.id=v.lista.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            " group by l.id, l.denominazione, s.municipio order by s.municipio asc ")
    List<RicalcoloVoti> sumListaByMunicipio(Integer tipoelezioneid, int municipio);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti, l.id as idlista, l.denominazione as denominazione) from Lista l " +
            " inner join VotiLista v on v.lista.id=l.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by l.id, l.denominazione ")
    List<RicalcoloVoti> sumListaByLista(Integer tipoelezioneid, Integer idlista);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti, l.id as idlista, l.denominazione as denominazione, s.municipio as municipio) from Lista l " +
            " inner join VotiLista v on v.lista.id=l.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by l.id, l.denominazione, s.municipio")
    List<RicalcoloVoti> sumListaMunicipioByLista(Integer tipoelezioneid, Integer idlista);


}

