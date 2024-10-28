package org.trump.vote.controller;

import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trump.vote.config.AppConfigBean;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.service.ITwitterService;
import org.trump.vote.service.IVoteService;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.trump.vote.constant.ApiConstant.API_V1;

@RestController
@RequestMapping(API_V1 + "/twitter")
@Slf4j
public class TwitterController {

    @Autowired
    private AppConfigBean appConfigBean;

    @Autowired
    private IVoteService voteService;

    @Autowired
    private ITwitterService twitterService;

    @Autowired
    private OAuth10aService oAuth10aService;

    @Value("${debug}")
    private boolean isDebug;

    @GetMapping(value = "/login", produces = "text/html")
    @ApiOperation(value = "Twitter 登录", notes = "Twitter 登录")
    public String login() throws IOException, ExecutionException, InterruptedException {

        if (isDebug) {
            log.debug("user login");
        }
        // 获取请求令牌
        OAuth1RequestToken requestToken = oAuth10aService.getRequestToken();

//        String oauthToken = requestToken.getToken();
//        String oauthTokenSecret = requestToken.getTokenSecret();

//        if (isDebug) {
//            log.debug("oauth_token = {}, oauth_token_secret = {}", oauthToken, oauthTokenSecret);
//        }

        // Twitter 授权页面
        String authUrl = oAuth10aService.getAuthorizationUrl(requestToken);

        if (isDebug) {
            log.debug("auth_url = {}", authUrl);
        }

        // 重定向到 Twitter 授权页面
        return "redirect:" + authUrl;
    }

    @GetMapping("/callback")
    public String twitterCallback(@RequestParam("oauth_token") String oauthToken,
                                  @RequestParam("oauth_verifier") String oauthVerifier)
            throws IOException, ExecutionException, InterruptedException {

        if (isDebug) {
            log.debug("oauth_token = {}, oauth_verifier = {}", oauthToken, oauthVerifier);
        }

        Optional<TwitterUser> optionalUser = twitterService.getTwitterUser(oauthToken, oauthVerifier);

        // 保存用户信息
        optionalUser.ifPresent(twitterUser -> voteService.cacheTwitterUser(twitterUser));

        return "redirect:/";
    }
}