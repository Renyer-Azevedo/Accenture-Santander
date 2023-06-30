package br.com.santander.domain.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileSuccessInfoVoTest {
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
    void testFileSuccessInfoVo() {

        FileSuccessInfoVo fileSuccessInfoVo = FileSuccessInfoVo.builder()
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


        assertEquals(name, fileSuccessInfoVo.getName());
        assertEquals(age, fileSuccessInfoVo.getAge());
        assertEquals(gender, fileSuccessInfoVo.getGender());
        assertEquals(email, fileSuccessInfoVo.getEmail());
        assertEquals(phone, fileSuccessInfoVo.getPhone());
        assertEquals(address, fileSuccessInfoVo.getAddress());
        assertEquals(city, fileSuccessInfoVo.getCity());
        assertEquals(state, fileSuccessInfoVo.getState());
        assertEquals(zipCode, fileSuccessInfoVo.getZipCode());
        assertEquals(profession, fileSuccessInfoVo.getProfession());
    }

    @Test
    void testSettersAndGetters() {

        FileSuccessInfoVo fileSuccessInfoVo = new FileSuccessInfoVo();

        fileSuccessInfoVo.setName(name);
        fileSuccessInfoVo.setAge(age);
        fileSuccessInfoVo.setGender(gender);
        fileSuccessInfoVo.setEmail(email);
        fileSuccessInfoVo.setPhone(phone);
        fileSuccessInfoVo.setAddress(address);
        fileSuccessInfoVo.setCity(city);
        fileSuccessInfoVo.setState(state);
        fileSuccessInfoVo.setZipCode(zipCode);
        fileSuccessInfoVo.setProfession(profession);

        assertEquals(name, fileSuccessInfoVo.getName());
        assertEquals(age, fileSuccessInfoVo.getAge());
        assertEquals(gender, fileSuccessInfoVo.getGender());
        assertEquals(email, fileSuccessInfoVo.getEmail());
        assertEquals(phone, fileSuccessInfoVo.getPhone());
        assertEquals(address, fileSuccessInfoVo.getAddress());
        assertEquals(city, fileSuccessInfoVo.getCity());
        assertEquals(state, fileSuccessInfoVo.getState());
        assertEquals(zipCode, fileSuccessInfoVo.getZipCode());
        assertEquals(profession, fileSuccessInfoVo.getProfession());
    }

    @Test
    void testConstructorWithAllFields() {

        FileSuccessInfoVo fileSuccessInfoVo = new FileSuccessInfoVo(name, age, gender, email, phone, address, city, state, zipCode, profession);

        assertEquals(name, fileSuccessInfoVo.getName());
        assertEquals(age, fileSuccessInfoVo.getAge());
        assertEquals(gender, fileSuccessInfoVo.getGender());
        assertEquals(email, fileSuccessInfoVo.getEmail());
        assertEquals(phone, fileSuccessInfoVo.getPhone());
        assertEquals(address, fileSuccessInfoVo.getAddress());
        assertEquals(city, fileSuccessInfoVo.getCity());
        assertEquals(state, fileSuccessInfoVo.getState());
        assertEquals(zipCode, fileSuccessInfoVo.getZipCode());
        assertEquals(profession, fileSuccessInfoVo.getProfession());
    }

    @Test
    void testDefaultConstructor() {

        FileSuccessInfoVo fileSuccessInfoVo = new FileSuccessInfoVo();

        assertNull(fileSuccessInfoVo.getName());
        assertNull(fileSuccessInfoVo.getAge());
        assertNull(fileSuccessInfoVo.getGender());
        assertNull(fileSuccessInfoVo.getEmail());
        assertNull(fileSuccessInfoVo.getPhone());
        assertNull(fileSuccessInfoVo.getAddress());
        assertNull(fileSuccessInfoVo.getCity());
        assertNull(fileSuccessInfoVo.getState());
        assertNull(fileSuccessInfoVo.getZipCode());
        assertNull(fileSuccessInfoVo.getProfession());
    }

    @Test
    void testToString() {

        FileSuccessInfoVo fileSuccessInfoVo = FileSuccessInfoVo.builder()
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

        String expecteVoString = "FileSuccessInfoVo(name=John Doe, age=30, gender=Male, email=johndoe@example.com, phone=1234567890, address=123 Main St, city=New York, state=NY, zipCode=12345, profession=Engineer)";
        assertEquals(expecteVoString, fileSuccessInfoVo.toString());
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

        FileSuccessInfoVo fileSuccessInfoVo1 = new FileSuccessInfoVo(name1, age1, gender1, email1, phone1, address1, city1, state1, zipCode1, profession1);
        FileSuccessInfoVo fileSuccessInfoVo2 = new FileSuccessInfoVo(name2, age2, gender2, email2, phone2, address2, city2, state2, zipCode2, profession2);
        FileSuccessInfoVo fileSuccessInfoVo3 = new FileSuccessInfoVo(name3, age3, gender3, email3, phone3, address3, city3, state3, zipCode3, profession3);

        assertEquals(fileSuccessInfoVo1, fileSuccessInfoVo2);
        assertNotEquals(fileSuccessInfoVo1, fileSuccessInfoVo3);
    }
}
