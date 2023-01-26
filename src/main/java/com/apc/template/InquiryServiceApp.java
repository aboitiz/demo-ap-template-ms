package com.apc.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
@Slf4j
public class InquiryServiceApp {

    @Value("${environment.level}")
    private String env;

    public static void main(String[] args) {
        SpringApplication.run(InquiryServiceApp.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            log.info("Environment: " + env);
        };
    }
}
