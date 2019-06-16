package com.deltasi.elezioni.model.json;

import java.util.Map;

public class SindacoJson {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String cognome;
    private Integer voti;
    private Integer progressivo;
    private Integer numerosezione;
    private Integer idsindaco;
    private boolean validated;
    private String tipo;
    private Map<String, String> errorMessages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getVoti() {
        return voti;
    }

    public void setVoti(Integer voti) {
        this.voti = voti;
    }

    public Integer getProgressivo() {
        return progressivo;
    }

    public void setProgressivo(Integer progressivo) {
        this.progressivo = progressivo;
    }

    public Integer getNumerosezione() {
        return numerosezione;
    }

    public void setNumerosezione(Integer numerosezione) {
        this.numerosezione = numerosezione;
    }

    public Integer getIdsindaco() {
        return idsindaco;
    }

    public void setIdsindaco(Integer idsindaco) {
        this.idsindaco = idsindaco;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
