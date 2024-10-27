package org.trump.vote.config;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.trump.vote.constant.VoteConstant.*;

@Configuration
public class OAuthConfiguration {

    @Value("${app.domainName}")
    private String domainName;

    @Value("${app.port}")
    private int port;

    @Bean
    public OAuth10aService twitterService() {
        String url = domainName + ":" + port;

        return new ServiceBuilder(API_KEY)
                .apiSecret(API_SECRET)
                .callback(url + CALLBACK_URL)
                .build(TwitterApi.instance());
    }
}
