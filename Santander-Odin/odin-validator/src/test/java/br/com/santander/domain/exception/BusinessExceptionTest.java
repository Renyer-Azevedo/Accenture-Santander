package br.com.santander.domain.exception;

import br.com.santander.domain.enumeration.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;

class BusinessExceptionTest {

    @Test
    void testConstructorWithHttpStatusReasonAndCause() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionMessage reason = ExceptionMessage.RECORD_NOT_FOUND;
        Throwable cause = new RuntimeException("Some cause");
        String[] messageParams = {"param1", "param2"};

        BusinessException exception = new BusinessException(status, reason, cause, messageParams);

        assertEquals(status, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithIntegerStatusReasonAndCause() {
        Integer status = 404;
        ExceptionMessage reason = ExceptionMessage.RECORD_ERROR_NOT_FOUND;
        Throwable cause = new RuntimeException("Some cause");
        String[] messageParams = {"param1", "param2"};

        BusinessException exception = new BusinessException(status, reason, cause, messageParams);

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithHttpStatusAndReason() {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionMessage reason = ExceptionMessage.RECORD_ERROR_NOT_FOUND;
        String[] messageParams = {"param1", "param2"};

        BusinessException exception = new BusinessException(status, reason, messageParams);

        assertEquals(status, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testConstructorWithIntegerStatusAndReason() {
        Integer status = 500;
        ExceptionMessage reason = ExceptionMessage.RECORD_SUCCESS_NOT_FOUND;
        String[] messageParams = {"param1", "param2"};

        BusinessException exception = new BusinessException(status, reason, messageParams);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testConstructorWithReason() {
        ExceptionMessage reason = ExceptionMessage.INTERNAL_SERVER_ERROR;
        String[] messageParams = {"param1", "param2"};

        BusinessException exception = new BusinessException(reason, messageParams);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertNull(exception.getCause());
    }
}

