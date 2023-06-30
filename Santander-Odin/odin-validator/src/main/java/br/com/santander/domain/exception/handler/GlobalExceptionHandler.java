package br.com.santander.domain.exception.handler;

import br.com.santander.domain.exception.BusinessException;
import br.com.santander.domain.exception.builder.ExceptionResponseBuilder;
import br.com.santander.domain.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final ExceptionResponseBuilder responseBuilder;

    public GlobalExceptionHandler(ExceptionResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessError(BusinessException exception) {
        ExceptionResponse exceptionResponse = responseBuilder.getBusinessExceptionResponse(exception);
        log.error(exceptionResponse.getMessage(), exception);
        return ResponseEntity.status(exception.getStatus()).body(exceptionResponse);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleInternalServerError(Exception exception) {
        ExceptionResponse exceptionResponse = responseBuilder.getInternalErrorResponse();
        log.error("Unexpected exception occurred: " + exceptionResponse.getMessage(), exception);
        return exceptionResponse;
    }

}
