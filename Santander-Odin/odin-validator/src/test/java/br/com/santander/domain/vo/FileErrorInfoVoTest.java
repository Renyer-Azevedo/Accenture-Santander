package br.com.santander.domain.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class FileErrorInfoVoTest {
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
    void testFileErrorInfoVo() {

        FileErrorInfoVo fileErrorInfoVo = FileErrorInfoVo.builder()
                .fileName(fileName)
                .line(line)
                .col(col)
                .errorMessage(errorMessage)
                .timestamp(timestamp)
                .build();

        assertEquals(fileName, fileErrorInfoVo.getFileName());
        assertEquals(line, fileErrorInfoVo.getLine());
        assertEquals(col, fileErrorInfoVo.getCol());
        assertEquals(errorMessage, fileErrorInfoVo.getErrorMessage());
        assertEquals(timestamp, fileErrorInfoVo.getTimestamp());
    }

    @Test
    void testSettersAndGetters() {

        FileErrorInfoVo fileErrorInfoVo = new FileErrorInfoVo();


        fileErrorInfoVo.setFileName(fileName);
        fileErrorInfoVo.setLine(line);
        fileErrorInfoVo.setCol(col);
        fileErrorInfoVo.setErrorMessage(errorMessage);
        fileErrorInfoVo.setTimestamp(timestamp);


        assertEquals(fileName, fileErrorInfoVo.getFileName());
        assertEquals(line, fileErrorInfoVo.getLine());
        assertEquals(col, fileErrorInfoVo.getCol());
        assertEquals(errorMessage, fileErrorInfoVo.getErrorMessage());
        assertEquals(timestamp, fileErrorInfoVo.getTimestamp());
    }

    @Test
    void testConstructorWithAllFields() {

        FileErrorInfoVo fileErrorInfoVo = new FileErrorInfoVo(fileName, line, col, errorMessage, timestamp);


        assertEquals(fileName, fileErrorInfoVo.getFileName());
        assertEquals(line, fileErrorInfoVo.getLine());
        assertEquals(col, fileErrorInfoVo.getCol());
        assertEquals(errorMessage, fileErrorInfoVo.getErrorMessage());
        assertEquals(timestamp, fileErrorInfoVo.getTimestamp());
    }

    @Test
    void testDefaultConstructor() {

        FileErrorInfoVo fileErrorInfoVo = new FileErrorInfoVo();


        assertNull(fileErrorInfoVo.getFileName());
        assertEquals(0, fileErrorInfoVo.getLine());
        assertEquals(0, fileErrorInfoVo.getCol());
        assertNull(fileErrorInfoVo.getErrorMessage());
        assertNull(fileErrorInfoVo.getTimestamp());
    }

    @Test
    void testToString() {

        FileErrorInfoVo fileErrorInfoVo = FileErrorInfoVo.builder()
                .fileName(fileName)
                .line(line)
                .col(col)
                .errorMessage(errorMessage)
                .timestamp(timestamp)
                .build();


        String expecteVoString = "FileErrorInfoVo(fileName=example.txt, line=10, col=5, errorMessage=Error message, timestamp=" + timestamp.toString() + ")";
        assertEquals(expecteVoString, fileErrorInfoVo.toString());
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


        FileErrorInfoVo fileErrorInfoVo1 = new FileErrorInfoVo(fileName1, line1, col1, errorMessage1, timestamp1);
        FileErrorInfoVo fileErrorInfoVo2 = new FileErrorInfoVo(fileName2, line2, col2, errorMessage2, timestamp2);
        FileErrorInfoVo fileErrorInfoVo3 = new FileErrorInfoVo(fileName3, line3, col3, errorMessage3, timestamp3);


        assertEquals(fileErrorInfoVo1, fileErrorInfoVo2);
        assertNotEquals(fileErrorInfoVo1, fileErrorInfoVo3);
    }

}
