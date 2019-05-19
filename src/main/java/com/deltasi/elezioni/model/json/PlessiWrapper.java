package com.deltasi.elezioni.model.json;

import com.deltasi.elezioni.model.authentication.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlessiWrapper {

    public PlessiWrapper() {
        this.plessi = new ArrayList<>();
    }

    public PlessiWrapper(List<PlessoJson> plessiw) {
        this.plessi = plessiw;
    }

    @JsonProperty("Plessi")
    private List<PlessoJson> plessi;
    private User user;
    public List<PlessoJson> getPlessi() {
        return plessi;
    }
    private boolean validated;
    private Map<String, String> errorMessages;

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

    public void setPlessi(List<PlessoJson> plessiw) {
        this.plessi = plessiw;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
