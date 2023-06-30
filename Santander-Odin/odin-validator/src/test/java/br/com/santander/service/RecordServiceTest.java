package br.com.santander.service;

import br.com.santander.domain.enumeration.ExceptionMessage;
import br.com.santander.domain.exception.BusinessException;
import br.com.santander.domain.mapper.RecordMapper;
import br.com.santander.domain.model.FileErrorInfo;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.domain.vo.FileErrorInfoVo;
import br.com.santander.domain.vo.FileSuccessInfoVo;
import br.com.santander.domain.vo.RecordVo;
import br.com.santander.repository.FileErrorInfoRepository;
import br.com.santander.repository.FileSuccessInfoRepository;
import br.com.santander.service.impl.RecordServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecordServiceTest {

    @Mock
    private FileSuccessInfoRepository fileSuccessInfoRepository;

    @Mock
    private FileErrorInfoRepository fileErrorInfoRepository;

    @Mock
    private RecordMapper recordMapper;

    @InjectMocks
    private RecordServiceImpl recordService;

    @Test
    void testGetAllRecordNoFound() {

        when(fileSuccessInfoRepository.listAll()).thenReturn(new ArrayList<>());
        when(fileErrorInfoRepository.listAll()).thenReturn(new ArrayList<>());

        BusinessException exception = assertThrows(BusinessException.class, () -> recordService.getAllRecord());

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
        assertEquals(ExceptionMessage.RECORD_NOT_FOUND, exception.getReason());

        verify(fileSuccessInfoRepository).listAll();
        verify(fileErrorInfoRepository).listAll();
        verifyNoInteractions(recordMapper);
    }

    @Test
    void testGetAllRecordFound() {

        List<FileSuccessInfo> fileSuccessInfos = new ArrayList<>();
        fileSuccessInfos.add(FileSuccessInfo.builder().id(1L).name("John").age(30).build());
        fileSuccessInfos.add(FileSuccessInfo.builder().id(2L).name("Jane").age(25).build());

        List<FileErrorInfo> fileErrorInfos = new ArrayList<>();
        fileErrorInfos.add(FileErrorInfo.builder().id(1L).fileName("file1.txt").line(10).build());
        fileErrorInfos.add(FileErrorInfo.builder().id(2L).fileName("file2.txt").line(20).build());

        RecordVo expectedRecordVo = RecordVo.builder()
                .fileSuccessInfoVos(mapFileSuccessInfos(fileSuccessInfos))
                .fileErrorInfoVos(mapFileErrorInfos(fileErrorInfos))
                .build();

        when(fileSuccessInfoRepository.listAll()).thenReturn(fileSuccessInfos);
        when(fileErrorInfoRepository.listAll()).thenReturn(fileErrorInfos);

        when(recordMapper.convertToRecord(fileSuccessInfos, fileErrorInfos)).thenReturn(expectedRecordVo);

        RecordVo result = recordService.getAllRecord();

        assertEquals(expectedRecordVo, result);

        verify(fileSuccessInfoRepository).listAll();
        verify(fileErrorInfoRepository).listAll();
        verify(recordMapper).convertToRecord(fileSuccessInfos, fileErrorInfos);
    }

    private List<FileSuccessInfoVo> mapFileSuccessInfos(List<FileSuccessInfo> fileSuccessInfos) {

        if ( fileSuccessInfos == null ) {
            return null;
        }

        List<FileSuccessInfoVo> list = new ArrayList<>( fileSuccessInfos.size() );
        for ( FileSuccessInfo fileSuccessInfo : fileSuccessInfos ) {
            list.add( fileSuccessInfoToFileSuccessInfoVo( fileSuccessInfo ) );
        }

        return list;

    }

    private FileSuccessInfoVo fileSuccessInfoToFileSuccessInfoVo(FileSuccessInfo fileSuccessInfo) {
        if ( fileSuccessInfo == null ) {
            return null;
        }

        FileSuccessInfoVo.FileSuccessInfoVoBuilder fileSuccessInfoVo = FileSuccessInfoVo.builder();

        fileSuccessInfoVo.name( fileSuccessInfo.getName() );
        fileSuccessInfoVo.age( fileSuccessInfo.getAge() );
        fileSuccessInfoVo.gender( fileSuccessInfo.getGender() );
        fileSuccessInfoVo.email( fileSuccessInfo.getEmail() );
        fileSuccessInfoVo.phone( fileSuccessInfo.getPhone() );
        fileSuccessInfoVo.address( fileSuccessInfo.getAddress() );
        fileSuccessInfoVo.city( fileSuccessInfo.getCity() );
        fileSuccessInfoVo.state( fileSuccessInfo.getState() );
        fileSuccessInfoVo.zipCode( fileSuccessInfo.getZipCode() );
        fileSuccessInfoVo.profession( fileSuccessInfo.getProfession() );

        return fileSuccessInfoVo.build();
    }

    private List<FileErrorInfoVo> mapFileErrorInfos(List<FileErrorInfo> fileErrorInfos) {
        if ( fileErrorInfos == null ) {
            return null;
        }

        List<FileErrorInfoVo> list = new ArrayList<>( fileErrorInfos.size() );
        for ( FileErrorInfo fileErrorInfo : fileErrorInfos ) {
            list.add( fileErrorInfoToFileErrorInfoVo( fileErrorInfo ) );
        }

        return list;
    }

    private FileErrorInfoVo fileErrorInfoToFileErrorInfoVo(FileErrorInfo fileErrorInfo) {
        if ( fileErrorInfo == null ) {
            return null;
        }

        FileErrorInfoVo.FileErrorInfoVoBuilder fileErrorInfoVo = FileErrorInfoVo.builder();

        fileErrorInfoVo.fileName( fileErrorInfo.getFileName() );
        fileErrorInfoVo.line( fileErrorInfo.getLine() );
        fileErrorInfoVo.col( fileErrorInfo.getCol() );
        fileErrorInfoVo.errorMessage( fileErrorInfo.getErrorMessage() );
        fileErrorInfoVo.timestamp( fileErrorInfo.getTimestamp() );

        return fileErrorInfoVo.build();
    }

}

