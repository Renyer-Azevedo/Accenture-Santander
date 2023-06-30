package br.com.santander.message;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.dto.FileSuccessInfoDto;
import br.com.santander.service.ValidatorService;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
@Slf4j
public class KafkaMessage {

    @Inject
    @Channel("{validator.kafka.topic.success}")
    Emitter<FileSuccessInfoDto> successEmitter;

    @Inject
    @Channel("{validator.kafka.topic.error}")
    Emitter<FileErrorInfoDto> errorEmitter;
    @Inject
    private ValidatorService validatorService;

    @Incoming("{validator.kafka.topic.success}")
    @NonBlocking
    public void consumeSuccess(FileSuccessInfoDto fileSuccessInfoDto) {
        log.info("Consumed from topic-odin-read-success: " + fileSuccessInfoDto);
        validatorService.saveFileSuccessInfo(fileSuccessInfoDto);
    }

    @Incoming("{validator.kafka.topic.error}")
    @NonBlocking
    public void consumeError(FileErrorInfoDto fileErrorInfoDto) {
        log.info("Consumed from topic-odin-read-error: " + fileErrorInfoDto);
        validatorService.saveFileErrorInfo(fileErrorInfoDto);
    }
    @Transactional
    public void sendSuccessMessage(FileSuccessInfoDto fileSuccessInfoDto) {
        successEmitter.send(fileSuccessInfoDto).toCompletableFuture().join();
        log.info("Producing to topic-odin-read-success: " + fileSuccessInfoDto);
    }
    @Transactional
    public void sendErrorMessage(FileErrorInfoDto fileErrorInfoDto) {
        errorEmitter.send(fileErrorInfoDto).toCompletableFuture().join();
        log.info("Producing to topic-odin-read-error: " + fileErrorInfoDto);
    }

}
