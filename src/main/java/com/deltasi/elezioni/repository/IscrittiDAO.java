/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.repository;


import com.deltasi.elezioni.model.configuration.Iscritti;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import java.util.List;

import com.deltasi.elezioni.model.risultati.Lista;
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
    List<Iscritti> findByMunicipioAndTipoelezioneId(Integer mun, int TipoElezioneId);
    List<Long> countAllByTipoelezioneIdAndMunicipio(int mun, int TipoElezioneId);
    List<Long> countAllByTipoelezioneId(int TipoElezioneId);
    Iscritti findBySezioneIdAndTipoelezioneId(Integer idsezione,int TipoElezioneId);
    Iscritti findByTipoelezioneIdAndSezioneNumerosezione(Integer tipoElezioneId,Integer numerosezione);
    void deleteById(Integer id);
    List<Iscritti> findByTipoelezioneId(Integer idtipoelezione);
    List<Iscritti> findByTipoelezione(TipoElezione tipoElezione);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            "a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            " a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza3=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioAffluenza3(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.affluenza3=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllAffluenza3(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            " a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllApertura1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            " a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioApertura2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.apertura2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllApertura2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            "  a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione1=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione1(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen, " +
            " a.municipio as municipio) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1" +
            " group by a.municipio")
    List<Iscritti> countIscrittiSezioniPervenuteMunicipioCostituzione2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti (sum(a.iscrittimaschigen) as iscrittimaschigen, sum(a.iscrittifemminegen) as iscrittifemminegen, sum(a.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti a inner join Affluenza s on a.id=s.iscritti.id" +
            " where s.costituzione2=1 and a.tipoelezione.id=?1 " +
            " and s.tipoelezione.id=?1")
    List<Iscritti> countIscrittiSezioniPervenuteAllCostituzione2(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti " +
            "(sum(i.iscrittimaschigen) as iscrittimaschigen, sum(i.iscrittifemminegen) as iscrittifemminegen, sum(i.iscrittitotaligen) as iscrittitotaligen) " +
            " from Iscritti i inner join Sezione s on s.id= i.sezione.id " +
            " inner join Voti v on s.id=v.sezione.id" +
            " where v.tipoelezione.id=?1 ")
    List<Iscritti> countIscrittiPervenute(int tipoelezioneid);

    @Modifying
    @Query("select new Iscritti " +
            " (sum(i.iscrittimaschigen) as iscrittimaschigen, sum(i.iscrittifemminegen) as iscrittifemminegen, sum(i.iscrittitotaligen) as iscrittitotaligen, i.municipio as municipio) " +
            " from Iscritti i inner join Sezione s on i.sezione.id=s.id " +
            " inner join Voti v on s.id=v.sezione.id " +
            " where v.tipoelezione.id=?1 " +
            " group by i.municipio")
    List<Iscritti> countIscrittiPervenuteByMun(int tipoelezioneid);


}
