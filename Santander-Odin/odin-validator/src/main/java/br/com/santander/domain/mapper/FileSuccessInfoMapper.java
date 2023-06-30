package br.com.santander.domain.mapper;

import br.com.santander.domain.dto.FileSuccessInfoDto;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.domain.response.RecordSuccessResponse;
import br.com.santander.domain.vo.FileSuccessInfoVo;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;
@Mapper(componentModel = "cdi", unmappedTargetPolicy = IGNORE)
public interface FileSuccessInfoMapper {

    FileSuccessInfo dtoToEntity(FileSuccessInfoDto fileSuccessInfoDto);
    List<FileSuccessInfoVo> listEntityToListVo(List<FileSuccessInfo> fileSuccessInfos);
    List<RecordSuccessResponse> fileSuccessInfoVoToRecordSuccessResponse(List<FileSuccessInfoVo> fileSuccessInfoVos);

}
