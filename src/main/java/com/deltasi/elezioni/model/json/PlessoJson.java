package com.deltasi.elezioni.model.json;

import com.deltasi.elezioni.model.configuration.Sezione;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class PlessoJson {

    @JsonProperty("plesso")
    private Integer plesso;

    @JsonProperty("descrizione")
    private String descrizione;
    @JsonProperty("ubicazione")
    private String ubicazione;
    @JsonProperty("numero")
    private Integer numero;
    @JsonProperty("utente")
    private String utente;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("sezione")
    private Integer sezione;
    @JsonProperty("cabina")
    private Integer cabina;
    @JsonProperty("municipio")
    private Integer municipio;

    public PlessoJson(Integer numeronew, String descrizionenew) {
        descrizione = descrizionenew;
        numero=numeronew;
    }

    public PlessoJson() {

    }


    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPlesso() {
        return plesso;
    }

    public void setPlesso(Integer plesso) {
        this.plesso = plesso;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUbicazione() {
        return ubicazione;
    }

    public void setUbicazione(String ubicazione) {
        this.ubicazione = ubicazione;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    public Integer getMunicipio() {
        return municipio;
    }


    public Integer getSezione() {
        return sezione;
    }

    public void setSezione(Integer sezione) {
        this.sezione = sezione;
    }

    public Integer getCabina() {
        return cabina;
    }

    public void setCabina(Integer cabina) {
        this.cabina = cabina;
    }
}
