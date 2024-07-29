package com.dlesniok.githubproject.controllers;

import com.dlesniok.githubproject.exceptions.GithubException;
import com.dlesniok.githubproject.models.api.ApiResponse;
import com.dlesniok.githubproject.models.github.UserRepo;
import com.dlesniok.githubproject.services.GithubConnection;
import com.dlesniok.githubproject.models.api.Responses;
import com.dlesniok.githubproject.models.api.Constant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GitHubController {

    public GitHubController(GithubConnection githubConnection){
        this.githubConnection = githubConnection;
    }

    private GithubConnection githubConnection;

    @GetMapping("/git/{username}/repos")
    public ResponseEntity<ApiResponse<List<UserRepo>>> getUserRepos(@PathVariable("username") String username) throws IOException, GithubException {
        List<UserRepo> userRepos = githubConnection.getUserRepos(username);

        return Responses.ok(null, Constant.getProductsResponsesHashMap(), Constant.GIT_HUB_PROJECT.concat("1"));


    }
}
