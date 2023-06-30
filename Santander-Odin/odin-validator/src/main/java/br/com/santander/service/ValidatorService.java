package br.com.santander.service;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.dto.FileSuccessInfoDto;

public interface ValidatorService {
    void readFilesFromFolder();
    void saveFileSuccessInfo(FileSuccessInfoDto fileSuccessInfoDto);
    void saveFileErrorInfo(FileErrorInfoDto fileErrorInfoDto);
    void deleteAllFileSuccessInfo();
    void deleteAllFileErrorInfo();

}
