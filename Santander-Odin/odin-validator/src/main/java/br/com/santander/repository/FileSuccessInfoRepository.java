package br.com.santander.repository;

import br.com.santander.domain.model.FileSuccessInfo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FileSuccessInfoRepository implements PanacheRepository<FileSuccessInfo> {
}
