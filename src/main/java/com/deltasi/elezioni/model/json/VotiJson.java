package com.deltasi.elezioni.model.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VotiJson {

    public VotiJson()
    {
        this.liste = new ArrayList<>();
    }

    public VotiJson(List<ListaJson> l)
    {
        this.liste =l;
    }

    public void addLista(ListaJson json) {
        this.liste.add(json);
    }

    private Integer id;
    private Integer numerosezione;
    private Integer votanti;
    private Integer iscritti;
    private boolean validated;
    private List<ListaJson> liste;
    private Map<String, String> errorMessages;
    private String tipo;

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

    public Integer getVotanti() {
        return votanti;
    }

    public void setVotanti(Integer votantitotali) {
        this.votanti = votantitotali;
    }

    public Integer getIscritti() {
        return iscritti;
    }

    public void setIscritti(Integer iscritti) {
        this.iscritti = iscritti;
    }

    public List<ListaJson> getListe() {
        return liste;
    }

    public void setListe(List<ListaJson> liste) {
        this.liste = liste;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
