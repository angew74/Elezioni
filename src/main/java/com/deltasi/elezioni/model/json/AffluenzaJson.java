package com.deltasi.elezioni.model.json;

import java.util.Map;

public class AffluenzaJson {

    private Integer id;
    private Integer numerosezione;
    private Integer votantimaschi;
    private Integer votantifemmine;
    private Integer votantitotali;
    private Integer iscrittimaschi;
    private Integer iscrittifemmine;
    private Integer iscrittitotali;
    private Integer votantimaschiaffp;
    private Integer votantifemmineaffp;
    private Integer votantitotaliaffp;
    private String tipo;
    private boolean validated;
    private Map<String, String> errorMessages;

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

    public Integer getVotantimaschi() {
        return votantimaschi;
    }

    public void setVotantimaschi(Integer votantimaschi) {
        this.votantimaschi = votantimaschi;
    }

    public Integer getVotantifemmine() {
        return votantifemmine;
    }

    public void setVotantifemmine(Integer votantifemmine) {
        this.votantifemmine = votantifemmine;
    }

    public Integer getVotantitotali() {
        return votantitotali;
    }

    public void setVotantitotali(Integer votantitotali) {
        this.votantitotali = votantitotali;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getVotantimaschiaffp() {
        return votantimaschiaffp;
    }

    public void setVotantimaschiaffp(Integer votantimaschiaffp) {
        this.votantimaschiaffp = votantimaschiaffp;
    }

    public Integer getVotantifemmineaffp() {
        return votantifemmineaffp;
    }

    public void setVotantifemmineaffp(Integer votantifemmineaffp) {
        this.votantifemmineaffp = votantifemmineaffp;
    }

    public Integer getVotantitotaliaffp() {
        return votantitotaliaffp;
    }

    public void setVotantitotaliaffp(Integer votantitotaliaffp) {
        this.votantitotaliaffp = votantitotaliaffp;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Integer getIscrittimaschi() {
        return iscrittimaschi;
    }

    public void setIscrittimaschi(Integer iscrittimaschi) {
        this.iscrittimaschi = iscrittimaschi;
    }

    public Integer getIscrittifemmine() {
        return iscrittifemmine;
    }

    public void setIscrittifemmine(Integer iscrittfemmine) {
        this.iscrittifemmine = iscrittfemmine;
    }

    public Integer getIscrittitotali() {
        return iscrittitotali;
    }

    public void setIscrittitotali(Integer iscrittitotali) {
        this.iscrittitotali = iscrittitotali;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
