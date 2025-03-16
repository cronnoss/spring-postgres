package com.cronnoss.paymentsapp.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ConfigurationPropertiesScan
public class AppConfig {

    private final IntegrationProperties integrationProperties;

    public AppConfig(IntegrationProperties integrationProperties) {
        this.integrationProperties = integrationProperties;
    }

    @Bean
    public RestTemplate paymentsClient() {
        RestTemplateProperties properties = integrationProperties.getPaymentsClientProperties();
        return new RestTemplateBuilder()
                .rootUri(properties.getUri())
                .setConnectTimeout(properties.getConnectTimeout())
                .setReadTimeout(properties.getReadTimeout())
                .build();
    }
}
