package com.apc.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableSwagger2
@SpringBootApplication
public class InquiryServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(InquiryServiceApp.class, args);
		System.out.print(System.currentTimeMillis());

	}
}
