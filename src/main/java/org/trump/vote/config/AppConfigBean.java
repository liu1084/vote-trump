package org.trump.vote.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.trump.vote.config.properties.AppProperties;
import org.trump.vote.config.properties.MySQLProperty;

@Configuration(value = "appConfigBean")
@Data
@ToString
public class AppConfigBean {

    @Autowired
    private MySQLProperty mySQLProperty;

    @Autowired
    private AppProperties appProperties;

    @Value("${isDebug}")
    private boolean isDebug;
}
