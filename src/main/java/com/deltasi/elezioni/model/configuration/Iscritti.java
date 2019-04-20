/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.model.configuration;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author AdminDSI
 */
@Entity
@Table(name = "iscritti")
public class Iscritti implements Serializable {

    public Iscritti() {

    }

    public Iscritti(int iscrittiMaschi, int iscrittiFemmine, int iscrittiTotali, int Municipio) {
        this.iscrittifemmine = iscrittiFemmine;
        this.iscrittimaschi = iscrittiMaschi;
        this.iscrittitotali = iscrittiTotali;
        this.municipio = Municipio;
    }

    public Iscritti(Long iscrittiMaschi, Long iscrittiFemmine, Long iscrittiTotali) {
        this.iscrittifemmine =Integer.parseInt(iscrittiFemmine.toString());
        this.iscrittimaschi =Integer.parseInt(iscrittiMaschi.toString());
        this.iscrittitotali =Integer.parseInt(iscrittiTotali.toString());
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idsezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Sezione sezione;

    @Column(name = "municipio")
    private Integer municipio;

    @Column(name = "collegiocamera")
    private Integer collegiocamera;

    @Column(name = "collegiosenato")
    private Integer collegiosenato;

    @Column(name = "collegioprovinciale")
    private Integer collegioprovinciale;

    @Column(name = "iscrittimaschi")
    private Integer iscrittimaschi;

    @Column(name = "iscrittitotali")
    private Integer iscrittitotali;

    @Column(name = "iscrittimaschiue")
    private Integer iscrittimaschiue;

    @Column(name = "iscrittimaschigen")
    private Integer iscrittimaschigen;

    @Column(name = "iscrittifemmineue")
    private Integer iscrittifemmineue;

    @Column(name = "iscrittifemminegen")
    private Integer iscrittifemminegen;

    @Column(name = "iscrittitotaligen")
    private Integer iscrittitotaligen;

    @Column(name = "iscrittitotaliue")
    private Integer iscrittitotaliue;

    @Column(name = "iscrittifemmine")
    private Integer iscrittifemmine;

    @Column(name = "cabina")
    private Integer cabina;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtiposezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private TipoSezione tiposezione;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iscritti)) {
            return false;
        }
        Iscritti other = (Iscritti) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.deltasi.model.configuration.Iscritti[ id=" + getId() + " ]";
    }


    /**
     * @return the municipio
     */
    public Integer getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the collegiocamera
     */
    public Integer getCollegiocamera() {
        return collegiocamera;
    }

    /**
     * @param collegiocamera the collegiocamera to set
     */
    public void setCollegiocamera(Integer collegiocamera) {
        this.collegiocamera = collegiocamera;
    }

    /**
     * @return the collegiosenato
     */
    public Integer getCollegiosenato() {
        return collegiosenato;
    }

    /**
     * @param collegiosenato the collegiosenato to set
     */
    public void setCollegiosenato(Integer collegiosenato) {
        this.collegiosenato = collegiosenato;
    }

    /**
     * @return the collegioprovinciale
     */
    public Integer getCollegioprovinciale() {
        return collegioprovinciale;
    }

    /**
     * @param collegioprovinciale the collegioprovinciale to set
     */
    public void setCollegioprovinciale(Integer collegioprovinciale) {
        this.collegioprovinciale = collegioprovinciale;
    }

    /**
     * @return the iscrittimaschi
     */
    public Integer getIscrittimaschi() {
        return iscrittimaschi;
    }

    /**
     * @param iscrittimaschi the iscrittimaschi to set
     */
    public void setIscrittimaschi(Integer iscrittimaschi) {
        this.iscrittimaschi = iscrittimaschi;
    }

    /**
     * @return the iscrittitotali
     */
    public Integer getIscrittitotali() {
        return iscrittitotali;
    }

    /**
     * @param iscrittitotali the iscrittitotali to set
     */
    public void setIscrittitotali(Integer iscrittitotali) {
        this.iscrittitotali = iscrittitotali;
    }

    /**
     * @return the iscrittimaschiue
     */
    public Integer getIscrittimaschiue() {
        return iscrittimaschiue;
    }

    /**
     * @param iscrittimaschiue the iscrittimaschiue to set
     */
    public void setIscrittimaschiue(Integer iscrittimaschiue) {
        this.iscrittimaschiue = iscrittimaschiue;
    }

    /**
     * @return the iscrittimaschigen
     */
    public Integer getIscrittimaschigen() {
        return iscrittimaschigen;
    }

    /**
     * @param iscrittimaschigen the iscrittimaschigen to set
     */
    public void setIscrittimaschigen(Integer iscrittimaschigen) {
        this.iscrittimaschigen = iscrittimaschigen;
    }

    /**
     * @return the iscrittifemmineue
     */
    public Integer getIscrittifemmineue() {
        return iscrittifemmineue;
    }

    /**
     * @param iscrittifemmineue the iscrittifemmineue to set
     */
    public void setIscrittifemmineue(Integer iscrittifemmineue) {
        this.iscrittifemmineue = iscrittifemmineue;
    }

    /**
     * @return the iscrittifemminegen
     */
    public Integer getIscrittifemminegen() {
        return iscrittifemminegen;
    }

    /**
     * @param iscrittifemminegen the iscrittifemminegen to set
     */
    public void setIscrittifemminegen(Integer iscrittifemminegen) {
        this.iscrittifemminegen = iscrittifemminegen;
    }

    /**
     * @return the iscrittitotaligen
     */
    public Integer getIscrittitotaligen() {
        return iscrittitotaligen;
    }

    /**
     * @param iscrittitotaligen the iscrittitotaligen to set
     */
    public void setIscrittitotaligen(Integer iscrittitotaligen) {
        this.iscrittitotaligen = iscrittitotaligen;
    }

    /**
     * @return the iscrittitotaliue
     */
    public Integer getIscrittitotaliue() {
        return iscrittitotaliue;
    }

    /**
     * @param iscrittitotaliue the iscrittitotaliue to set
     */
    public void setIscrittitotaliue(Integer iscrittitotaliue) {
        this.iscrittitotaliue = iscrittitotaliue;
    }

    /**
     * @return the iscrittifemmine
     */
    public Integer getIscrittifemmine() {
        return iscrittifemmine;
    }

    /**
     * @param iscrittifemmine the iscrittifemmine to set
     */
    public void setIscrittifemmine(Integer iscrittifemmine) {
        this.iscrittifemmine = iscrittifemmine;
    }

    /**
     * @return the cabina
     */
    public Integer getCabina() {
        return cabina;
    }

    /**
     * @param cabina the cabina to set
     */
    public void setCabina(Integer cabina) {
        this.cabina = cabina;
    }

    /**
     * @return the tipoelezione
     */
    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    /**
     * @param tipoelezione the tipoelezione to set
     */
    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    /**
     * @return the tiposezione
     */
    public TipoSezione getTiposezione() {
        return tiposezione;
    }

    /**
     * @param tiposezione the tiposezione to set
     */
    public void setTiposezione(TipoSezione tiposezione) {
        this.tiposezione = tiposezione;
    }

    public Sezione getSezione() {
        return sezione;
    }

    public void setSezione(Sezione sezione) {
        this.sezione = sezione;
    }
}
