package br.com.santander.domain.mapper;

import br.com.santander.domain.dto.FileErrorInfoDto;
import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.response.RecordErrorResponse;
import br.com.santander.domain.vo.FileErrorInfoVo;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = IGNORE)
public interface FileErrorInfoMapper {

    FileErrorInfo dtoToEntity(FileErrorInfoDto fileErrorInfoDto);
    List<FileErrorInfoVo> listEntityToListVo(List<FileErrorInfo> fileErrorInfos);
    List<RecordErrorResponse> fileErrorInfoVoToRecordErrorResponse(List<FileErrorInfoVo> fileErrorInfoVos);

}
