package com.deltasi.elezioni.model.risultati;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "candidati")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoelezioneid", referencedColumnName = "id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private TipoElezione tipoelezione;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listaid", referencedColumnName = "id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Lista lista;

    @Column(name = "progressivo")
    private Integer progressivo;




    @Column(name = "nome_candidato")
    private String nome;

    @Column(name = "cognome_candidato")
    private String cognome;

    @Column(name = "sesso_candidato")
    private  String sesso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoElezione getTipoelezione() {
        return tipoelezione;
    }

    public void setTipoelezione(TipoElezione tipoelezione) {
        this.tipoelezione = tipoelezione;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Integer getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(Integer progressivo) {
        this.progressivo = progressivo;
    }


}
