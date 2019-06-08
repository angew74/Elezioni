package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJson
{

    public UserJson() {

    }

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("username")
    private String username;

    private  String nome;
    private  String password;
    private  String sesso;
    private  String cognome;
    private String nomecognome;
    private String mailaziendale;
    private String codiceficale;

    public UserJson(Integer idnew, String usernamenew) {
        setId(idnew);
        setUsername(usernamenew);
    }

    public UserJson(Integer idnew, String usernamenew, String nomenew, String cognomenew) {
        setId(idnew);
        setUsername(usernamenew);
        setNome(nomenew);
        setCognome(cognomenew);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNomecognome()
    {
        return  nome + " " + cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodiceficale() {
        return codiceficale;
    }

    public void setCodiceficale(String codiceficale) {
        this.codiceficale = codiceficale;
    }

    public String getMailaziendale() {
        return mailaziendale;
    }

    public void setMailaziendale(String mailaziendale) {
        this.mailaziendale = mailaziendale;
    }
}
