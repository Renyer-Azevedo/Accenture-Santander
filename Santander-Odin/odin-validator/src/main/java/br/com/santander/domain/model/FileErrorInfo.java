package br.com.santander.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "file_error_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileErrorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "line")
    private int line;

    @Column(name = "col")
    private int col;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "timestamp")
    private Instant timestamp;
}
