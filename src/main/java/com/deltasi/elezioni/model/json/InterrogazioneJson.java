package com.deltasi.elezioni.model.json;

import java.util.Map;

public class InterrogazioneJson {

    private boolean validated;
    private Map<String, String> errorMessages;

    private AffluenzaJson affluenzaJson;

    private VotiJson votiJson;

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public AffluenzaJson getAffluenzaJson() {
        return affluenzaJson;
    }

    public void setAffluenzaJson(AffluenzaJson affluenzaJson) {
        this.affluenzaJson = affluenzaJson;
    }

    public VotiJson getVotiJson() {
        return votiJson;
    }

    public void setVotiJson(VotiJson votiJson) {
        this.votiJson = votiJson;
    }
}
