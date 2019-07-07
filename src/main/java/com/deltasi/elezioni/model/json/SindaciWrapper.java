package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SindaciWrapper {



    public SindaciWrapper() {
        this.setSindaci(new ArrayList<>());
    }

    public SindaciWrapper(List<SindacoSimple> sindaci) {
        this.setSindaci(sindaci);
    }

    @JsonProperty("Sindaci")
    private List<SindacoSimple> sindaci;
    public List<SindacoSimple> getSindaci() {
        return sindaci;
    }
    public void setSindaci(List<SindacoSimple> sindaci) {
        this.sindaci = sindaci;
    }
    private Integer contestate;
    private Integer bianche;
    private Integer nulle;
    private Integer totalevalide;
    private Integer solosindaco;
    private Integer totale;
    private Integer votanti;

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

    public Integer getTotalevalide() {
        return totalevalide;
    }

    public void setTotalevalide(Integer totalevalide) {
        this.totalevalide = totalevalide;
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

    public Integer getVotanti() {
        return votanti;
    }

    public void setVotanti(Integer votanti) {
        this.votanti = votanti;
    }
}
