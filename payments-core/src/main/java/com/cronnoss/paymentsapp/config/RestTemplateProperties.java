package com.cronnoss.paymentsapp.config;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
public class RestTemplateProperties {

    private String uri;
    private Duration connectTimeout;
    private Duration readTimeout;
}
