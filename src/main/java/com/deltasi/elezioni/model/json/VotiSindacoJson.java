package com.deltasi.elezioni.model.json;

import java.util.List;
import java.util.Map;

public class VotiSindacoJson {

    private Integer id;
    private Integer numerosezione;
    private Integer votanti;
    private Integer iscritti;
    private Integer contestate;
    private Integer bianche;
    private Integer nulle;
    private Integer solosindaco;
    private Integer totale;
    private Integer totalevalide;
    private Integer valideliste;
    private String  nomeSindacoVoti;
    private String  cognomeSindacoVoti;
    private boolean validated;
    private List<SindacoJson> sindaci;
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

    public void setVotanti(Integer votanti) {
        this.votanti = votanti;
    }

    public Integer getIscritti() {
        return iscritti;
    }

    public void setIscritti(Integer iscritti) {
        this.iscritti = iscritti;
    }

    public String getNomeSindacoVoti() {
        return nomeSindacoVoti;
    }

    public void setNomeSindacoVoti(String nomeSindacoVoti) {
        this.nomeSindacoVoti = nomeSindacoVoti;
    }

    public String getCognomeSindacoVoti() {
        return cognomeSindacoVoti;
    }

    public void setCognomeSindacoVoti(String cognomeSindacoVoti) {
        this.cognomeSindacoVoti = cognomeSindacoVoti;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public List<SindacoJson> getSindaci() {
        return sindaci;
    }

    public void setSindaci(List<SindacoJson> sindaci) {
        this.sindaci = sindaci;
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

    public Integer getContestate() {
        return contestate;
    }

    public void setContestate(Integer contestate) {
        this.contestate = contestate;
    }

    public Integer getBianche() {
        return bianche;
    }

    public void setBianche(Integer bianche) {
        this.bianche = bianche;
    }

    public Integer getNulle() {
        return nulle;
    }

    public void setNulle(Integer nulle) {
        this.nulle = nulle;
    }

    public Integer getSolosindaco() {
        return solosindaco;
    }

    public void setSolosindaco(Integer solosindaco) {
        this.solosindaco = solosindaco;
    }

    public Integer getTotale() {
        return totale;
    }

    public void setTotale(Integer totale) {
        this.totale = totale;
    }

    public Integer getTotalevalide() {
        return totalevalide;
    }

    public void setTotalevalide(Integer totalevalide) {
        this.totalevalide = totalevalide;
    }

    public Integer getValideliste() {
        return valideliste;
    }

    public void setValideliste(Integer valideliste) {
        this.valideliste = valideliste;
    }
}
