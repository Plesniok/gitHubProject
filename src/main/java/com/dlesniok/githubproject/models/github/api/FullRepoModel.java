package com.dlesniok.githubproject.models.github.api;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullRepoModel {
    @JsonProperty("name")
    private String name;

    @JsonProperty("owner")
    private Owner owner;

    @JsonProperty("fork")
    private Boolean fork;

    @JsonProperty("branches_url")
    private String branches_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean getFork() {
        return fork;
    }

    public String getBranches_url() {
        return branches_url;
    }
}
