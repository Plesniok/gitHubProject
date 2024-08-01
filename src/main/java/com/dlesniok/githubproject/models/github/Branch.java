package com.dlesniok.githubproject.models.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch {
    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private Commit lastCommit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getLastCommit() {
        return lastCommit;
    }

    public void setLastCommit(Commit lastCommit) {
        this.lastCommit = lastCommit;
    }
}
