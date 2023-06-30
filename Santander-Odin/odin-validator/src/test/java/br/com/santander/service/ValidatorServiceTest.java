package br.com.santander.service;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.dto.FileSuccessInfoDto;
import br.com.santander.domain.mapper.FileErrorInfoMapper;
import br.com.santander.domain.mapper.FileSuccessInfoMapper;
import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.message.KafkaMessage;
import br.com.santander.repository.FileErrorInfoRepository;
import br.com.santander.repository.FileSuccessInfoRepository;
import br.com.santander.service.impl.ValidatorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.time.Instant;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ValidatorServiceTest {

    @Mock
    private KafkaMessage kafkaMessage;

    @Mock
    private FileSuccessInfoRepository fileSuccessInfoRepository;

    @Mock
    private FileErrorInfoRepository fileErrorInfoRepository;

    @Mock
    private FileSuccessInfoMapper fileSuccessInfoMapper;

    @Mock
    private FileErrorInfoMapper fileErrorInfoMapper;

    @InjectMocks
    private ValidatorServiceImpl validatorService;


    @Test
    void testReadFilesFromFolder() throws NoSuchFieldException, IllegalAccessException {

        //modifica o valor da variável privada filepath na classe ValidatorServiceImpl para iniciar os testes
        Field folderPath = ValidatorServiceImpl.class.getDeclaredField("folderPath");
        folderPath.setAccessible(true);
        folderPath.set(validatorService, "./datafile");

        //modifica o valor da variável privada separator na classe ValidatorServiceImpl para iniciar os testes
        Field separator = ValidatorServiceImpl.class.getDeclaredField("separator");
        separator.setAccessible(true);
        separator.set(validatorService, "\\|");

        doNothing().when(kafkaMessage).sendSuccessMessage(any(FileSuccessInfoDto.class));
        doNothing().when(kafkaMessage).sendErrorMessage(any(FileErrorInfoDto.class));

        validatorService.readFilesFromFolder();

        verify(kafkaMessage, times(13)).sendSuccessMessage(any(FileSuccessInfoDto.class));
        verify(kafkaMessage, times(59)).sendErrorMessage(any(FileErrorInfoDto.class));
    }

    @Test
    void testSaveFileSuccessInfo() {

        FileSuccessInfoDto fileSuccessInfoDto = FileSuccessInfoDto.builder()
                .name("John")
                .age(30)
                .gender("Male")
                .email("john@example.com")
                .phone("1234567890")
                .address("123 Street")
                .city("City")
                .state("State")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfo fileSuccessInfo = FileSuccessInfo.builder()
                .name("John")
                .age(30)
                .gender("Male")
                .email("john@example.com")
                .phone("1234567890")
                .address("123 Street")
                .city("City")
                .state("State")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        when(fileSuccessInfoMapper.dtoToEntity(fileSuccessInfoDto)).thenReturn(fileSuccessInfo);

        validatorService.saveFileSuccessInfo(fileSuccessInfoDto);

        verify(fileSuccessInfoRepository, times(1)).persist(fileSuccessInfo);
    }

    @Test
    void testSaveFileErrorInfo() {

        FileErrorInfoDto fileErrorInfoDto = FileErrorInfoDto.builder()
                .fileName("file.txt")
                .line(10)
                .col(5)
                .errorMessage("Error message")
                .timestamp(Instant.now())
                .build();

        FileErrorInfo fileErrorInfo = FileErrorInfo.builder()
                .fileName("file.txt")
                .line(10)
                .col(5)
                .errorMessage("Error message")
                .timestamp(Instant.now())
                .build();

        when(fileErrorInfoMapper.dtoToEntity(fileErrorInfoDto)).thenReturn(fileErrorInfo);

        validatorService.saveFileErrorInfo(fileErrorInfoDto);

        verify(fileErrorInfoRepository, times(1)).persist(fileErrorInfo);
    }

    @Test
    void testDeleteAllFileSuccessInfo() {
        validatorService.deleteAllFileSuccessInfo();

        verify(fileSuccessInfoRepository, times(1)).deleteAll();
    }

    @Test
    void testDeleteAllFileErrorInfo() {
        validatorService.deleteAllFileErrorInfo();

        verify(fileErrorInfoRepository, times(1)).deleteAll();
    }

}
