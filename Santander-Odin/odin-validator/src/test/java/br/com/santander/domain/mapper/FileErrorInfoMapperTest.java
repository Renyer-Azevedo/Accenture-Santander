package br.com.santander.domain.mapper;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.response.RecordErrorResponse;
import br.com.santander.domain.vo.FileErrorInfoVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileErrorInfoMapperTest {

    private FileErrorInfoMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(FileErrorInfoMapper.class);
    }

    @Test
    void testDtoToEntity() {
        FileErrorInfoDto dto = FileErrorInfoDto.builder()
                .fileName("file.txt")
                .line(10)
                .col(5)
                .errorMessage("Error message")
                .timestamp(Instant.now())
                .build();

        FileErrorInfo entity = mapper.dtoToEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getFileName(), entity.getFileName());
        assertEquals(dto.getLine(), entity.getLine());
        assertEquals(dto.getCol(), entity.getCol());
        assertEquals(dto.getErrorMessage(), entity.getErrorMessage());
        assertEquals(dto.getTimestamp(), entity.getTimestamp());
    }

    @Test
    void testListEntityToListVo() {
        FileErrorInfo fileErrorInfo1 = FileErrorInfo.builder()
                .fileName("file1.txt")
                .line(10)
                .col(5)
                .errorMessage("Error message 1")
                .timestamp(Instant.now())
                .build();
        FileErrorInfo fileErrorInfo2 = FileErrorInfo.builder()
                .fileName("file2.txt")
                .line(20)
                .col(10)
                .errorMessage("Error message 2")
                .timestamp(Instant.now())
                .build();

        List<FileErrorInfo> fileErrorInfos = Arrays.asList(fileErrorInfo1, fileErrorInfo2);

        List<FileErrorInfoVo> fileErrorInfoVos = mapper.listEntityToListVo(fileErrorInfos);

        assertNotNull(fileErrorInfoVos);
        assertEquals(fileErrorInfos.size(), fileErrorInfoVos.size());

        FileErrorInfoVo vo1 = fileErrorInfoVos.get(0);
        assertEquals(fileErrorInfo1.getFileName(), vo1.getFileName());
        assertEquals(fileErrorInfo1.getLine(), vo1.getLine());
        assertEquals(fileErrorInfo1.getCol(), vo1.getCol());
        assertEquals(fileErrorInfo1.getErrorMessage(), vo1.getErrorMessage());
        assertEquals(fileErrorInfo1.getTimestamp(), vo1.getTimestamp());

        FileErrorInfoVo vo2 = fileErrorInfoVos.get(1);
        assertEquals(fileErrorInfo2.getFileName(), vo2.getFileName());
        assertEquals(fileErrorInfo2.getLine(), vo2.getLine());
        assertEquals(fileErrorInfo2.getCol(), vo2.getCol());
        assertEquals(fileErrorInfo2.getErrorMessage(), vo2.getErrorMessage());
        assertEquals(fileErrorInfo2.getTimestamp(), vo2.getTimestamp());
    }

    @Test
    void testFileErrorInfoVoToRecordErrorResponse() {
        FileErrorInfoVo fileErrorInfoVo1 = FileErrorInfoVo.builder()
                .fileName("file1.txt")
                .line(10)
                .col(5)
                .errorMessage("Error message 1")
                .timestamp(Instant.now())
                .build();
        FileErrorInfoVo fileErrorInfoVo2 = FileErrorInfoVo.builder()
                .fileName("file2.txt")
                .line(20)
                .col(10)
                .errorMessage("Error message 2")
                .timestamp(Instant.now())
                .build();

        List<FileErrorInfoVo> fileErrorInfoVos = Arrays.asList(fileErrorInfoVo1, fileErrorInfoVo2);

        List<RecordErrorResponse> recordErrorResponses = mapper.fileErrorInfoVoToRecordErrorResponse(fileErrorInfoVos);

        assertNotNull(recordErrorResponses);
        assertEquals(fileErrorInfoVos.size(), recordErrorResponses.size());

        RecordErrorResponse response1 = recordErrorResponses.get(0);
        assertEquals(fileErrorInfoVo1.getFileName(), response1.getFileName());
        assertEquals(fileErrorInfoVo1.getLine(), response1.getLine());
        assertEquals(fileErrorInfoVo1.getCol(), response1.getCol());
        assertEquals(fileErrorInfoVo1.getErrorMessage(), response1.getErrorMessage());
        assertEquals(fileErrorInfoVo1.getTimestamp(), response1.getTimestamp());

        RecordErrorResponse response2 = recordErrorResponses.get(1);
        assertEquals(fileErrorInfoVo2.getFileName(), response2.getFileName());
        assertEquals(fileErrorInfoVo2.getLine(), response2.getLine());
        assertEquals(fileErrorInfoVo2.getCol(), response2.getCol());
        assertEquals(fileErrorInfoVo2.getErrorMessage(), response2.getErrorMessage());
        assertEquals(fileErrorInfoVo2.getTimestamp(), response2.getTimestamp());
    }
}

