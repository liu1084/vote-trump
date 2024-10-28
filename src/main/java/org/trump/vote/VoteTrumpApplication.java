package org.trump.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

@SpringBootApplication
@ComponentScan(basePackages = {"org.trump.vote", "com.cinaval"})
public class VoteTrumpApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(VoteTrumpApplication.class);

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {

        String proxyHost = "127.0.0.1";
        String proxyPort = "7890";

        if (proxyHost != null && proxyPort != null) {
            System.setProperty("https.proxyHost", proxyHost);
            System.setProperty("https.proxyPort", proxyPort);
        }

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
