/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deltasi.elezioni.model.json;

import com.deltasi.elezioni.model.authentication.User;

import java.util.Map;

/**
 *
 * @author AdminDSI
 */
public class UserJsonResponse {
 
  
   private UserJson user;
   private boolean validated;
   private Map<String, String> errorMessages;

   // Getter and Setter methods

    /**
     * @return the user
     */
    public UserJson getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserJson user) {
        this.user = user;
    }

    /**
     * @return the validated
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * @param validated the validated to set
     */
    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    /**
     * @return the errorMessages
     */
    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * @param errorMessages the errorMessages to set
     */
    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

}
