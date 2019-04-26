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
    List<Preferenze> findByCandidatoIdAndTipoelezioneId(int id, int tipoElezioneId);
    List<Preferenze> findByCandidatoIdAndTipoelezioneIdAndSezioneId(int id, int tipoElezioneId, int sezioneId);
    List<Preferenze> findByCandidatoIdAndTipoelezioneIdAndSezioneMunicipio(int id, int tipoElezioneId, int municipio);


    @Modifying
    @Query("select new RicalcoloPreferenze(count(distinct idsezione) as numeroPervenute, s.municipio as municipio) from Preferenze v " +
            " inner join Sezione s on v.sezione.id=s.id" +
            " where v.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            "group by s.municipio order by  s.municipio asc ")
    List<RicalcoloPreferenze> countPervenuteByMunicipio(int tipoelezioneid, int municipio);

    @Modifying
    @Query("select new RicalcoloPreferenze(count(distinct idsezione) as numeroPervenute) from Preferenze v " +
            " where v.tipoelezione.id=?1 ")
    List<RicalcoloPreferenze> countPervenute(int tipoelezioneid);


    @Modifying
    @Query("select new RicalcoloPreferenze(sum(p.numerovoti) as numeroVoti, p.candidato.id as idcandidato, p.candidato.nome as Nome, " +
            " p.candidato.cognome as Cognome, p.candidato.sesso as Sesso, l.id as idlista, l.denominazione as denominazione) " +
            " from Candidato c " +
            " inner join Lista l on c.lista.id=l.id" +
            " inner join Preferenze p on l.id=p.lista.id" +
            " and l.tipoelezione.id=p.tipoelezione.id "+
            " where p.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            "group by p.candidato.id,p.candidato.nome, p.candidato.cognome,p.candidato.sesso, l.id, l.denominazione")
    List<RicalcoloPreferenze> sumCandidato(int tipoelezioneid);


    @Modifying
    @Query("select new RicalcoloPreferenze(sum(p.numerovoti) as numeroVoti, c.id as idcandidato, c.nome as Nome, " +
            " c.cognome as Cognome, c.sesso as Sesso, l.id as idlista, l.denominazione as denominazione, s.municipio as Municipio) " +
            " from Candidato c " +
            " inner join Lista l on c.lista.id=l.id" +
            " inner join Preferenze p on l.id=p.lista.id" +
            " and l.tipoelezione.id=p.tipoelezione.id "+
            " inner join Sezione s on p.sezione.id=s.id" +
            " where p.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            " group by p.candidato.id,p.candidato.nome, p.candidato.cognome,p.candidato.sesso, l.id, l.denominazione, s.municipio")
    List<RicalcoloPreferenze> sumCandidatoByMunicipio(int tipoelezioneid, int municipio);


    @Modifying
    @Query("select new RicalcoloPreferenze(sum(p.numerovoti) as numeroVoti, p.candidato.id as idcandidato, p.candidato.nome as Nome, " +
            " p.candidato.cognome as Cognome, p.candidato.sesso as Sesso, l.id as idlista, l.denominazione as denominazione) " +
            " from Candidato c " +
            " inner join Lista l on c.lista.id=l.id" +
            " inner join Preferenze p on l.id=p.lista.id" +
            " and l.tipoelezione.id=p.tipoelezione.id "+
            " where p.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and l.id=?2" +
            " group by p.candidato.id,p.candidato.nome, p.candidato.cognome,p.candidato.sesso, l.id, l.denominazione")
    List<RicalcoloPreferenze> sumCandidatoByLista(int tipoelezioneid, int idlista);

    @Modifying
    @Query("select new RicalcoloPreferenze(sum(p.numerovoti) as numeroVoti, p.candidato.id as idcandidato, p.candidato.nome as Nome, " +
            " p.candidato.cognome as Cognome, p.candidato.sesso as Sesso, l.id as idlista, l.denominazione as denominazione, s.municipio as Municipio) " +
            " from Candidato c  " +
            " inner join Lista l on c.lista.id=l.id " +
            " inner join Preferenze p on l.id=p.lista.id" +
            " and l.tipoelezione.id=p.tipoelezione.id "+
            " inner join Sezione s on p.sezione.id=s.id" +
            " where p.tipoelezione.id=?1 " +
            " and l.tipoelezione.id=?1 " +
            " and s.municipio=?2 " +
            " and l.id=?3" +
            " group by p.candidato.id,p.candidato.nome, p.candidato.cognome,p.candidato.sesso, l.id, l.denominazione, s.municipio")
    List<RicalcoloPreferenze> sumCandidatoByListaMunicipio(int tipoelezioneid, int municipio, int idlista);


    @Modifying
    @Query("select new RicalcoloVoti(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute) from Affluenza f " +
            " inner join Preferenze v on f.sezione.id=v.sezione.id" +
            " and v.tipoelezione.id=f.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " and f.tipoelezione.id=?1 " )
    List<RicalcoloPreferenze> countVotantiPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new RicalcoloVoti(sum(f.votantitotali3) as numeroVoti, sum(i.iscrittitotaligen) as iscrittipervenute, s.municipio as Municipio) " +
            " from Affluenza f " +
            " inner join Preferenze v on f.sezione.id=v.sezione.id" +
            " and v.tipoelezione.id=f.tipoelezione.id "+
            " inner join Sezione s on v.sezione.id=s.id" +
            " and v.tipoelezione.id=s.tipoelezione.id "+
            " inner join Iscritti i on s.id=i.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " and f.tipoelezione.id=?1 "+
            " and s.municipio=?2" +
            " group by  s.municipio order by  s.municipio asc ")
    List<RicalcoloPreferenze> countVotantiPervenuteByMunicipio(int tipoelezioneid, int municipio);

}
