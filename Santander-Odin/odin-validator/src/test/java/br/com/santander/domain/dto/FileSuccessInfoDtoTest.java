package br.com.santander.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSuccessInfoDtoTest {
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String profession;

    @BeforeEach
    void setUp() {
        name = "John Doe";
        age = 30;
        gender = "Male";
        email = "johndoe@example.com";
        phone = "1234567890";
        address = "123 Main St";
        city = "New York";
        state = "NY";
        zipCode = "12345";
        profession = "Engineer";
    }

    @Test
    void testFileSuccessInfoDto() {

        FileSuccessInfoDto fileSuccessInfoDto = FileSuccessInfoDto.builder()
                .name(name)
                .age(age)
                .gender(gender)
                .email(email)
                .phone(phone)
                .address(address)
                .city(city)
                .state(state)
                .zipCode(zipCode)
                .profession(profession)
                .build();


        assertEquals(name, fileSuccessInfoDto.getName());
        assertEquals(age, fileSuccessInfoDto.getAge());
        assertEquals(gender, fileSuccessInfoDto.getGender());
        assertEquals(email, fileSuccessInfoDto.getEmail());
        assertEquals(phone, fileSuccessInfoDto.getPhone());
        assertEquals(address, fileSuccessInfoDto.getAddress());
        assertEquals(city, fileSuccessInfoDto.getCity());
        assertEquals(state, fileSuccessInfoDto.getState());
        assertEquals(zipCode, fileSuccessInfoDto.getZipCode());
        assertEquals(profession, fileSuccessInfoDto.getProfession());
    }

    @Test
    void testSettersAndGetters() {

        FileSuccessInfoDto fileSuccessInfoDto = new FileSuccessInfoDto();

        fileSuccessInfoDto.setName(name);
        fileSuccessInfoDto.setAge(age);
        fileSuccessInfoDto.setGender(gender);
        fileSuccessInfoDto.setEmail(email);
        fileSuccessInfoDto.setPhone(phone);
        fileSuccessInfoDto.setAddress(address);
        fileSuccessInfoDto.setCity(city);
        fileSuccessInfoDto.setState(state);
        fileSuccessInfoDto.setZipCode(zipCode);
        fileSuccessInfoDto.setProfession(profession);

        assertEquals(name, fileSuccessInfoDto.getName());
        assertEquals(age, fileSuccessInfoDto.getAge());
        assertEquals(gender, fileSuccessInfoDto.getGender());
        assertEquals(email, fileSuccessInfoDto.getEmail());
        assertEquals(phone, fileSuccessInfoDto.getPhone());
        assertEquals(address, fileSuccessInfoDto.getAddress());
        assertEquals(city, fileSuccessInfoDto.getCity());
        assertEquals(state, fileSuccessInfoDto.getState());
        assertEquals(zipCode, fileSuccessInfoDto.getZipCode());
        assertEquals(profession, fileSuccessInfoDto.getProfession());
    }

    @Test
    void testConstructorWithAllFields() {

        FileSuccessInfoDto fileSuccessInfoDto = new FileSuccessInfoDto(name, age, gender, email, phone, address, city, state, zipCode, profession);

        assertEquals(name, fileSuccessInfoDto.getName());
        assertEquals(age, fileSuccessInfoDto.getAge());
        assertEquals(gender, fileSuccessInfoDto.getGender());
        assertEquals(email, fileSuccessInfoDto.getEmail());
        assertEquals(phone, fileSuccessInfoDto.getPhone());
        assertEquals(address, fileSuccessInfoDto.getAddress());
        assertEquals(city, fileSuccessInfoDto.getCity());
        assertEquals(state, fileSuccessInfoDto.getState());
        assertEquals(zipCode, fileSuccessInfoDto.getZipCode());
        assertEquals(profession, fileSuccessInfoDto.getProfession());
    }

    @Test
    void testDefaultConstructor() {

        FileSuccessInfoDto fileSuccessInfoDto = new FileSuccessInfoDto();

        assertNull(fileSuccessInfoDto.getName());
        assertNull(fileSuccessInfoDto.getAge());
        assertNull(fileSuccessInfoDto.getGender());
        assertNull(fileSuccessInfoDto.getEmail());
        assertNull(fileSuccessInfoDto.getPhone());
        assertNull(fileSuccessInfoDto.getAddress());
        assertNull(fileSuccessInfoDto.getCity());
        assertNull(fileSuccessInfoDto.getState());
        assertNull(fileSuccessInfoDto.getZipCode());
        assertNull(fileSuccessInfoDto.getProfession());
    }

    @Test
    void testToString() {

        FileSuccessInfoDto fileSuccessInfoDto = FileSuccessInfoDto.builder()
                .name(name)
                .age(age)
                .gender(gender)
                .email(email)
                .phone(phone)
                .address(address)
                .city(city)
                .state(state)
                .zipCode(zipCode)
                .profession(profession)
                .build();

        String expectedToString = "FileSuccessInfoDto(name=John Doe, age=30, gender=Male, email=johndoe@example.com, phone=1234567890, address=123 Main St, city=New York, state=NY, zipCode=12345, profession=Engineer)";
        assertEquals(expectedToString, fileSuccessInfoDto.toString());
    }

    @Test
    void testEquals() {

        String name1 = "John Doe";
        Integer age1 = 30;
        String gender1 = "Male";
        String email1 = "johndoe@example.com";
        String phone1 = "1234567890";
        String address1 = "123 Main St";
        String city1 = "New York";
        String state1 = "NY";
        String zipCode1 = "12345";
        String profession1 = "Engineer";

        String name2 = "John Doe";
        Integer age2 = 30;
        String gender2 = "Male";
        String email2 = "johndoe@example.com";
        String phone2 = "1234567890";
        String address2 = "123 Main St";
        String city2 = "New York";
        String state2 = "NY";
        String zipCode2 = "12345";
        String profession2 = "Engineer";

        String name3 = "Jane Smith";
        Integer age3 = 25;
        String gender3 = "Female";
        String email3 = "janesmith@example.com";
        String phone3 = "9876543210";
        String address3 = "456 Elm St";
        String city3 = "Los Angeles";
        String state3 = "CA";
        String zipCode3 = "54321";
        String profession3 = "Doctor";

        FileSuccessInfoDto fileSuccessInfoDto1 = new FileSuccessInfoDto(name1, age1, gender1, email1, phone1, address1, city1, state1, zipCode1, profession1);
        FileSuccessInfoDto fileSuccessInfoDto2 = new FileSuccessInfoDto(name2, age2, gender2, email2, phone2, address2, city2, state2, zipCode2, profession2);
        FileSuccessInfoDto fileSuccessInfoDto3 = new FileSuccessInfoDto(name3, age3, gender3, email3, phone3, address3, city3, state3, zipCode3, profession3);

        assertEquals(fileSuccessInfoDto1, fileSuccessInfoDto2);
        assertNotEquals(fileSuccessInfoDto1, fileSuccessInfoDto3);
    }
}
