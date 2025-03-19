package com.cronnoss.paymentsapp.properties;

import com.cronnoss.paymentsapp.dto.PaymentErrorResponseDto;
import com.cronnoss.paymentsapp.exceptions.IntegrationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is4xxClientError()
                || response.getStatusCode().is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
            ObjectMapper objectMapper = new ObjectMapper();
            PaymentErrorResponseDto responseDto = objectMapper.readValue(response.getBody(), PaymentErrorResponseDto.class);
            throw new IntegrationException(
                    "Error accessing external API: " + responseDto.getMessage(), response.getStatusCode().toString());
        }
    }
}
