package br.com.santander.domain.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordSuccessResponseTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        objectMapper.registerModule(module);
    }

    @Test
    void testRecordSuccessResponseToString() {
        RecordSuccessResponse successResponse = new RecordSuccessResponse();
        successResponse.setName("John");
        successResponse.setAge(30);
        successResponse.setGender("Male");
        successResponse.setEmail("john@example.com");
        successResponse.setPhone("1234567890");
        successResponse.setAddress("123 Main St");
        successResponse.setCity("New York");
        successResponse.setState("NY");
        successResponse.setZipCode("12345");
        successResponse.setProfession("Engineer");

        String jsonString = successResponse.toString();

        String expectedJsonString = "RecordSuccessResponse(name=John, age=30, gender=Male, email=john@example.com, phone=1234567890, address=123 Main St, city=New York, state=NY, zipCode=12345, profession=Engineer)";

        Assertions.assertEquals(expectedJsonString, jsonString);
    }

    @Test
    void testRecordSuccessResponseSerialization() throws JsonProcessingException {
        RecordSuccessResponse successResponse = new RecordSuccessResponse();
        successResponse.setName("John");
        successResponse.setAge(30);
        successResponse.setGender("Male");
        successResponse.setEmail("john@example.com");
        successResponse.setPhone("1234567890");
        successResponse.setAddress("123 Main St");
        successResponse.setCity("New York");
        successResponse.setState("NY");
        successResponse.setZipCode("12345");
        successResponse.setProfession("Engineer");

        String jsonString = objectMapper.writeValueAsString(successResponse);

        String expectedJsonString = "{\"name\":\"John\",\"age\":30,\"gender\":\"Male\",\"email\":\"john@example.com\",\"phone\":\"1234567890\",\"address\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zipCode\":\"12345\",\"profession\":\"Engineer\"}";

        Assertions.assertEquals(expectedJsonString, jsonString);
    }

    @Test
    void testRecordSuccessResponseDeserialization() throws IOException {
        String jsonString = "{\"name\":\"John\",\"age\":30,\"gender\":\"Male\",\"email\":\"john@example.com\",\"phone\":\"1234567890\",\"address\":\"123 Main St\",\"city\":\"New York\",\"state\":\"NY\",\"zipCode\":\"12345\",\"profession\":\"Engineer\"}";

        RecordSuccessResponse successResponse = objectMapper.readValue(jsonString, RecordSuccessResponse.class);

        Assertions.assertEquals("John", successResponse.getName());
        Assertions.assertEquals(30, successResponse.getAge());
        Assertions.assertEquals("Male", successResponse.getGender());
        Assertions.assertEquals("john@example.com", successResponse.getEmail());
        Assertions.assertEquals("1234567890", successResponse.getPhone());
        Assertions.assertEquals("123 Main St", successResponse.getAddress());
        Assertions.assertEquals("New York", successResponse.getCity());
        Assertions.assertEquals("NY", successResponse.getState());
        Assertions.assertEquals("12345", successResponse.getZipCode());
        Assertions.assertEquals("Engineer", successResponse.getProfession());
    }

    @Test
    void testRecordSuccessResponseEqualsAndHashCode() {
        RecordSuccessResponse successResponse1 = new RecordSuccessResponse("John", 30, "Male",
                "john@example.com", "1234567890", "123 Main St", "New York", "NY",
                "12345", "Engineer");
        RecordSuccessResponse successResponse2 = new RecordSuccessResponse("John", 30, "Male",
                "john@example.com", "1234567890", "123 Main St", "New York", "NY",
                "12345", "Engineer");

        Assertions.assertEquals(successResponse1, successResponse2);
        Assertions.assertEquals(successResponse1.hashCode(), successResponse2.hashCode());
    }

    @Test
    void testRecordSuccessResponseSettersAndGetters() {
        RecordSuccessResponse successResponse = new RecordSuccessResponse();

        successResponse.setName("John");
        successResponse.setAge(30);
        successResponse.setGender("Male");
        successResponse.setEmail("john@example.com");
        successResponse.setPhone("1234567890");
        successResponse.setAddress("123 Main St");
        successResponse.setCity("New York");
        successResponse.setState("NY");
        successResponse.setZipCode("12345");
        successResponse.setProfession("Engineer");

        Assertions.assertEquals("John", successResponse.getName());
        Assertions.assertEquals(30, successResponse.getAge());
        Assertions.assertEquals("Male", successResponse.getGender());
        Assertions.assertEquals("john@example.com", successResponse.getEmail());
        Assertions.assertEquals("1234567890", successResponse.getPhone());
        Assertions.assertEquals("123 Main St", successResponse.getAddress());
        Assertions.assertEquals("New York", successResponse.getCity());
        Assertions.assertEquals("NY", successResponse.getState());
        Assertions.assertEquals("12345", successResponse.getZipCode());
        Assertions.assertEquals("Engineer", successResponse.getProfession());
    }

    @Test
    void testRecordSuccessResponseNoArgsConstructor() {
        RecordSuccessResponse successResponse = new RecordSuccessResponse();

        Assertions.assertNull(successResponse.getName());
        Assertions.assertNull(successResponse.getAge());
        Assertions.assertNull(successResponse.getGender());
        Assertions.assertNull(successResponse.getEmail());
        Assertions.assertNull(successResponse.getPhone());
        Assertions.assertNull(successResponse.getAddress());
        Assertions.assertNull(successResponse.getCity());
        Assertions.assertNull(successResponse.getState());
        Assertions.assertNull(successResponse.getZipCode());
        Assertions.assertNull(successResponse.getProfession());
    }

    @Test
    void testRecordSuccessResponseAllArgsConstructor() {
        RecordSuccessResponse successResponse = new RecordSuccessResponse("John", 30, "Male",
                "john@example.com", "1234567890", "123 Main St", "New York", "NY",
                "12345", "Engineer");

        Assertions.assertEquals("John", successResponse.getName());
        Assertions.assertEquals(30, successResponse.getAge());
        Assertions.assertEquals("Male", successResponse.getGender());
        Assertions.assertEquals("john@example.com", successResponse.getEmail());
        Assertions.assertEquals("1234567890", successResponse.getPhone());
        Assertions.assertEquals("123 Main St", successResponse.getAddress());
        Assertions.assertEquals("New York", successResponse.getCity());
        Assertions.assertEquals("NY", successResponse.getState());
        Assertions.assertEquals("12345", successResponse.getZipCode());
        Assertions.assertEquals("Engineer", successResponse.getProfession());
    }
}
