package br.com.santander.domain.exception.builder;

import br.com.santander.domain.enumeration.ExceptionMessage;
import br.com.santander.domain.exception.BusinessException;
import br.com.santander.domain.response.ExceptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExceptionResponseBuilderTest {

    @Test
    void testGetBusinessExceptionResponse() {
        BusinessException exception = new BusinessException(HttpStatus.BAD_REQUEST, ExceptionMessage.RECORD_NOT_FOUND, "param1", "param2");

        ExceptionResponseBuilder builder = new ExceptionResponseBuilder();
        ExceptionResponse response = builder.getBusinessExceptionResponse(exception);

        assertNotNull(response);
        assertNotNull(response.getTimestamp());
        assertEquals(ExceptionMessage.RECORD_NOT_FOUND.getMessageKey(), response.getMessage());
    }

    @Test
    void testGetInternalErrorResponse() {
        ExceptionResponseBuilder builder = new ExceptionResponseBuilder();
        ExceptionResponse response = builder.getInternalErrorResponse();

        assertNotNull(response);
        assertNotNull(response.getTimestamp());
        assertEquals(ExceptionMessage.INTERNAL_SERVER_ERROR.getMessageKey(), response.getMessage());
    }
}

