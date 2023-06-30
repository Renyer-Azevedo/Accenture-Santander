package br.com.santander.scheduler;

import br.com.santander.service.ValidatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class ValidatorSchedulerTest {

    @Mock
    private ValidatorService validatorService;

    @InjectMocks
    private ValidatorScheduler validatorScheduler;

    @Test
    void testSchedule() {

        doNothing().when(validatorService).deleteAllFileSuccessInfo();
        doNothing().when(validatorService).deleteAllFileErrorInfo();
        doNothing().when(validatorService).readFilesFromFolder();

        validatorScheduler.schedule();

        verify(validatorService).deleteAllFileSuccessInfo();
        verify(validatorService).deleteAllFileErrorInfo();
        verify(validatorService).readFilesFromFolder();
    }

}
