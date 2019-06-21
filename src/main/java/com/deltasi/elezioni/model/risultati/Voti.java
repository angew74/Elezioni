package com.deltasi.elezioni.model.risultati;

import com.deltasi.elezioni.model.configuration.Sezione;
import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voti")
public class Voti {

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

    @Column(name = "data_operazione")
    private LocalDateTime dataoperazione;

    @Column(name = "utente_operazione")
    private String  utenteoperazione;

    @Column(name = "totale")
    private Integer totale;

    @Column(name = "solo_sindaco")
    private Integer solosindaco;;

    @Column(name = "totale_valide")
    private Integer totalevalida;

    @Column(name = "nulle")
    private Integer nulle;

    @Column(name = "bianche")
    private Integer bianche;

    @Column(name = "contestate")
    private Integer contestate;


    @Column(name = "municipio")
    private Integer municipio;

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

    public Integer getTotale() {
        return totale;
    }

    public void setTotale(Integer totale) {
        this.totale = totale;
    }

    public Integer getSolosindaco() {
        return solosindaco;
    }

    public void setSolosindaco(Integer solosindaco) {
        this.solosindaco = solosindaco;
    }

    public Integer getTotalevalida() {
        return totalevalida;
    }

    public void setTotalevalida(Integer totalevalida) {
        this.totalevalida = totalevalida;
    }

    public Integer getNulle() {
        return nulle;
    }

    public void setNulle(Integer nulle) {
        this.nulle = nulle;
    }

    public Integer getBianche() {
        return bianche;
    }

    public void setBianche(Integer bianche) {
        this.bianche = bianche;
    }

    public Integer getContestate() {
        return contestate;
    }

    public void setContestate(Integer contestate) {
        this.contestate = contestate;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }
}
