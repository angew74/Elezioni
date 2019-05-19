package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class PlessoJson {

    @JsonProperty("sezione")
    private Integer plesso;

    @JsonProperty("descrizione")
    private String descrizione;
    @JsonProperty("ubicazione")
    private String ubicazione;
    @JsonProperty("utente")
    private String utente;
    @JsonProperty("tipo")
    private String tipo;



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
}
