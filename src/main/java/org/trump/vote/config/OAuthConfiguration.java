package org.trump.vote.config;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.trump.vote.config.properties.AppProperties;

import static org.trump.vote.constant.VoteConstant.*;

@Configuration
public class OAuthConfiguration {

    @Autowired
    private AppConfigBean appConfigBean;

    @Bean
    public OAuth10aService twitterService() {

        AppProperties appProperties = appConfigBean.getAppProperties();
        String domainName = appProperties.getDomainName();
        int port = appProperties.getPort();
        String url = domainName + ":" + port;

        return new ServiceBuilder(API_KEY)
                .apiSecret(API_SECRET)
                .callback(url + CALLBACK_URL)
                .build(TwitterApi.instance());
    }
}
