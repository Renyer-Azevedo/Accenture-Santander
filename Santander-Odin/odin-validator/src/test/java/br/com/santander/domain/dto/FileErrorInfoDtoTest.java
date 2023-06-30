package br.com.santander.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class FileErrorInfoDtoTest {
    private String fileName;
    private int line;
    private int col;
    private String errorMessage;
    private Instant timestamp;

    @BeforeEach
    void setUp() {
        fileName = "example.txt";
        line = 10;
        col = 5;
        errorMessage = "Error message";
        timestamp = Instant.now();
    }

    @Test
    void testFileErrorInfoDto() {

        FileErrorInfoDto fileErrorInfoDto = FileErrorInfoDto.builder()
                .fileName(fileName)
                .line(line)
                .col(col)
                .errorMessage(errorMessage)
                .timestamp(timestamp)
                .build();

        assertEquals(fileName, fileErrorInfoDto.getFileName());
        assertEquals(line, fileErrorInfoDto.getLine());
        assertEquals(col, fileErrorInfoDto.getCol());
        assertEquals(errorMessage, fileErrorInfoDto.getErrorMessage());
        assertEquals(timestamp, fileErrorInfoDto.getTimestamp());
    }

    @Test
    void testSettersAndGetters() {

        FileErrorInfoDto fileErrorInfoDto = new FileErrorInfoDto();


        fileErrorInfoDto.setFileName(fileName);
        fileErrorInfoDto.setLine(line);
        fileErrorInfoDto.setCol(col);
        fileErrorInfoDto.setErrorMessage(errorMessage);
        fileErrorInfoDto.setTimestamp(timestamp);


        assertEquals(fileName, fileErrorInfoDto.getFileName());
        assertEquals(line, fileErrorInfoDto.getLine());
        assertEquals(col, fileErrorInfoDto.getCol());
        assertEquals(errorMessage, fileErrorInfoDto.getErrorMessage());
        assertEquals(timestamp, fileErrorInfoDto.getTimestamp());
    }

    @Test
    void testConstructorWithAllFields() {

        FileErrorInfoDto fileErrorInfoDto = new FileErrorInfoDto(fileName, line, col, errorMessage, timestamp);


        assertEquals(fileName, fileErrorInfoDto.getFileName());
        assertEquals(line, fileErrorInfoDto.getLine());
        assertEquals(col, fileErrorInfoDto.getCol());
        assertEquals(errorMessage, fileErrorInfoDto.getErrorMessage());
        assertEquals(timestamp, fileErrorInfoDto.getTimestamp());
    }

    @Test
    void testDefaultConstructor() {

        FileErrorInfoDto fileErrorInfoDto = new FileErrorInfoDto();


        assertNull(fileErrorInfoDto.getFileName());
        assertEquals(0, fileErrorInfoDto.getLine());
        assertEquals(0, fileErrorInfoDto.getCol());
        assertNull(fileErrorInfoDto.getErrorMessage());
        assertNull(fileErrorInfoDto.getTimestamp());
    }

    @Test
    void testToString() {

        FileErrorInfoDto fileErrorInfoDto = FileErrorInfoDto.builder()
                .fileName(fileName)
                .line(line)
                .col(col)
                .errorMessage(errorMessage)
                .timestamp(timestamp)
                .build();


        String expectedToString = "FileErrorInfoDto(fileName=example.txt, line=10, col=5, errorMessage=Error message, timestamp=" + timestamp.toString() + ")";
        assertEquals(expectedToString, fileErrorInfoDto.toString());
    }

    @Test
    void testEquals() {

        String fileName1 = "example.txt";
        int line1 = 10;
        int col1 = 5;
        String errorMessage1 = "Error message";
        Instant timestamp1 = Instant.now();

        String fileName2 = "example.txt";
        int line2 = 10;
        int col2 = 5;
        String errorMessage2 = "Error message";
        Instant timestamp2 = Instant.now();

        String fileName3 = "other.txt";
        int line3 = 20;
        int col3 = 8;
        String errorMessage3 = "Other error message";
        Instant timestamp3 = Instant.now();


        FileErrorInfoDto fileErrorInfoDto1 = new FileErrorInfoDto(fileName1, line1, col1, errorMessage1, timestamp1);
        FileErrorInfoDto fileErrorInfoDto2 = new FileErrorInfoDto(fileName2, line2, col2, errorMessage2, timestamp2);
        FileErrorInfoDto fileErrorInfoDto3 = new FileErrorInfoDto(fileName3, line3, col3, errorMessage3, timestamp3);


        assertEquals(fileErrorInfoDto1, fileErrorInfoDto2);
        assertNotEquals(fileErrorInfoDto1, fileErrorInfoDto3);
    }

}
