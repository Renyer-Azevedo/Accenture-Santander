package br.com.santander.scheduler;

import br.com.santander.service.ValidatorService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ValidatorScheduler {

    private ValidatorService validatorService;

    @Inject
    public ValidatorScheduler(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }


    @Scheduled(every = "{validator.schedule.every}", identity = "{validator.schedule.identity}", delayed = "{validator.schedule.delay}")
    void schedule() {
        validatorService.deleteAllFileSuccessInfo();
        validatorService.deleteAllFileErrorInfo();
        validatorService.readFilesFromFolder();
    }

}
