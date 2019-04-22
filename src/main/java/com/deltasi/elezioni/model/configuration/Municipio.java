package com.deltasi.elezioni.model.configuration;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "municipi")
public class Municipio {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "municipio")
    @NotNull
    private Integer municipio;

    @Column(name = "descrizione")
    @NotNull
    private String  descrizione;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
