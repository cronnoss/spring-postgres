package com.cronnoss.paymentsapp.controller;

import com.cronnoss.paymentsapp.dto.ErrorResponseDto;
import com.cronnoss.paymentsapp.exceptions.IntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IntegrationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handle(IntegrationException integrationException) {
        return new ErrorResponseDto(integrationException.getMessage(), integrationException.getExternalSystemCode());
    }
}
