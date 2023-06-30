package br.com.santander.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecordVo {

    private List<FileSuccessInfoVo> fileSuccessInfoVos;

    private List<FileErrorInfoVo> fileErrorInfoVos;

}
