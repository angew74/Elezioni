package com.deltasi.elezioni.model.risultati;

import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "voti_sindaco")
public class VotiSindaco implements Serializable  {


    private static final long serialVersionUID = 1L;


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotiSindaco)) {
            return false;
        }
        VotiSindaco other = (VotiSindaco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.deltasi.elezioni.model.risultati.VotiSindaco[ id=" + id + " ]";
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sezione sezione;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoelezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sindacoid", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Sindaco sindaco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "votigeneraliid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private VotiGenerali votiGenerali;



    @Column(name = "municipio")
    private int municipio;


    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Column(name = "utente_operazione")
    private String  utenteoperazione;

    @Column(name = "numero_voti")
    private Integer numerovoti;

    @Column(name ="numero_voti_solo_sindaco")
    private Integer numerovotisolosindaco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sezione getSezione() {
        return sezione;
    }

    public void setSezione(Sezione sezione) {
        this.sezione = sezione;
    }

    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    public Sindaco getSindaco() {
        return sindaco;
    }

    public void setSindaco(Sindaco sindaco) {
        this.sindaco = sindaco;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public LocalDateTime getDataoperazione() {
        return dataoperazione;
    }

    public void setDataoperazione(LocalDateTime dataoperazione) {
        this.dataoperazione = dataoperazione;
    }

    public String getUtenteoperazione() {
        return utenteoperazione;
    }

    public void setUtenteoperazione(String utenteoperazione) {
        this.utenteoperazione = utenteoperazione;
    }

    public Integer getNumerovoti() {
        return numerovoti;
    }

    public void setNumerovoti(Integer numerovoti) {
        this.numerovoti = numerovoti;
    }

    public Integer getNumerovotisolosindaco() {
        return numerovotisolosindaco;
    }

    public void setNumerovotisolosindaco(Integer numerovotisolosindaco) {
        this.numerovotisolosindaco = numerovotisolosindaco;
    }

    public VotiGenerali getVotiGenerali() {
        return votiGenerali;
    }

    public void setVotiGenerali(VotiGenerali votiGenerali) {
        this.votiGenerali = votiGenerali;
    }
}
