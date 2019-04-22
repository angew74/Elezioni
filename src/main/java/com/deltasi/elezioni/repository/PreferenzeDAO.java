package com.deltasi.elezioni.repository;

import com.deltasi.elezioni.model.ricalcoli.RicalcoloPreferenze;
import com.deltasi.elezioni.model.risultati.Preferenze;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreferenzeDAO extends JpaRepository<Preferenze, Long> {
    Preferenze findById(Integer id);
    List<Preferenze> findAllBy();
    List<Preferenze> findBySezioneNumerosezioneAndTipoelezioneId(Integer numerosezione, Integer tipoelezioneid);
    List<Preferenze> findByListaIdAndTipoelezioneId(Integer listaid,int tipoElezioneId);
    List<Preferenze> findByListaProgressivoAndTipoelezioneId(Integer progressivo,int tipoElezioneId);
    List<Preferenze> findByListaIdAndSezioneNumerosezioneAndTipoelezioneId(Integer listaid,Integer numerosezione,int tipoElezioneId);
    List<Preferenze> findByListaProgressivoAndSezioneNumerosezioneAndTipoelezioneId(Integer progressivo,Integer numerosezione,int tipoElezioneId);
    List<Preferenze> findByListaDenominazioneAndSezioneNumerosezioneAndTipoelezioneId(String denominazione,Integer numerosezione,int tipoElezioneId);
    List<Preferenze> findByListaDenominazioneAndTipoelezioneId(String denominazione,int tipoElezioneId);

    List<RicalcoloPreferenze> countListaByMunicipio(int tipoelezioneid, int municipio);

    @Modifying
    @Query("select new RicalcoloVoti(count(distinct idsezione) as numeroPervenute, s.municipio as municipio) from Preferenze v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            "group by s.municipio order by  s.municipio asc ")
    List<RicalcoloPreferenze> countPervenuteByMunicipio(int tipoelezioneid, int municipio);
    @Modifying
    @Query("select new RicalcoloVoti(count(distinct idsezione) as numeroPervenute) from Preferenze v " +
            " where v.tipoelezione.id=?1 ")
    List<RicalcoloPreferenze> countPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti,  l.id as idlista, l.denominazione as denominazione) from Lista l " +
            " inner join Voti v on l.id=v.lista.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            "group by l.id, l.denominazione")
    List<RicalcoloPreferenze> countCandidato(int tipoelezioneid);
    List<RicalcoloPreferenze> countListaSingle(int tipoelezioneid, int idlista);
    List<RicalcoloPreferenze> countListaSingleMunicipio(int tipoelezioneid, int idlista);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute) from Candidato l " +
            " inner join Preferenze v on l.id=v.candidato.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " )
    List<RicalcoloPreferenze> countVotantiPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(v.numerovoti) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute, s.municipio as Municipio) from Candidato l " +
            " inner join Preferenze v on l.id=v.candidato.id" +
            " and l.tipoelezione.id=v.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 "+
            " and s.municipio=?2" +
            " group by  s.municipio order by  s.municipio asc ")
    List<RicalcoloPreferenze> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio);
}
