package com.apc.template.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

@Configuration
public class SwaggerConfiguration {

    public static final String USER_TAG = "user-api";
    public static final String CUSTOMER_TAG = "customer-api";
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(Predicate.not(PathSelectors.regex("/error")))
                .paths(Predicate.not(PathSelectors.regex("/profile")))
                .build()
                .tags(new Tag(CUSTOMER_TAG, "This page documents User RESTful Web Service Endpoints"))
                .tags(new Tag(USER_TAG, "This page documents User RESTful Web Service Endpoints"));

    }


}
