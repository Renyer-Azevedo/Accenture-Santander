package br.com.santander.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileErrorInfoVo {

    private String fileName;
    private int line;
    private int col;
    private String errorMessage;
    private Instant timestamp;

}
