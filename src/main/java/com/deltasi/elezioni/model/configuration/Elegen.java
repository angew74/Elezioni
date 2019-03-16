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
import javax.validation.constraints.Size;

/**
 *
 * @author AdminDSI
 */
@Entity
@Table(name = "elegen")
public class Elegen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idelegen")  
    private Integer id;
    
    
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
  @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
  private TipoElezione  tipoelezione;
  
  
   @Column(name = "numerosezioni")
   @NotNull  
   private Integer numerosezioni;
   
   @Column(name = "numeroliste")
   @NotNull  
   private Integer numeroliste;
   
   @Column(name = "annoelezione")
   @NotNull  
   private Integer annoelezione;
   
   @Column(name = "giornocostituzione")
   @NotNull  
   @Size(max = 1, min = 2)
   private String  giornocostituzione;
   
   @Column(name = "giornovotazione1")
   @NotNull  
   @Size(max = 1, min = 2)
   private String  giornovotazione1;
   
   @Column(name = "giornovotazione2")  
   @Size(max = 1, min = 2)
   private String  giornovotazione2;
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elegen)) {
            return false;
        }
        Elegen other = (Elegen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.deltasi.model.configuration.Elegen[ id=" + id + " ]";
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
     * @return the numeroliste
     */
    public Integer getNumeroliste() {
        return numeroliste;
    }

    /**
     * @param numeroliste the numeroliste to set
     */
    public void setNumeroliste(Integer numeroliste) {
        this.numeroliste = numeroliste;
    }

    /**
     * @return the annoelezione
     */
    public Integer getAnnoelezione() {
        return annoelezione;
    }

    /**
     * @param annoelezione the annoelezione to set
     */
    public void setAnnoelezione(Integer annoelezione) {
        this.annoelezione = annoelezione;
    }

    /**
     * @return the giornocostituzione
     */
    public String getGiornocostituzione() {
        return giornocostituzione;
    }

    /**
     * @param giornocostituzione the giornocostituzione to set
     */
    public void setGiornocostituzione(String giornocostituzione) {
        this.giornocostituzione = giornocostituzione;
    }

    /**
     * @return the giornovotazione1
     */
    public String getGiornovotazione1() {
        return giornovotazione1;
    }

    /**
     * @param giornovotazione1 the giornovotazione1 to set
     */
    public void setGiornovotazione1(String giornovotazione1) {
        this.giornovotazione1 = giornovotazione1;
    }

    /**
     * @return the giornovotazione2
     */
    public String getGiornovotazione2() {
        return giornovotazione2;
    }

    /**
     * @param giornovotazione2 the giornovotazione2 to set
     */
    public void setGiornovotazione2(String giornovotazione2) {
        this.giornovotazione2 = giornovotazione2;
    }
    
}
