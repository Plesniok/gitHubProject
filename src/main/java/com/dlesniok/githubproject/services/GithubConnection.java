package com.dlesniok.githubproject.services;

import com.dlesniok.githubproject.exceptions.GithubException;
import com.dlesniok.githubproject.models.api.SimpleResponse;
import com.dlesniok.githubproject.models.github.Branch;
import com.dlesniok.githubproject.models.github.api.FullRepoModel;
import com.dlesniok.githubproject.services.general.RequestSender;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

@Service
public class GithubConnection {

    @Value("${env.github.url}")
    private String githubUrl;


    public List<FullRepoModel> getUserRepos(String userLogin) throws IOException, GithubException {
        SimpleResponse response = RequestSender.sendGetRequest(githubUrl + String.format("/users/%s/repos", userLogin));

        if(response.getStatusCode() == HttpURLConnection.HTTP_OK) {
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

            TypeReference<List<FullRepoModel>> typeRef = new TypeReference<List<FullRepoModel>>() {};

            List<FullRepoModel> repoResponse =  objectMapper.readValue(
                    response.getResponseData(),
                    typeRef
            );

            return repoResponse;
        }
        throw new GithubException(response);

    }

    public List<Branch> getHateoasRepoBranches(String hateoasBranchesUrl) throws IOException, GithubException {
        String formatedHateoasBranchesUrl = hateoasBranchesUrl.replace("{/branch}", "");

        SimpleResponse response = RequestSender.sendGetRequest(formatedHateoasBranchesUrl);

        if(response.getStatusCode() == HttpURLConnection.HTTP_OK) {
            ObjectMapper objectMapper = new ObjectMapper();

            TypeReference<List<Branch>> typeRef = new TypeReference<List<Branch>>() {};

            List<Branch> repoResponse =  objectMapper.readValue(
                    response.getResponseData(),
                    typeRef
            );

            return repoResponse;
        }
        throw new GithubException(response);

    }
}
