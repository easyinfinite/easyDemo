package com.staging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@SpringBootApplication
@SpringBootConfiguration
@Configuration
public class StagingApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
//        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(StagingApplication.class, args);
    }
}

