package org.trump.vote.service;

import org.trump.vote.entity.TwitterUser;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface ITwitterService {

    Optional<TwitterUser> getTwitterUser(String oauthToken, String oauthVerifier) throws IOException, ExecutionException, InterruptedException;

}
