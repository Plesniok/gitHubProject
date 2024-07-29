package com.dlesniok.githubproject.services;

import com.dlesniok.githubproject.exceptions.GithubException;
import com.dlesniok.githubproject.models.api.SimpleResponse;
import com.dlesniok.githubproject.models.github.UserRepo;
import com.dlesniok.githubproject.services.general.RequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class GithubConnection {

    @Value("${env.github.url}")
    private String githubUrl;

    public List<UserRepo> getUserRepos(String username) throws IOException, GithubException {
        SimpleResponse response = RequestSender.sendGetRequest(githubUrl + String.format("/users/%s/repos", username));

        if(response.getStatusCode() == HttpURLConnection.HTTP_OK) {
            ObjectMapper objectMapper = new ObjectMapper();;

            return Collections.emptyList();
        }
        throw new GithubException(response);

    }
}
