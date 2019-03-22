package com.deltasi.elezioni.model.authentication;


import com.deltasi.elezioni.model.configuration.TipoElezione;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class UserExtended {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "sesso")
    @Size(max = 1, min = 1, message = "{utente.sesso.invalido}")
    private String sesso;


    @Column(name = "cognome")
    @Size(max = 200, min = 3, message = "{utente.cognome.invalido}")
    private String cognome;


    @Column(name = "nome")
    @Size(max = 200, min = 3, message = "{utente.nome.invalido}")
    private String nome;


    @Column(name = "codicefiscale")
    @Size(max = 16, min = 16, message = "{utente.codicefiscale.invalido}")
    private String codicefiscale;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", referencedColumnName = "user_id")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
