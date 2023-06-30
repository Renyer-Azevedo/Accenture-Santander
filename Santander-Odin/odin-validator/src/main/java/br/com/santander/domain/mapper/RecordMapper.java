package br.com.santander.domain.mapper;

import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.domain.response.RecordResponse;
import br.com.santander.domain.vo.RecordVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = IGNORE, uses = {FileSuccessInfoMapper.class,
        FileErrorInfoMapper.class})
public interface RecordMapper {

    @Mapping(source = "fileSuccessInfos", target = "fileSuccessInfoVos")
    @Mapping(source = "fileErrorInfos", target = "fileErrorInfoVos")
    RecordVo convertToRecord(List<FileSuccessInfo> fileSuccessInfos, List<FileErrorInfo> fileErrorInfos);

    @Mapping(source = "recordVo.fileSuccessInfoVos", target = "recordSuccessResponses")
    @Mapping(source = "recordVo.fileErrorInfoVos", target = "recordErrorResponses")
    RecordResponse voToResponse(RecordVo recordVo);
}
