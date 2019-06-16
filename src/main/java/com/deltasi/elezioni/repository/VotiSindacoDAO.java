package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloSindaco;
import com.deltasi.elezioni.model.risultati.Sindaco;
import com.deltasi.elezioni.model.risultati.VotiSindaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotiSindacoDAO extends JpaRepository<VotiSindaco, Long> {
    VotiSindaco findById(Integer id);
    List<VotiSindaco> findAllBy();
    List<VotiSindaco> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiSindaco> findBySezionePlessoIdAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<VotiSindaco> findBySindacoIdAndTipoelezioneId(Integer sindacoid, Integer tipoElezioneId);
    List<VotiSindaco> findBySindacoProgressivoAndTipoelezioneId(Integer progressivo,Integer tipoElezioneId);
    VotiSindaco findBySindacoIdAndSezioneNumerosezioneAndTipoelezioneId(Integer sindacoid, Integer numerosezione, Integer tipoElezioneId);
    VotiSindaco findBySindacoProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione, Integer tipoElezioneId);
    VotiSindaco findBySindacoNomeAndSindacoCognomeAndSezioneNumerosezioneAndTipoelezioneId(String nome,String cognome, Integer numerosezione, Integer tipoElezioneId);

    @Modifying
    @Query("select new RicalcoloSindaco(count(distinct idsezione) as numeroPervenute, s.municipio as municipio) from VotiSindaco v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            "group by s.municipio order by  s.municipio asc ")
    List<RicalcoloSindaco> countPervenuteByMunicipio(int tipoelezioneid, Integer municipio);

    @Modifying
    @Query("select new RicalcoloSindaco(count(distinct idsezione) as numeroPervenute) from VotiSindaco v " +
            " where v.tipoelezione.id=?1 ")
    List<RicalcoloSindaco> countPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloSindaco(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute) from Affluenza f " +
            " inner join Sezione s on f.sezione.id=s.id" +
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where s.tipoelezione.id=?1 " +
            " and f.sezione.id in (select sezione.id from VotiSindaco v where numerovoti is not null) " +
            " and f.tipoelezione.id=?1 " )
    List<RicalcoloSindaco> countVotantiPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloSindaco(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute, s.municipio as Municipio) " +
            " from Affluenza f " +
            " inner join Sezione s on f.sezione.id=s.id" +
            " and f.tipoelezione.id=s.tipoelezione.id "+
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where s.tipoelezione.id=?1 " +
            " and f.tipoelezione.id=?1 "+
            " and f.sezione.id in (select sezione.id from VotiSindaco v where numerovoti is not null) " +
            " and s.municipio=?2" +
            " group by  s.municipio order by  s.municipio asc ")
    List<RicalcoloSindaco> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio);


    @Modifying
    @Query("select new RicalcoloSindaco(sum(v.numerovoti) as numeroVoti,  l.id as idlista, l.nome as nome, l.cognome as cognome) from Sindaco l " +
            " inner join VotiSindaco v on l.id=v.sindaco.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            "group by l.id, l.nome,l.cognome")
    List<RicalcoloSindaco> sumSindaco(Integer tipoelezioneid);


    @Modifying
    @Query("select new RicalcoloSindaco(sum(v.numerovoti) as numeroVoti,  l.id as idsindaco, l.nome as nome, l.cognome as cognome, s.municipio as municipio) from Sindaco l " +
            " inner join VotiSindaco v on l.id=v.sindaco.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            " group by l.id, l.nome, l.cognome, s.municipio order by s.municipio asc ")
    List<RicalcoloSindaco> sumSindacoByMunicipio(Integer tipoelezioneid, int municipio);

    @Modifying
    @Query("select new RicalcoloSindaco(sum(v.numerovoti) as numeroVoti, l.id as idsindaco, l.nome as nome, l.cognome as cognome) from Sindaco l " +
            " inner join VotiSindaco v on v.sindaco.id=l.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by l.id, l.nome, l.cognome ")
    List<RicalcoloSindaco> sumSindacoBySindaco(Integer tipoelezioneid, Integer idsindaco);

    @Modifying
    @Query("select new RicalcoloSindaco(sum(v.numerovoti) as numeroVoti, l.id as idsindaco, l.nome as nome, l.cognome as cognome, s.municipio as municipio) from Sindaco l " +
            " inner join VotiSindaco v on v.sindaco.id=l.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            "group by l.id, l.nome,l.cognome, s.municipio")
    List<RicalcoloSindaco> sumSindacoMunicipioBySindaco(Integer tipoelezioneid, Integer idsindaco);

}
