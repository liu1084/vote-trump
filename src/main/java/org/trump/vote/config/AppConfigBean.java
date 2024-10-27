package org.trump.vote.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.trump.vote.config.properties.MySQLProperty;

@Configuration(value = "appConfigBean")
@Setter
@Getter
@ToString
public class AppConfigBean {

    @Autowired
    private MySQLProperty mySQLProperty;


    @Value("${isDebug}")
    private boolean isDebug;
}
