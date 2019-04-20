/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.deltasi.elezioni.model.risultati.Affluenza;

/**
 *
 * @author AdminDSI
 */
@Repository
public interface IscrittiDAO extends JpaRepository<Iscritti, Integer> {
    Iscritti findById(long id);
    List<Iscritti> findByMunicipio(Integer mun);
    Iscritti findBySezioneId(Integer idsezione);
    Iscritti findByTipoelezioneIdAndSezioneNumerosezione(Integer tipoElezioneId,Integer numerosezione);
    void deleteById(Integer id);
    List<Iscritti> findByTipoelezioneId(Integer idtipoelezione);
    List<Iscritti> findByTipoelezione(TipoElezione tipoElezione);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza3=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza3(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza3=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza3(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllApertura1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllApertura2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (a.iscrittimaschi as iscrittimaschi, a.iscrittifemmine as iscrittifemmine, a.iscrittitotali as iscrittitotali, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschi) as iscrittimaschi, sum(a.iscrittifemmine) as iscrittifemmine, sum(a.iscrittitotali) as iscrittitotali) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione2(int tipoelezioneid);


}
