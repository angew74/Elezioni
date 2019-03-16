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
 *
 * @author AdminDSI
 */
@Entity
public class Matrice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmatrice")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
  private TipoElezione  tipoelezione;

  
   @Column(name = "municipio")
   @NotNull  
   private Integer municipio;
   
   @Column(name = "collegiocamera")    
   private Integer collegiocamera;
   
   
    @Column(name = "collegiosenato")    
   private Integer collegiosenato;
    
   @Column(name = "collegioprovinciale")    
   private Integer collegioprovinciale;
   
   @Column(name = "numerosezioni")    
   private Integer numerosezioni;
   
   @Column(name = "iscrittimaschi")    
   private Integer iscrittimaschi;
   
   @Column(name = "iscrittifemmine")    
   private Integer iscrittifemmine;
   
   @Column(name = "iscrittitotali")    
   private Integer iscrittitotali;
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matrice)) {
            return false;
        }
        Matrice other = (Matrice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.deltasi.model.configuration.Matrice[ id=" + id + " ]";
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
     * @return the numerosezioni
     */
    public Integer getNumerosezioni() {
        return numerosezioni;
    }

    /**
     * @param numerosezioni the numerosezioni to set
     */
    public void setNumerosezioni(Integer numerosezioni) {
        this.numerosezioni = numerosezioni;
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
    
}
