/*
 * Copyright (c)  中润华谷（南京）科技有限公司版权所有 2019 - 2020.
 */

package org.trump.vote.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <br> File: com.cinaval.cpm.config</br>
 * <br> Date: Created on 2023/8/11</br>
 * <br> Description: mysql属性</br>
 *
 * @author: LiuYuHeng
 **/
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class MySQLProperty {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int connectionTimeout;
}
