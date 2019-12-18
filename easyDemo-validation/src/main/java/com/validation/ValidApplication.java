package com.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@SpringBootApplication
@SpringBootConfiguration
@Configuration
public class ValidApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(ValidApplication.class, args);
    }
}

