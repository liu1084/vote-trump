package org.trump.vote;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"org.trump.vote", "com.cinaval"})
public class VoteTrumpApplication implements CommandLineRunner {

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(VoteTrumpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            new Thread(() -> {
                Properties p = System.getProperties();
                String pid = p.getProperty("PID");
                String userCountry = p.getProperty("user.country");
                String userLanguage = p.getProperty("user.language");
                String timezone = p.getProperty("user.timezone");
                String fileEncoding = p.getProperty("file.encoding");
                String tomcatHome = p.getProperty("catalina.home");
                String javaHome = p.getProperty("java.home");
                String javaVersion = p.getProperty("java.version");

                log.info("pid = {}, user.country = {}, user.language = {}, timezone = {}, file.encoding = {}, catalina.home = {}, java.home = {}, java.version = {}, application name = {}, port = {}", pid, userCountry, userLanguage, timezone, fileEncoding, tomcatHome, javaHome, javaVersion, applicationName, port);
            }).start();
        } catch (Exception e) {
            log.error("Application = {} start failed. error = {}", applicationName, e.getCause().getMessage());
            throw new Exception(e);
        }
    }
}
