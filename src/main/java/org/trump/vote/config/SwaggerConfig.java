package org.trump.vote.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

    @Bean
    public Docket api() {
        log.debug("Starting Swagger");
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metaInfo())
                .ignoredParameterTypes(SpringDataWebProperties.Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .useDefaultResponseMessages(false);

        docket = docket.select()
                .paths(regex("/api/v1/.*"))
                .build();

        return docket;
    }

    Contact contact = new Contact(
            "Jim Liu",
            "https://github.com/1084",
            "liu1084@gmail.com");

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("API")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
