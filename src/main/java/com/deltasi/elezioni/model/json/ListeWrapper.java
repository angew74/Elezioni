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
}
