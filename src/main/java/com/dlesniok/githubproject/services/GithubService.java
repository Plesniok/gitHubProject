package com.dlesniok.githubproject.services;

import com.dlesniok.githubproject.exceptions.GithubException;
import com.dlesniok.githubproject.models.github.Branch;
import com.dlesniok.githubproject.models.github.UserRepo;
import com.dlesniok.githubproject.models.github.api.FullRepoModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GithubService {
    public GithubService(GithubConnection githubConnection){
        this.githubConnection = githubConnection;
    }

    private final GithubConnection githubConnection;

    public List<UserRepo> getUserRepos(String userLogin) throws IOException, GithubException {
        List<FullRepoModel> githubRepos = this.githubConnection.getUserRepos(userLogin);

        List<UserRepo> userRepos = githubRepos.stream().map(githubRepo -> {
           UserRepo userRepo = new UserRepo();

            userRepo.setName(githubRepo.getName());
            userRepo.setOwnerLogin(githubRepo.getOwner().getLogin());

            try {
                List<Branch> userRepoBranches = this.githubConnection.getHateoasRepoBranches(githubRepo.getBranches_url());
                userRepo.setBranches(userRepoBranches);
            } catch (IOException | GithubException e) {
                throw new RuntimeException(e);
            }

            return userRepo;

        }).toList();


        return userRepos;
    }
}
