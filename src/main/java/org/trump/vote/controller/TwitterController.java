package org.trump.vote.controller;

import com.cinaval.cache.redis.service.ICacheHandler;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.service.IVoteService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
@RestController
@RequestMapping("/twitter")
public class TwitterController {
    @Autowired
    private OAuth10aService twitterService;

    @Autowired
    private IVoteService voteService;



    @GetMapping("/callback")
    public String twitterCallback(@RequestParam("oauth_token") String oauthToken,
                                  @RequestParam("oauth_verifier") String oauthVerifier)
            throws IOException, ExecutionException, InterruptedException {

        // 使用 oauth_token 和 oauth_verifier 获取 Access Token
        OAuth1AccessToken accessToken = twitterService.getAccessToken(new OAuth1RequestToken(oauthToken, oauthVerifier), oauthVerifier);

        // 访问 Twitter API 获取用户信息
        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
        twitterService.signRequest(accessToken, request);

        Response response = twitterService.execute(request);

        if (!response.isSuccessful()) {
            throw new RuntimeException("Failed to get user info: " + response.getCode() + " " + response.getBody());
        }

        // 解析用户信息
        TwitterUser user = new Gson().fromJson(response.getBody(), TwitterUser.class);
        if (user == null) {
            throw new RuntimeException("Failed to parse user info: " + response.getBody());
        }

        // 保存用户信息
        voteService.cacheTwitterUser(user);


        // 检查用户是否已经投票等操作
        voteService.isVoted(user.getScreenName());

        return "redirect:/votetrump.org";
    }

    @GetMapping("/login")
    public String showHome() throws IOException, ExecutionException, InterruptedException {
        // 获取请求令牌
        OAuth1RequestToken requestToken = twitterService.getRequestToken();

        // Twitter 授权页面
        String authUrl = twitterService.getAuthorizationUrl(requestToken);

        // 重定向到 Twitter 授权页面
        return "redirect:" + authUrl;
    }
}