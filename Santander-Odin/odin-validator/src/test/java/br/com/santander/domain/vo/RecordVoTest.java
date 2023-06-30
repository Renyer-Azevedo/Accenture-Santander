package br.com.santander.domain.vo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class RecordVoTest {
    private List<FileSuccessInfoVo> successInfoVos1;
    private List<FileSuccessInfoVo> successInfoVos2;
    private List<FileErrorInfoVo> errorInfoVos1;
    private List<FileErrorInfoVo> errorInfoVos2;

    @BeforeEach
    void setUp() {

        Instant timezone = Instant.now();

        FileSuccessInfoVo successInfoVo1 = FileSuccessInfoVo.builder()
                .name("John")
                .age(30)
                .gender("Male")
                .email("john@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfoVo successInfoVo2 = FileSuccessInfoVo.builder()
                .name("John")
                .age(30)
                .gender("Male")
                .email("john@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileErrorInfoVo errorInfoVo1 = FileErrorInfoVo.builder()
                .fileName("example.txt")
                .line(10)
                .col(5)
                .errorMessage("Invalid format")
                .timestamp(timezone)
                .build();

        FileErrorInfoVo errorInfoVo2 = FileErrorInfoVo.builder()
                .fileName("example.txt")
                .line(10)
                .col(5)
                .errorMessage("Invalid format")
                .timestamp(timezone)
                .build();

        successInfoVos1 = new ArrayList<>();
        successInfoVos1.add(successInfoVo1);

        successInfoVos2 = new ArrayList<>();
        successInfoVos2.add(successInfoVo2);

        errorInfoVos1 = new ArrayList<>();
        errorInfoVos1.add(errorInfoVo1);

        errorInfoVos2 = new ArrayList<>();
        errorInfoVos2.add(errorInfoVo2);
    }

    @Test
    void testEqualsAndHashCode() {
        RecordVo recordVo1 = new RecordVo(successInfoVos1, errorInfoVos1);
        RecordVo recordVo2 = new RecordVo(successInfoVos2, errorInfoVos2);

        Assertions.assertEquals(recordVo1, recordVo2);
        Assertions.assertEquals(recordVo1.hashCode(), recordVo2.hashCode());
    }

    @Test
    void testSettersAndGetters() {
        RecordVo recordVo = new RecordVo();
        recordVo.setFileSuccessInfoVos(successInfoVos1);
        recordVo.setFileErrorInfoVos(errorInfoVos1);

        Assertions.assertEquals(successInfoVos1, recordVo.getFileSuccessInfoVos());
        Assertions.assertEquals(errorInfoVos1, recordVo.getFileErrorInfoVos());
    }

    @Test
    void testBuilder() {
        RecordVo recordVo = RecordVo.builder()
                .fileSuccessInfoVos(successInfoVos1)
                .fileErrorInfoVos(errorInfoVos1)
                .build();

        Assertions.assertEquals(successInfoVos1, recordVo.getFileSuccessInfoVos());
        Assertions.assertEquals(errorInfoVos1, recordVo.getFileErrorInfoVos());
    }

    @Test
    void testNoArgsConstructor() {
        RecordVo recordVo = new RecordVo();
        Assertions.assertNull(recordVo.getFileSuccessInfoVos());
        Assertions.assertNull(recordVo.getFileErrorInfoVos());
    }

    @Test
    void testAllArgsConstructor() {
        RecordVo recordVo = new RecordVo(successInfoVos1, errorInfoVos1);

        Assertions.assertEquals(successInfoVos1, recordVo.getFileSuccessInfoVos());
        Assertions.assertEquals(errorInfoVos1, recordVo.getFileErrorInfoVos());
    }

    @Test
    void testToString() {
        RecordVo recordVo = new RecordVo(successInfoVos1, errorInfoVos1);

        String expectedString = "RecordVo(fileSuccessInfoVos=" + successInfoVos1 + ", fileErrorInfoVos=" + errorInfoVos1 + ")";
        Assertions.assertEquals(expectedString, recordVo.toString());
    }
}

