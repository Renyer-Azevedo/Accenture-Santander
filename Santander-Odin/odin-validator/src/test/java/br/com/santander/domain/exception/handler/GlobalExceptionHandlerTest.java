package br.com.santander.domain.exception.handler;

import br.com.santander.domain.enumeration.ExceptionMessage;
import br.com.santander.domain.exception.BusinessException;
import br.com.santander.domain.exception.builder.ExceptionResponseBuilder;
import br.com.santander.domain.response.ExceptionResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @Mock
    private ExceptionResponseBuilder responseBuilder;

    @InjectMocks
    private GlobalExceptionHandler exceptionHandler;

    @Test
    void testHandleBusinessError() {
        BusinessException exception = new BusinessException(HttpStatus.BAD_REQUEST, ExceptionMessage.RECORD_NOT_FOUND, "param1", "param2");
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        when(responseBuilder.getBusinessExceptionResponse(Mockito.any())).thenReturn(exceptionResponse);

        ResponseEntity<ExceptionResponse> responseEntity = exceptionHandler.handleBusinessError(exception);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(exceptionResponse, responseEntity.getBody());
        verify(responseBuilder, times(1)).getBusinessExceptionResponse(Mockito.any());
    }

    @Test
    void testHandleInternalServerError() {
        Exception exception = new Exception();
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ExceptionMessage.INTERNAL_SERVER_ERROR.getMessageKey())
                .build();
        when(responseBuilder.getInternalErrorResponse()).thenReturn(exceptionResponse);

        ExceptionResponse response = exceptionHandler.handleInternalServerError(exception);

        assertNotNull(response);
        assertEquals(ExceptionMessage.INTERNAL_SERVER_ERROR.getMessageKey(), response.getMessage());
        assertEquals(exceptionResponse, response);
        verify(responseBuilder, times(1)).getInternalErrorResponse();
    }

}
