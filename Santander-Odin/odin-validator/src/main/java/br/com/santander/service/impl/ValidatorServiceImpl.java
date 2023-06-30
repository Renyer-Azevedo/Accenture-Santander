package br.com.santander.service.impl;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.dto.FileSuccessInfoDto;
import br.com.santander.domain.mapper.FileErrorInfoMapper;
import br.com.santander.domain.mapper.FileSuccessInfoMapper;
import br.com.santander.message.KafkaMessage;
import br.com.santander.repository.FileErrorInfoRepository;
import br.com.santander.repository.FileSuccessInfoRepository;
import br.com.santander.service.ValidatorService;
import io.quarkus.cache.CacheInvalidateAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@ApplicationScoped
@Slf4j
public class ValidatorServiceImpl implements ValidatorService {

    @Inject
    @ConfigProperty(name = "validator.folder.path")
    private String folderPath;
    @Inject
    @ConfigProperty(name = "validator.folder.file.separator")
    private String separator;
    @Inject
    private KafkaMessage kafkaMessage;
    @Inject
    private FileSuccessInfoRepository fileSuccessInfoRepository;
    @Inject
    private FileErrorInfoRepository fileErrorInfoRepository;
    @Inject
    private FileSuccessInfoMapper fileSuccessInfoMapper;
    @Inject
    private FileErrorInfoMapper fileErrorInfoMapper;

    @Override
    public void readFilesFromFolder() {
        try (Stream<Path> pathStream = Files.list(Path.of(folderPath))) {
            pathStream
                    .filter(Files::isRegularFile)
                    .forEach(this::readFile);
        } catch (IOException e) {
            log.error("Error reading files from folder.", e);
        }
    }

    private void readFile(Path filePath) {
        try (Stream<String> stream = Files.lines(filePath)) {
            AtomicInteger lineNumber = new AtomicInteger(1);
            stream.parallel().forEachOrdered(line -> processLine(lineNumber.getAndIncrement(), line, filePath.getFileName().toString()));
        } catch (IOException e) {
            log.error("Error read file.", e);
        }
    }

    private void processLine(int lineNumber,String line, String fileName) {

        String[] cols = line.split(separator);
        int expectedColumns = 10;

        if (cols.length != expectedColumns) {
            log.info("error col length");
            kafkaMessage.sendErrorMessage(createObjectSendKafkaError(lineNumber, expectedColumns, fileName));
            return;
        }

        for (int colNumber = 0; colNumber < cols.length; colNumber++) {
            String col = cols[colNumber];
            if (col.trim().isEmpty()) {
                log.info("error col empty");
                kafkaMessage.sendErrorMessage(createObjectSendKafkaError(lineNumber, colNumber + 1, fileName));
                return;
            }
        }

        log.info("send kafka success");
        kafkaMessage.sendSuccessMessage(createObjectSendKafkaSuccess(cols));

    }

    private FileErrorInfoDto createObjectSendKafkaError(int lineNumber, int colNumber, String fileName) {

        return FileErrorInfoDto.builder()
                .fileName(fileName)
                .line(lineNumber)
                .col(colNumber)
                .errorMessage("formatter error, Line " + lineNumber + " and Column " + colNumber + ".")
                .timestamp(Instant.now())
                .build();
    }

    private FileSuccessInfoDto createObjectSendKafkaSuccess(String[] cols) {

        return FileSuccessInfoDto.builder()
                .name(cols[0])
                .age(Integer.valueOf(cols[1]))
                .gender(cols[2])
                .email(cols[3])
                .phone(cols[4])
                .address(cols[5])
                .city(cols[6])
                .state(cols[7])
                .zipCode(cols[8])
                .profession(cols[9])
                .build();

    }

    @Override
    @Transactional
    public void saveFileSuccessInfo(FileSuccessInfoDto fileSuccessInfoDto) {
        log.info("save file success info database");
        fileSuccessInfoRepository.persist(fileSuccessInfoMapper.dtoToEntity(fileSuccessInfoDto));
    }

    @Override
    @Transactional
    public void saveFileErrorInfo(FileErrorInfoDto fileErrorInfoDto) {
        log.info("save file error info database");
        fileErrorInfoRepository.persist(fileErrorInfoMapper.dtoToEntity(fileErrorInfoDto));
    }

    @Override
    @Transactional
    @CacheInvalidateAll(cacheName = "records-cache")
    public void deleteAllFileSuccessInfo() {
        log.info("delete all file success info database");
        fileSuccessInfoRepository.deleteAll();
    }

    @Override
    @Transactional
    @CacheInvalidateAll(cacheName = "records-cache")
    public void deleteAllFileErrorInfo() {
        log.info("delete all file error info database");
        fileErrorInfoRepository.deleteAll();
    }

}
