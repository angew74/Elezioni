package com.deltasi.elezioni.model.json;

import com.deltasi.elezioni.model.configuration.Iscritti;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SezioneJson {

    @JsonProperty("sezione")
    private Integer sezione;
    @JsonProperty("cabina")
    private Integer cabina;
    @JsonProperty("tipo")
    private String tipo;
    private boolean validated;
    private Map<String, String> errorMessages;

    private Iscritti iscritti;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Iscritti getIscritti() {
        return iscritti;
    }

    public void setIscritti(Iscritti iscritti) {
        this.iscritti = iscritti;
    }
}
