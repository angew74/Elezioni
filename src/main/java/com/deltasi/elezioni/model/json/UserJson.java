package com.deltasi.elezioni.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserJson
{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("username")
    private String username;

    public UserJson(Integer idnew, String usernamenew) {
        setId(idnew);
        setUsername(usernamenew);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
