package com.deltasi.elezioni.model.configuration;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "sezioni")
public class Sezione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numerosezione")
    private Integer numerosezione;

    @Column(name = "municipio")
    private Integer municipio;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtipoelezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione  tipoelezione;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idtiposezione", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoSezione  tiposezione;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idplesso", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Plesso  plesso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumerosezione() {
        return numerosezione;
    }

    public void setNumerosezione(Integer numerosezione) {
        this.numerosezione = numerosezione;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    public TipoSezione getTiposezione() {
        return tiposezione;
    }

    public void setTiposezione(TipoSezione tiposezione) {
        this.tiposezione = tiposezione;
    }

    public Plesso getPlesso() {
        return plesso;
    }

    public void setPlesso(Plesso plesso) {
        this.plesso = plesso;
    }
}
