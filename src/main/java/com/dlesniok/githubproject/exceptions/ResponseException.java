package com.dlesniok.githubproject.exceptions;


import com.dlesniok.githubproject.models.api.SimpleResponse;

public class ResponseException extends Exception{
    final private SimpleResponse response;

    public ResponseException(SimpleResponse response) {
        super(response.getResponseData());

        this.response = response;
    }

    @Override
    public String toString() {
        return String.format("Request failed with code: %d and message: %s",  response.getStatusCode(), response.getResponseData());
    }

    public SimpleResponse getResponse() {
        return response;
    }
}

