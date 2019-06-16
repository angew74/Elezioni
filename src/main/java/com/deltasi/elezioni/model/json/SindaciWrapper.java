package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SindaciWrapper {



    public SindaciWrapper() {
        this.sindaci = new ArrayList<>();
    }

    public SindaciWrapper(List<SindacoSimple> sindaci) {
        this.sindaci = sindaci;
    }

    @JsonProperty("Sindaci")
    private List<SindacoSimple> sindaci;
    public List<SindacoSimple> getSindaci() {
        return sindaci;
    }
    public void setSindaci(List<SindacoSimple> liste) {
        this.sindaci = sindaci;
    }
}
