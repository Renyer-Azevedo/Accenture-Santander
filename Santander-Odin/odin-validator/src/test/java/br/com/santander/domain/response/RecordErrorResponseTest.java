package br.com.santander.domain.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class RecordErrorResponseTest {

    private ObjectMapper objectMapper;
    private String fileName;
    private int line;
    private int col;
    private String errorMessage;
    private Instant timestamp;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        fileName = "test_file.txt";
        line = 10;
        col = 5;
        errorMessage = "Test error message";
        timestamp = Instant.now();
    }

    @Test
    void testRecordErrorResponseToString() {
        RecordErrorResponse recordErrorResponse = new RecordErrorResponse(fileName, line, col, errorMessage, timestamp);
        String jsonString = recordErrorResponse.toString();

        String expectedJsonString = "RecordErrorResponse(fileName=" + fileName + ", line=" + line + ", col=" + col + ", errorMessage=" + errorMessage + ", timestamp=" + timestamp.toString() + ")";

        Assertions.assertEquals(expectedJsonString, jsonString);
    }

    @Test
    void testRecordErrorResponseEquals() {
        RecordErrorResponse recordErrorResponse1 = new RecordErrorResponse(fileName, line, col, errorMessage, timestamp);
        RecordErrorResponse recordErrorResponse2 = new RecordErrorResponse(fileName, line, col, errorMessage, timestamp);

        Assertions.assertEquals(recordErrorResponse1, recordErrorResponse2);
    }

    @Test
    void testRecordErrorResponseGettersAndSetters() {
        RecordErrorResponse recordErrorResponse = new RecordErrorResponse();
        recordErrorResponse.setFileName(fileName);
        recordErrorResponse.setLine(line);
        recordErrorResponse.setCol(col);
        recordErrorResponse.setErrorMessage(errorMessage);
        recordErrorResponse.setTimestamp(timestamp);

        Assertions.assertEquals(fileName, recordErrorResponse.getFileName());
        Assertions.assertEquals(line, recordErrorResponse.getLine());
        Assertions.assertEquals(col, recordErrorResponse.getCol());
        Assertions.assertEquals(errorMessage, recordErrorResponse.getErrorMessage());
        Assertions.assertEquals(timestamp, recordErrorResponse.getTimestamp());
    }

    @Test
    void testRecordErrorResponseAllArgsConstructor() {
        RecordErrorResponse recordErrorResponse = new RecordErrorResponse(fileName, line, col, errorMessage, timestamp);

        Assertions.assertEquals(fileName, recordErrorResponse.getFileName());
        Assertions.assertEquals(line, recordErrorResponse.getLine());
        Assertions.assertEquals(col, recordErrorResponse.getCol());
        Assertions.assertEquals(errorMessage, recordErrorResponse.getErrorMessage());
        Assertions.assertEquals(timestamp, recordErrorResponse.getTimestamp());
    }

    @Test
    void testRecordErrorResponseNoArgsConstructor() {
        RecordErrorResponse recordErrorResponse = new RecordErrorResponse();

        Assertions.assertNull(recordErrorResponse.getFileName());
        Assertions.assertEquals(0, recordErrorResponse.getLine());
        Assertions.assertEquals(0, recordErrorResponse.getCol());
        Assertions.assertNull(recordErrorResponse.getErrorMessage());
        Assertions.assertNull(recordErrorResponse.getTimestamp());
    }

    @Test
    void testRecordErrorResponseSerialization() throws JsonProcessingException {
        RecordErrorResponse recordErrorResponse = new RecordErrorResponse(fileName, line, col, errorMessage, timestamp);

        String jsonString = objectMapper.writeValueAsString(recordErrorResponse);

        String expectedJsonString = "{\"fileName\":\"" + fileName + "\",\"line\":" + line + ",\"col\":" + col + ",\"errorMessage\":\"" + errorMessage + "\",\"timestamp\":\"" + timestamp + "\"}";

        Assertions.assertEquals(expectedJsonString, jsonString);
    }
}
