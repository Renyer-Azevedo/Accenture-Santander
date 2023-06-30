package br.com.santander.domain.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ExceptionResponseTest {

    private ObjectMapper objectMapper;
    private LocalDateTime timestamp;
    private String message;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        timestamp = LocalDateTime.now();
        message = "Test exception message";
    }

    @Test
    void testExceptionResponseToString() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(timestamp, message);

        String jsonString = exceptionResponse.toString();

        String expectedJsonString = "ExceptionResponse(timestamp=" + timestamp.toString() + ", message=" + message + ")";

        Assertions.assertEquals(expectedJsonString, jsonString);
    }

    @Test
    void testExceptionResponseEquals() {
        ExceptionResponse exceptionResponse1 = new ExceptionResponse(timestamp, message);
        ExceptionResponse exceptionResponse2 = new ExceptionResponse(timestamp, message);

        Assertions.assertEquals(exceptionResponse1, exceptionResponse2);
    }

    @Test
    void testExceptionResponseBuilder() {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(timestamp)
                .message(message)
                .build();

        Assertions.assertEquals(timestamp, exceptionResponse.getTimestamp());
        Assertions.assertEquals(message, exceptionResponse.getMessage());
    }

    @Test
    void testExceptionResponseGettersAndSetters() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTimestamp(timestamp);
        exceptionResponse.setMessage(message);

        Assertions.assertEquals(timestamp, exceptionResponse.getTimestamp());
        Assertions.assertEquals(message, exceptionResponse.getMessage());
    }

    @Test
    void testExceptionResponseAllArgsConstructor() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(timestamp, message);

        Assertions.assertEquals(timestamp, exceptionResponse.getTimestamp());
        Assertions.assertEquals(message, exceptionResponse.getMessage());
    }

    @Test
    void testExceptionResponseNoArgsConstructor() {
        ExceptionResponse exceptionResponse = new ExceptionResponse();

        Assertions.assertNull(exceptionResponse.getTimestamp());
        Assertions.assertNull(exceptionResponse.getMessage());
    }

    @Test
    void testExceptionResponseSerialization() throws JsonProcessingException {
        ExceptionResponse exceptionResponse = new ExceptionResponse(timestamp, message);

        String jsonString = objectMapper.writeValueAsString(exceptionResponse);

        String expectedJsonString = "{\"timestamp\":\"" + timestamp.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")) + "\",\"message\":\"" + message + "\"}";

        Assertions.assertEquals(expectedJsonString.toLowerCase(), jsonString.toLowerCase());
    }
}

