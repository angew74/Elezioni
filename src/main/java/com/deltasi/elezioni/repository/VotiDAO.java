package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloVoti;
import com.deltasi.elezioni.model.risultati.Voti;
import com.deltasi.elezioni.model.risultati.Lista;
import com.deltasi.elezioni.model.configuration.Sezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface VotiDAO extends JpaRepository<Voti, Long> {

    Voti findById(Integer id);
    List<Voti> findAllBy();
    List<Voti> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Voti> findByListaIdAndTipoelezioneId(Integer listaid, Integer tipoElezioneId);
    List<Voti> findByListaProgressivoAndTipoelezioneId(Integer progressivo,Integer tipoElezioneId);
    Voti findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid,Integer numerosezione, Integer tipoElezioneId);
    Voti findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione, Integer tipoElezioneId);
    Voti findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione,Integer numerosezione, Integer tipoElezioneId);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct idsezione) as numeroPervenute, s.municipio as municipio) from Voti v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            "group by s.municipio order by  s.municipio asc ")
    List<RicalcoloVoti> countPervenuteByMunicipio(int tipoelezioneid, Integer municipio);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct idsezione) as numeroPervenute) from Voti v " +
            " where v.tipoelezione.id=?1 ")
    List<RicalcoloVoti> countPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute) from Affluenza f " +
            " inner join Voti v on f.sezione.id=v.sezione.id" +
            " and v.tipoelezione.id=f.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " and f.tipoelezione.id=?1 " )
    List<RicalcoloVoti> countVotantiPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute, s.municipio as Municipio) " +
            " from Affluenza f " +
            " inner join Voti v on f.sezione.id=v.sezione.id" +
            " and v.tipoelezione.id=f.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " and v.tipoelezione.id=s.tipoelezione.id "+
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " and f.tipoelezione.id=?1 "+
            " and s.municipio=?2" +
            " group by  s.municipio order by  s.municipio asc ")
    List<RicalcoloVoti> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio);


    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti,  l.id as idlista, l.denominazione as denominazione) from Lista l " +
            " inner join Voti v on l.id=v.lista.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            "group by l.id, l.denominazione")
    List<RicalcoloVoti> sumLista(Integer tipoelezioneid);


    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti,  l.id as idlista, l.denominazione as denominazione, s.municipio as municipio) from Lista l " +
            " inner join Voti v on l.id=v.lista.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            " group by l.id, l.denominazione, s.municipio order by s.municipio asc ")
    List<RicalcoloVoti> sumListaByMunicipio(Integer tipoelezioneid, int municipio);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti, l.id as idlista, l.denominazione as denominazione) from Lista l " +
            " inner join Voti v on v.lista.id=l.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by l.id, l.denominazione ")
    List<RicalcoloVoti> sumListaByLista(Integer tipoelezioneid, Integer idlista);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti, l.id as idlista, l.denominazione as denominazione, s.municipio as municipio) from Lista l " +
            " inner join Voti v on v.lista.id=l.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by l.id, l.denominazione, s.municipio")
    List<RicalcoloVoti> sumListaMunicipioByLista(Integer tipoelezioneid, Integer idlista);


}

