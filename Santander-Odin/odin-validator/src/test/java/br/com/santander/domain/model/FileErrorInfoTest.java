package br.com.santander.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class FileErrorInfoTest {

    private Long id;
    private String fileName;
    private int line;
    private int col;
    private String errorMessage;
    private Instant timestamp;

    @BeforeEach
    void setUp() {
        id = 1L;
        fileName = "file.txt";
        line = 10;
        col = 5;
        errorMessage = "Invalid data";
        timestamp = Instant.now();
    }
    @Test
    void testFileErrorInfoToString() {

        FileErrorInfo fileErrorInfo = new FileErrorInfo(id, fileName, line, col, errorMessage, timestamp);

        String expectedToString = "FileErrorInfo(id=1, fileName=file.txt, line=10, col=5, errorMessage=Invalid data, timestamp=" + timestamp.toString() + ")";
        Assertions.assertEquals(expectedToString, fileErrorInfo.toString());
    }

    @Test
    void testFileErrorInfoEqualsAndHashCode() {

        FileErrorInfo fileErrorInfo1 = new FileErrorInfo(id, fileName, line, col, errorMessage, timestamp);
        FileErrorInfo fileErrorInfo2 = new FileErrorInfo(id, fileName, line, col, errorMessage, timestamp);

        Assertions.assertEquals(fileErrorInfo1, fileErrorInfo2);

        Assertions.assertEquals(fileErrorInfo1.hashCode(), fileErrorInfo2.hashCode());
    }

    @Test
    void testFileErrorInfoBuilder() {

        FileErrorInfo fileErrorInfo = FileErrorInfo.builder()
                .id(id)
                .fileName(fileName)
                .line(line)
                .col(col)
                .errorMessage(errorMessage)
                .timestamp(timestamp)
                .build();

        Assertions.assertEquals(id, fileErrorInfo.getId());
        Assertions.assertEquals(fileName, fileErrorInfo.getFileName());
        Assertions.assertEquals(line, fileErrorInfo.getLine());
        Assertions.assertEquals(col, fileErrorInfo.getCol());
        Assertions.assertEquals(errorMessage, fileErrorInfo.getErrorMessage());
        Assertions.assertEquals(timestamp, fileErrorInfo.getTimestamp());
    }

    @Test
    void testFileErrorInfoGettersAndSetters() {

        FileErrorInfo fileErrorInfo = new FileErrorInfo();

        fileErrorInfo.setId(id);
        fileErrorInfo.setFileName(fileName);
        fileErrorInfo.setLine(line);
        fileErrorInfo.setCol(col);
        fileErrorInfo.setErrorMessage(errorMessage);
        fileErrorInfo.setTimestamp(timestamp);

        Assertions.assertEquals(id, fileErrorInfo.getId());
        Assertions.assertEquals(fileName, fileErrorInfo.getFileName());
        Assertions.assertEquals(line, fileErrorInfo.getLine());
        Assertions.assertEquals(col, fileErrorInfo.getCol());
        Assertions.assertEquals(errorMessage, fileErrorInfo.getErrorMessage());
        Assertions.assertEquals(timestamp, fileErrorInfo.getTimestamp());
    }

    @Test
    void testFileErrorInfoConstructorWithAllFields() {

        FileErrorInfo fileErrorInfo = new FileErrorInfo(id, fileName, line, col, errorMessage, timestamp);

        Assertions.assertEquals(id, fileErrorInfo.getId());
        Assertions.assertEquals(fileName, fileErrorInfo.getFileName());
        Assertions.assertEquals(line, fileErrorInfo.getLine());
        Assertions.assertEquals(col, fileErrorInfo.getCol());
        Assertions.assertEquals(errorMessage, fileErrorInfo.getErrorMessage());
        Assertions.assertEquals(timestamp, fileErrorInfo.getTimestamp());
    }

    @Test
    void testFileErrorInfoConstructorWithNoFields() {

        FileErrorInfo fileErrorInfo = new FileErrorInfo();

        Assertions.assertNull(fileErrorInfo.getId());
        Assertions.assertNull(fileErrorInfo.getFileName());
        Assertions.assertEquals(0, fileErrorInfo.getLine());
        Assertions.assertEquals(0, fileErrorInfo.getCol());
        Assertions.assertNull(fileErrorInfo.getErrorMessage());
        Assertions.assertNull(fileErrorInfo.getTimestamp());
    }
}

