package br.com.santander.domain.mapper;

import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.domain.response.RecordErrorResponse;
import br.com.santander.domain.response.RecordResponse;
import br.com.santander.domain.response.RecordSuccessResponse;
import br.com.santander.domain.vo.FileErrorInfoVo;
import br.com.santander.domain.vo.FileSuccessInfoVo;
import br.com.santander.domain.vo.RecordVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class RecordMapperTest {

    @Mock
    private FileSuccessInfoMapper fileSuccessInfoMapper;

    @Mock
    private FileErrorInfoMapper fileErrorInfoMapper;

    @InjectMocks
    private RecordMapperImpl mapper;

    @Test
    void testConvertToRecord() {

        FileSuccessInfo fileSuccessInfo1 = FileSuccessInfo.builder()
                .name("John Doe")
                .age(30)
                .gender("Male")
                .email("johndoe@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfo fileSuccessInfo2 = FileSuccessInfo.builder()
                .name("Jane Smith")
                .age(25)
                .gender("Female")
                .email("janesmith@example.com")
                .phone("9876543210")
                .address("456 Elm St")
                .city("San Francisco")
                .state("CA")
                .zipCode("54321")
                .profession("Designer")
                .build();

        FileErrorInfo fileErrorInfo1 = FileErrorInfo.builder()
                .fileName("file1.txt")
                .line(10)
                .col(5)
                .errorMessage("Invalid format")
                .timestamp(Instant.now())
                .build();

        FileErrorInfo fileErrorInfo2 = FileErrorInfo.builder()
                .fileName("file2.txt")
                .line(20)
                .col(3)
                .errorMessage("Missing required field")
                .timestamp(Instant.now())
                .build();

        List<FileSuccessInfo> fileSuccessInfos = Arrays.asList(fileSuccessInfo1, fileSuccessInfo2);
        List<FileErrorInfo> fileErrorInfos = Arrays.asList(fileErrorInfo1, fileErrorInfo2);

        FileSuccessInfoVo fileSuccessInfoVo1 = FileSuccessInfoVo.builder()
                .name("John Doe")
                .age(30)
                .gender("Male")
                .email("johndoe@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfoVo fileSuccessInfoVo2 = FileSuccessInfoVo.builder()
                .name("Jane Smith")
                .age(25)
                .gender("Female")
                .email("janesmith@example.com")
                .phone("9876543210")
                .address("456 Elm St")
                .city("San Francisco")
                .state("CA")
                .zipCode("54321")
                .profession("Designer")
                .build();

        FileErrorInfoVo fileErrorInfoVo1 = FileErrorInfoVo.builder()
                .fileName("file1.txt")
                .line(10)
                .col(5)
                .errorMessage("Invalid format")
                .timestamp(Instant.now())
                .build();

        FileErrorInfoVo fileErrorInfoVo2 = FileErrorInfoVo.builder()
                .fileName("file2.txt")
                .line(20)
                .col(3)
                .errorMessage("Missing required field")
                .timestamp(Instant.now())
                .build();

        List<FileSuccessInfoVo> fileSuccessInfoVos = Arrays.asList(fileSuccessInfoVo1, fileSuccessInfoVo2);
        List<FileErrorInfoVo> fileErrorInfoVos = Arrays.asList(fileErrorInfoVo1, fileErrorInfoVo2);

        when(fileSuccessInfoMapper.listEntityToListVo(fileSuccessInfos)).thenReturn(fileSuccessInfoVos);
        when(fileErrorInfoMapper.listEntityToListVo(fileErrorInfos)).thenReturn(fileErrorInfoVos);

        RecordVo recordVo = mapper.convertToRecord(fileSuccessInfos, fileErrorInfos);

        Assertions.assertNotNull(recordVo);
        Assertions.assertEquals(fileSuccessInfoVos, recordVo.getFileSuccessInfoVos());
        Assertions.assertEquals(fileErrorInfoVos, recordVo.getFileErrorInfoVos());

        verify(fileSuccessInfoMapper, times(1)).listEntityToListVo(fileSuccessInfos);
        verify(fileErrorInfoMapper, times(1)).listEntityToListVo(fileErrorInfos);
    }

    @Test
    void testVoToResponse() {

        FileSuccessInfoVo fileSuccessInfoVo1 = FileSuccessInfoVo.builder()
                .name("John Doe")
                .age(30)
                .gender("Male")
                .email("johndoe@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfoVo fileSuccessInfoVo2 = FileSuccessInfoVo.builder()
                .name("Jane Smith")
                .age(25)
                .gender("Female")
                .email("janesmith@example.com")
                .phone("9876543210")
                .address("456 Elm St")
                .city("San Francisco")
                .state("CA")
                .zipCode("54321")
                .profession("Designer")
                .build();

        FileErrorInfoVo fileErrorInfoVo1 = FileErrorInfoVo.builder()
                .fileName("file1.txt")
                .line(10)
                .col(5)
                .errorMessage("Invalid format")
                .timestamp(Instant.now())
                .build();

        FileErrorInfoVo fileErrorInfoVo2 = FileErrorInfoVo.builder()
                .fileName("file2.txt")
                .line(20)
                .col(3)
                .errorMessage("Missing required field")
                .timestamp(Instant.now())
                .build();

        List<FileSuccessInfoVo> fileSuccessInfoVos = Arrays.asList(fileSuccessInfoVo1, fileSuccessInfoVo2);
        List<FileErrorInfoVo> fileErrorInfoVos = Arrays.asList(fileErrorInfoVo1, fileErrorInfoVo2);

        RecordVo recordVo = RecordVo.builder()
                .fileSuccessInfoVos(fileSuccessInfoVos)
                .fileErrorInfoVos(fileErrorInfoVos)
                .build();

        List<RecordSuccessResponse> recordSuccessResponses = Arrays.asList(
                new RecordSuccessResponse(
                        "John Doe",
                        30,
                        "Male",
                        "johndoe@example.com",
                        "1234567890",
                        "123 Main St",
                        "New York",
                        "NY",
                        "12345",
                        "Engineer"
                ),
                new RecordSuccessResponse(
                        "Jane Smith",
                        25,
                        "Female",
                        "janesmith@example.com",
                        "9876543210",
                        "456 Elm St",
                        "San Francisco",
                        "CA",
                        "54321",
                        "Designer"
                )
        );


        List<RecordErrorResponse> recordErrorResponses = Arrays.asList(
                new RecordErrorResponse(
                        "file1.txt",
                        10,
                        5,
                        "Invalid format",
                        Instant.now()
                ),
                new RecordErrorResponse(
                        "file2.txt",
                        20,
                        3,
                        "Missing required field",
                        Instant.now()
                )
        );


        when(fileSuccessInfoMapper.fileSuccessInfoVoToRecordSuccessResponse(fileSuccessInfoVos)).thenReturn(recordSuccessResponses);
        when(fileErrorInfoMapper.fileErrorInfoVoToRecordErrorResponse(fileErrorInfoVos)).thenReturn(recordErrorResponses);

        RecordResponse recordResponse = mapper.voToResponse(recordVo);

        Assertions.assertNotNull(recordResponse);
        Assertions.assertEquals(recordSuccessResponses, recordResponse.getRecordSuccessResponses());
        Assertions.assertEquals(recordErrorResponses, recordResponse.getRecordErrorResponses());

        verify(fileSuccessInfoMapper, times(1)).fileSuccessInfoVoToRecordSuccessResponse(fileSuccessInfoVos);
        verify(fileErrorInfoMapper, times(1)).fileErrorInfoVoToRecordErrorResponse(fileErrorInfoVos);
    }
}
