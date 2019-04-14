package com.deltasi.elezioni.model.configuration;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_ricalcolo_aggregazione")
public class Aggregazione {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descrizione")
    @NotNull
    private String descrizione;

    @Column(name = "codice")
    @NotNull
    private String codice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}
