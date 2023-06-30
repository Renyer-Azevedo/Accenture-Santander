package br.com.santander.domain.exception;

import br.com.santander.domain.enumeration.ExceptionMessage;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;

class DefaultExceptionTest {

    @Test
    void testConstructorWithStatusReasonAndCause() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionMessage reason = ExceptionMessage.RECORD_NOT_FOUND;
        Throwable cause = new RuntimeException("Some cause");
        String[] messageParams = {"param1", "param2"};

        DefaultException exception = new DefaultException(status, reason, cause, messageParams);

        assertEquals(status, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithStatusReasonAndThrowable() {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String reasonText = "Some reason";
        Throwable throwable = new RuntimeException("Some throwable");

        DefaultException exception = new DefaultException(status, reasonText, throwable);

        assertEquals(status, exception.getStatus());
        assertNull(exception.getReason());
        assertNull(exception.getMessageParams());
        assertEquals(reasonText, exception.getReasonText());
        assertEquals(reasonText, exception.getMessage());
        assertEquals(throwable, exception.getCause());
    }

    @Test
    void testConstructorWithStatusAndReason() {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionMessage reason = ExceptionMessage.RECORD_ERROR_NOT_FOUND;
        String[] messageParams = {"param1", "param2"};

        DefaultException exception = new DefaultException(status, reason, messageParams);

        assertEquals(status, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testConstructorWithReason() {
        ExceptionMessage reason = ExceptionMessage.RECORD_SUCCESS_NOT_FOUND;
        String[] messageParams = {"param1", "param2"};

        DefaultException exception = new DefaultException(reason, messageParams);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
        assertEquals(reason, exception.getReason());
        assertArrayEquals(messageParams, exception.getMessageParams());
        assertEquals(reason.getMessageKey(), exception.getMessage());
        assertNull(exception.getCause());
    }
}

