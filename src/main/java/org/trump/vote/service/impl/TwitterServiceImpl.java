package org.trump.vote.service.impl;

import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.service.ITwitterService;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class TwitterServiceImpl implements ITwitterService {

    @Autowired
    private OAuth10aService oAuth10aService;

    @Override
    public Optional<TwitterUser> getTwitterUser(String oauthToken, String oauthVerifier) throws IOException, ExecutionException, InterruptedException {
        // 使用 oauth_token 和 oauth_verifier 获取 Access Token
        OAuth1AccessToken accessToken = oAuth10aService.getAccessToken(new OAuth1RequestToken(oauthToken, oauthVerifier), oauthVerifier);
        if (accessToken == null) {
            throw new RuntimeException("Failed to get access token");
        }
        // 访问 Twitter API 获取用户信息
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
        // 传递 access token
        oAuth10aService.signRequest(accessToken, request);
        // 发送请求
        Response response = oAuth10aService.execute(request);
        // 处理返回结果
        if (response.getCode() != 200) {
            throw new RuntimeException("Failed to get user info: " + response.getBody());
        }
        // 解析用户信息
        TwitterUser user = new Gson().fromJson(response.getBody(), TwitterUser.class);
        return Optional.of(user);
    }
}
