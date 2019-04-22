package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CandidatiWrapper {

    public CandidatiWrapper() {
        this.candidati = new ArrayList<>();
    }

    public CandidatiWrapper(List<CandidatoJson> candidati) {
        this.candidati = candidati;
    }

    @JsonProperty("Candidati")
    private List<CandidatoJson> candidati;
    public List<CandidatoJson> getCandidati() {
        return candidati;
    }
    public void setCandidati(List<CandidatoJson> liste) {
        this.candidati = liste;
    }

}
