package com.dlesniok.githubproject.exceptions;

import com.dlesniok.githubproject.models.api.SimpleResponse;

public class GithubException extends ResponseException {
    public GithubException(SimpleResponse response) {
        super(response);
    }

}

