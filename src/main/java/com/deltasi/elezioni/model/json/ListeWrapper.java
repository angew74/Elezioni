package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListeWrapper {


    public ListeWrapper() {
        this.liste = new ArrayList<>();
    }

    public ListeWrapper(List<ListaSemplice> liste) {
        this.liste = liste;
    }

    @JsonProperty("Liste")
    private List<ListaSemplice> liste;
    public List<ListaSemplice> getListe() {
        return liste;
    }
    public void setListe(List<ListaSemplice> liste) {
        this.liste = liste;
    }

    private int contestate;
    private int bianche;
    private int nulle;
    private int totalevalide;
    private int solosindaco;
    private int totale;

    public int getContestate() {
        return contestate;
    }

    public void setContestate(int contestate) {
        this.contestate = contestate;
    }

    public int getBianche() {
        return bianche;
    }

    public void setBianche(int bianche) {
        this.bianche = bianche;
    }

    public int getNulle() {
        return nulle;
    }

    public void setNulle(int nulle) {
        this.nulle = nulle;
    }

    public int getTotalevalide() {
        return totalevalide;
    }

    public void setTotalevalide(int totalevalide) {
        this.totalevalide = totalevalide;
    }

    public int getSolosindaco() {
        return solosindaco;
    }

    public void setSolosindaco(int solosindaco) {
        this.solosindaco = solosindaco;
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }
}
