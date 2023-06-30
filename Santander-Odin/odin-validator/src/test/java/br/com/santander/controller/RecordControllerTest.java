package br.com.santander.controller;

import br.com.santander.domain.mapper.RecordMapper;
import br.com.santander.domain.response.RecordResponse;
import br.com.santander.domain.vo.RecordVo;
import br.com.santander.service.RecordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecordControllerTest {

    @Mock
    private RecordService recordService;

    @Mock
    private RecordMapper recordMapper;

    @InjectMocks
    private RecordController recordController;

    @Test
    void testGetAllRecords() {

        RecordResponse expectedResponse = new RecordResponse();
        when(recordService.getAllRecord()).thenReturn(new RecordVo());
        when(recordMapper.voToResponse(any())).thenReturn(expectedResponse);

        RecordResponse actualResponse = recordController.getAllRecords();

        verify(recordService, times(1)).getAllRecord();
        verify(recordMapper, times(1)).voToResponse(any());

        assertEquals(expectedResponse, actualResponse);
    }
}
