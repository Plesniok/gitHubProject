package com.dlesniok.githubproject.models.github.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
    @JsonProperty("login")
    private String login;

    public String getLogin() {
        return login;
    }
}
