package br.com.santander.domain.mapper;

import br.com.santander.domain.dto.FileSuccessInfoDto;
import br.com.santander.domain.model.FileSuccessInfo;
import br.com.santander.domain.response.RecordSuccessResponse;
import br.com.santander.domain.vo.FileSuccessInfoVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FileSuccessInfoMapperTest {

    private FileSuccessInfoMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new FileSuccessInfoMapperImpl();
    }

    @Test
    void testDtoToEntity() {

        FileSuccessInfoDto dto = FileSuccessInfoDto.builder()
                .name("John Doe")
                .age(30)
                .gender("Male")
                .email("johndoe@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfo entity = mapper.dtoToEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getName(), entity.getName());
        Assertions.assertEquals(dto.getAge(), entity.getAge());
        Assertions.assertEquals(dto.getGender(), entity.getGender());
        Assertions.assertEquals(dto.getEmail(), entity.getEmail());
        Assertions.assertEquals(dto.getPhone(), entity.getPhone());
        Assertions.assertEquals(dto.getAddress(), entity.getAddress());
        Assertions.assertEquals(dto.getCity(), entity.getCity());
        Assertions.assertEquals(dto.getState(), entity.getState());
        Assertions.assertEquals(dto.getZipCode(), entity.getZipCode());
        Assertions.assertEquals(dto.getProfession(), entity.getProfession());
    }

    @Test
    void testListEntityToListVo() {

        FileSuccessInfo entity1 = FileSuccessInfo.builder()
                .name("John Doe")
                .age(30)
                .gender("Male")
                .email("johndoe@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfo entity2 = FileSuccessInfo.builder()
                .name("Jane Smith")
                .age(25)
                .gender("Female")
                .email("janesmith@example.com")
                .phone("9876543210")
                .address("456 Elm St")
                .city("San Francisco")
                .state("CA")
                .zipCode("54321")
                .profession("Designer")
                .build();

        List<FileSuccessInfo> entities = Arrays.asList(entity1, entity2);

        List<FileSuccessInfoVo> vos = mapper.listEntityToListVo(entities);

        Assertions.assertNotNull(vos);
        Assertions.assertEquals(2, vos.size());

        FileSuccessInfoVo vo1 = vos.get(0);
        Assertions.assertEquals(entity1.getName(), vo1.getName());
        Assertions.assertEquals(entity1.getAge(), vo1.getAge());
        Assertions.assertEquals(entity1.getGender(), vo1.getGender());
        Assertions.assertEquals(entity1.getEmail(), vo1.getEmail());
        Assertions.assertEquals(entity1.getPhone(), vo1.getPhone());
        Assertions.assertEquals(entity1.getAddress(), vo1.getAddress());
        Assertions.assertEquals(entity1.getCity(), vo1.getCity());
        Assertions.assertEquals(entity1.getState(), vo1.getState());
        Assertions.assertEquals(entity1.getZipCode(), vo1.getZipCode());
        Assertions.assertEquals(entity1.getProfession(), vo1.getProfession());

        FileSuccessInfoVo vo2 = vos.get(1);
        Assertions.assertEquals(entity2.getName(), vo2.getName());
        Assertions.assertEquals(entity2.getAge(), vo2.getAge());
        Assertions.assertEquals(entity2.getGender(), vo2.getGender());
        Assertions.assertEquals(entity2.getEmail(), vo2.getEmail());
        Assertions.assertEquals(entity2.getPhone(), vo2.getPhone());
        Assertions.assertEquals(entity2.getAddress(), vo2.getAddress());
        Assertions.assertEquals(entity2.getCity(), vo2.getCity());
        Assertions.assertEquals(entity2.getState(), vo2.getState());
        Assertions.assertEquals(entity2.getZipCode(), vo2.getZipCode());
        Assertions.assertEquals(entity2.getProfession(), vo2.getProfession());
    }

    @Test
    void testFileSuccessInfoVoToRecordSuccessResponse() {

        FileSuccessInfoVo vo1 = FileSuccessInfoVo.builder()
                .name("John Doe")
                .age(30)
                .gender("Male")
                .email("johndoe@example.com")
                .phone("1234567890")
                .address("123 Main St")
                .city("New York")
                .state("NY")
                .zipCode("12345")
                .profession("Engineer")
                .build();

        FileSuccessInfoVo vo2 = FileSuccessInfoVo.builder()
                .name("Jane Smith")
                .age(25)
                .gender("Female")
                .email("janesmith@example.com")
                .phone("9876543210")
                .address("456 Elm St")
                .city("San Francisco")
                .state("CA")
                .zipCode("54321")
                .profession("Designer")
                .build();

        List<FileSuccessInfoVo> vos = Arrays.asList(vo1, vo2);

        List<RecordSuccessResponse> responses = mapper.fileSuccessInfoVoToRecordSuccessResponse(vos);

        Assertions.assertNotNull(responses);
        Assertions.assertEquals(2, responses.size());

        RecordSuccessResponse response1 = responses.get(0);
        Assertions.assertEquals(vo1.getName(), response1.getName());
        Assertions.assertEquals(vo1.getAge(), response1.getAge());
        Assertions.assertEquals(vo1.getGender(), response1.getGender());
        Assertions.assertEquals(vo1.getEmail(), response1.getEmail());
        Assertions.assertEquals(vo1.getPhone(), response1.getPhone());
        Assertions.assertEquals(vo1.getAddress(), response1.getAddress());
        Assertions.assertEquals(vo1.getCity(), response1.getCity());
        Assertions.assertEquals(vo1.getState(), response1.getState());
        Assertions.assertEquals(vo1.getZipCode(), response1.getZipCode());
        Assertions.assertEquals(vo1.getProfession(), response1.getProfession());

        RecordSuccessResponse response2 = responses.get(1);
        Assertions.assertEquals(vo2.getName(), response2.getName());
        Assertions.assertEquals(vo2.getAge(), response2.getAge());
        Assertions.assertEquals(vo2.getGender(), response2.getGender());
        Assertions.assertEquals(vo2.getEmail(), response2.getEmail());
        Assertions.assertEquals(vo2.getPhone(), response2.getPhone());
        Assertions.assertEquals(vo2.getAddress(), response2.getAddress());
        Assertions.assertEquals(vo2.getCity(), response2.getCity());
        Assertions.assertEquals(vo2.getState(), response2.getState());
        Assertions.assertEquals(vo2.getZipCode(), response2.getZipCode());
        Assertions.assertEquals(vo2.getProfession(), response2.getProfession());
    }

}
