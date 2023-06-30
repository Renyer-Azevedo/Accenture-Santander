package br.com.santander.domain.enumeration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionMessageTest {

    @Test
    void testEnumValues() {
        assertEquals("no success record was found.", ExceptionMessage.RECORD_SUCCESS_NOT_FOUND.getMessageKey());
        assertEquals("no error record was found.", ExceptionMessage.RECORD_ERROR_NOT_FOUND.getMessageKey());
        assertEquals("no record was found.", ExceptionMessage.RECORD_NOT_FOUND.getMessageKey());
        assertEquals("unknown error", ExceptionMessage.INTERNAL_SERVER_ERROR.getMessageKey());
    }

    @Test
    void testToString() {
        assertEquals("no success record was found.", ExceptionMessage.RECORD_SUCCESS_NOT_FOUND.toString());
        assertEquals("no error record was found.", ExceptionMessage.RECORD_ERROR_NOT_FOUND.toString());
        assertEquals("no record was found.", ExceptionMessage.RECORD_NOT_FOUND.toString());
        assertEquals("unknown error", ExceptionMessage.INTERNAL_SERVER_ERROR.toString());
    }
}

