package com.deltasi.elezioni.model.json;

public class CandidatoJson {

    private  String  cognome;
    private  String nome;
    private  String sesso;
    private String nomecognome;
    private  int idlista;
    private  String denominazionelista;
    private String tipo;
    private  int numerosezione;
    private int numerovoti;
    private int numerovotilista;
    private  int id;
    private int idcandidato;

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getIdlista() {
        return idlista;
    }

    public void setIdlista(int idlista) {
        this.idlista = idlista;
    }

    public String getDenominazionelista() {
        return denominazionelista;
    }

    public void setDenominazionelista(String denominazionelista) {
        this.denominazionelista = denominazionelista;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumerosezione() {
        return numerosezione;
    }

    public void setNumerosezione(int numerosezione) {
        this.numerosezione = numerosezione;
    }

    public int getNumerovoti() {
        return numerovoti;
    }

    public void setNumerovoti(int numerovoti) {
        this.numerovoti = numerovoti;
    }

    public int getNumerovotilista() {
        return numerovotilista;
    }

    public void setNumerovotilista(int numerovotilista) {
        this.numerovotilista = numerovotilista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecognome() {
        return nomecognome;
    }

    public void setNomecognome(String nomecognome) {
        this.nomecognome = nomecognome;
    }

    public int getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(int idcandidato) {
        this.idcandidato = idcandidato;
    }
}
