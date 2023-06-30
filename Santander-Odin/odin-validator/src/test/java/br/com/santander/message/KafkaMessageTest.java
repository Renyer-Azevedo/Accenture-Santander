package br.com.santander.message;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.dto.FileSuccessInfoDto;
import br.com.santander.service.ValidatorService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class KafkaMessageTest {

    @Mock
    @Channel("{validator.kafka.topic.success}")
    private Emitter<FileSuccessInfoDto> successEmitter;

    @Mock
    @Channel("{validator.kafka.topic.error}")
    private Emitter<FileErrorInfoDto> errorEmitter;

    @Mock
    private ValidatorService validatorService;

    @InjectMocks
    private KafkaMessage kafkaMessage;

    @Test
    void testConsumeSuccess() {
        FileSuccessInfoDto fileSuccessInfoDto = new FileSuccessInfoDto();
        kafkaMessage.consumeSuccess(fileSuccessInfoDto);
        verify(validatorService, times(1)).saveFileSuccessInfo(fileSuccessInfoDto);
    }

    @Test
    void testConsumeError() {
        FileErrorInfoDto fileErrorInfoDto = new FileErrorInfoDto();
        kafkaMessage.consumeError(fileErrorInfoDto);
        verify(validatorService, times(1)).saveFileErrorInfo(fileErrorInfoDto);
    }

    @Test
    void testSendSuccessMessage() {
        FileSuccessInfoDto fileSuccessInfoDto = new FileSuccessInfoDto();
        when(successEmitter.send(fileSuccessInfoDto)).thenReturn(CompletableFuture.completedFuture(null));
        kafkaMessage.sendSuccessMessage(fileSuccessInfoDto);
        verify(successEmitter, times(1)).send(fileSuccessInfoDto);
    }

    @Test
    void testSendErrorMessage() {
        FileErrorInfoDto fileErrorInfoDto = new FileErrorInfoDto();
        when(errorEmitter.send(fileErrorInfoDto)).thenReturn(CompletableFuture.completedFuture(null));
        kafkaMessage.sendErrorMessage(fileErrorInfoDto);
        verify(errorEmitter, times(1)).send(fileErrorInfoDto);
    }


}

