package com.deltasi.elezioni.model.json;

import java.util.List;
import java.util.Map;

public class AddettoJson {

    private boolean validated;
    private Map<String, String> errorMessages;
    private UserJson user;
    private List<PlessoJson> plessi;



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

    public UserJson getUser() {
        return user;
    }

    public void setUser (UserJson user) {
        this.user = user;
    }


    public List<PlessoJson> getPlessi() {
        return plessi;
    }

    public void setPlessi(List<PlessoJson> plessi) {
        this.plessi = plessi;
    }
}
