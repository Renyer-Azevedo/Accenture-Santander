package br.com.santander.domain.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class RecordResponseTest {
    private List<RecordSuccessResponse> recordSuccessResponses;
    private List<RecordErrorResponse> recordErrorResponses;
    private ObjectMapper objectMapper;
    private Instant timestamp;

    @BeforeEach
    void setUp() {

        timestamp = Instant.now();

        recordSuccessResponses = new ArrayList<>();
        recordSuccessResponses.add(new RecordSuccessResponse("John", 25, "Male", "john@example.com", "1234567890", "123 Main St", "New York", "NY", "12345", "Engineer"));

        recordErrorResponses = new ArrayList<>();
        recordErrorResponses.add(new RecordErrorResponse("test.txt", 10, 5, "Test error message", timestamp));

        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


    }

    @Test
    void testRecordResponseEqualsAndHashCode() {
        RecordResponse recordResponse1 = new RecordResponse(recordSuccessResponses, recordErrorResponses);
        RecordResponse recordResponse2 = new RecordResponse(recordSuccessResponses, recordErrorResponses);

        Assertions.assertEquals(recordResponse1, recordResponse2);
        Assertions.assertEquals(recordResponse1.hashCode(), recordResponse2.hashCode());
    }

    @Test
    void testRecordResponseNoArgsConstructor() {
        RecordResponse recordResponse = new RecordResponse();

        Assertions.assertNull(recordResponse.getRecordSuccessResponses());
        Assertions.assertNull(recordResponse.getRecordErrorResponses());
    }

    @Test
    void testRecordResponseToString() {
        RecordResponse recordResponse = new RecordResponse(recordSuccessResponses, recordErrorResponses);

        String expectedToString = "RecordResponse(recordSuccessResponses=[RecordSuccessResponse(name=John, age=25, gender=Male, email=john@example.com, phone=1234567890, address=123 Main St, city=New York, state=NY, zipCode=12345, profession=Engineer)], recordErrorResponses=[RecordErrorResponse(fileName=test.txt, line=10, col=5, errorMessage=Test error message, timestamp=" + timestamp + ")])";

        Assertions.assertEquals(expectedToString, recordResponse.toString());
    }

    @Test
    void testRecordResponseGettersAndSetters() {
        RecordResponse recordResponse = new RecordResponse();

        recordResponse.setRecordSuccessResponses(recordSuccessResponses);
        recordResponse.setRecordErrorResponses(recordErrorResponses);

        Assertions.assertEquals(recordSuccessResponses, recordResponse.getRecordSuccessResponses());
        Assertions.assertEquals(recordErrorResponses, recordResponse.getRecordErrorResponses());
    }

    @Test
    void testRecordResponseAllArgsConstructor() {
        RecordResponse recordResponse = new RecordResponse(recordSuccessResponses, recordErrorResponses);

        Assertions.assertEquals(recordSuccessResponses, recordResponse.getRecordSuccessResponses());
        Assertions.assertEquals(recordErrorResponses, recordResponse.getRecordErrorResponses());
    }

    @Test
    void testRecordResponseEquals() {
        RecordResponse recordResponse1 = new RecordResponse(recordSuccessResponses, recordErrorResponses);
        RecordResponse recordResponse2 = new RecordResponse(recordSuccessResponses, recordErrorResponses);

        Assertions.assertEquals(recordResponse1, recordResponse2);
    }

    @Test
    void testRecordResponseSerialization() throws JsonProcessingException {
        RecordSuccessResponse successResponse = new RecordSuccessResponse("John", 30, "Male",
                "john@example.com", "1234567890", "123 Main St", "New York", "NY",
                "12345", "Engineer");

        RecordErrorResponse errorResponse = new RecordErrorResponse("example.txt", 10, 5,
                "Invalid format", timestamp);

        List<RecordSuccessResponse> successResponses = new ArrayList<>();
        successResponses.add(successResponse);

        List<RecordErrorResponse> errorResponses = new ArrayList<>();
        errorResponses.add(errorResponse);

        RecordResponse recordResponse = new RecordResponse(successResponses, errorResponses);

        String jsonString = objectMapper.writeValueAsString(recordResponse);

        String expectedJsonString = "{\"recordSuccess\":[{\"name\":\"John\",\"age\":30,\"gender\":\"Male\",\"email\":\"john@example.com\",\"phone\":\"1234567890\",\"address\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zipCode\":\"12345\",\"profession\":\"Engineer\"}],\"recordError\":[{\"fileName\":\"example.txt\",\"line\":10,\"col\":5,\"errorMessage\":\"Invalid format\",\"timestamp\":\"" + timestamp + "\"}]}";

        Assertions.assertEquals(expectedJsonString, jsonString);
    }

    @Test
    void testRecordResponseDeserialization() throws JsonProcessingException {
        String jsonString = "{\"recordSuccess\":[{\"name\":\"John\",\"age\":30,\"gender\":\"Male\",\"email\":\"john@example.com\",\"phone\":\"1234567890\",\"address\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zipCode\":\"12345\",\"profession\":\"Engineer\"}],\"recordError\":[{\"fileName\":\"example.txt\",\"line\":10,\"col\":5,\"errorMessage\":\"Invalid format\",\"timestamp\":\"" + timestamp + "\"}]}";

        RecordResponse expectedRecordResponse = new RecordResponse();
        RecordSuccessResponse successResponse = new RecordSuccessResponse("John", 30, "Male",
                "john@example.com", "1234567890", "123 Main St", "New York", "NY",
                "12345", "Engineer");

        RecordErrorResponse errorResponse = new RecordErrorResponse("example.txt", 10, 5,
                "Invalid format", timestamp);

        List<RecordSuccessResponse> successResponses = new ArrayList<>();
        successResponses.add(successResponse);

        List<RecordErrorResponse> errorResponses = new ArrayList<>();
        errorResponses.add(errorResponse);

        expectedRecordResponse.setRecordSuccessResponses(successResponses);
        expectedRecordResponse.setRecordErrorResponses(errorResponses);

        RecordResponse actualRecordResponse = objectMapper.readValue(jsonString, RecordResponse.class);

        Assertions.assertEquals(expectedRecordResponse, actualRecordResponse);
    }

}

