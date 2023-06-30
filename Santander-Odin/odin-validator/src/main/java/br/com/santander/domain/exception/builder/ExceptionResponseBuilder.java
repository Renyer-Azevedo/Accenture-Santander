package br.com.santander.domain.exception.builder;

import br.com.santander.domain.enumeration.ExceptionMessage;
import br.com.santander.domain.exception.BusinessException;
import br.com.santander.domain.response.ExceptionResponse;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;

@ApplicationScoped
public class ExceptionResponseBuilder {

    public ExceptionResponse getBusinessExceptionResponse(BusinessException exception) {
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getReason().getMessageKey())
                .build();
    }

    public ExceptionResponse getInternalErrorResponse() {
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ExceptionMessage.INTERNAL_SERVER_ERROR.getMessageKey())
                .build();
    }

}
