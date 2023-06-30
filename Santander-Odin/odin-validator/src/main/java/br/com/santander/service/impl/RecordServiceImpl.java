package br.com.santander.service.impl;

import br.com.santander.domain.exception.BusinessException;
import br.com.santander.domain.enumeration.ExceptionMessage;
import br.com.santander.domain.mapper.RecordMapper;
import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.domain.vo.RecordVo;
import br.com.santander.repository.FileErrorInfoRepository;
import br.com.santander.repository.FileSuccessInfoRepository;
import br.com.santander.service.RecordService;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;

@ApplicationScoped
@Slf4j
public class RecordServiceImpl implements RecordService {

    @Inject
    private FileSuccessInfoRepository fileSuccessInfoRepository;
    @Inject
    private FileErrorInfoRepository fileErrorInfoRepository;

    @Inject
    private RecordMapper recordMapper;

    @Override
    @CacheResult(cacheName = "records-cache")
    public RecordVo getAllRecord() {

        List<FileSuccessInfo> fileSuccessInfos = fileSuccessInfoRepository.listAll();
        List<FileErrorInfo> fileErrorInfos = fileErrorInfoRepository.listAll();

        if (fileSuccessInfos.isEmpty() && fileErrorInfos.isEmpty()) {
            log.info(ExceptionMessage.RECORD_NOT_FOUND.getMessageKey());
            throw new BusinessException(HttpStatus.NOT_FOUND, ExceptionMessage.RECORD_NOT_FOUND);
        }

        log.info("Found {} successful records.", fileSuccessInfos.size());
        log.info("Found {} error records.", fileErrorInfos.size());

        return recordMapper.convertToRecord(fileSuccessInfos,fileErrorInfos);
    }
}
