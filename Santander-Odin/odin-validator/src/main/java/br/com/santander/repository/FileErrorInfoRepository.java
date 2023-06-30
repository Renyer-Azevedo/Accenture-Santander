package br.com.santander.repository;

import br.com.santander.domain.model.FileErrorInfo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FileErrorInfoRepository implements PanacheRepository<FileErrorInfo> {
}
