package com.cronnoss.paymentsapp.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;


@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri("http://localhost:8080")
                .setConnectTimeout(Duration.of(3, SECONDS))
                .setReadTimeout(Duration.of(3, SECONDS))
                .build();
    }
}
