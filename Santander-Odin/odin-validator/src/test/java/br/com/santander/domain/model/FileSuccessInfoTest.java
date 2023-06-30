package br.com.santander.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileSuccessInfoTest {

    private Long id;
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
        id = 1L;
        name = "John Doe";
        age = 30;
        gender = "Male";
        email = "johndoe@example.com";
        phone = "1234567890";
        address = "123 Main St";
        city = "New York";
        state = "NY";
        zipCode = "12345";
        profession = "Software Engineer";
    }

    @Test
    void testFileSuccessInfoToString() {

        FileSuccessInfo fileSuccessInfo = new FileSuccessInfo(id, name, age, gender, email, phone, address, city, state, zipCode, profession);

        String expectedToString = "FileSuccessInfo(id=1, name=John Doe, age=30, gender=Male, email=johndoe@example.com, phone=1234567890, address=123 Main St, city=New York, state=NY, zipCode=12345, profession=Software Engineer)";
        Assertions.assertEquals(expectedToString, fileSuccessInfo.toString());
    }

    @Test
    void testFileSuccessInfoEqualsAndHashCode() {

        FileSuccessInfo fileSuccessInfo1 = new FileSuccessInfo(id, name, age, gender, email, phone, address, city, state, zipCode, profession);
        FileSuccessInfo fileSuccessInfo2 = new FileSuccessInfo(id, name, age, gender, email, phone, address, city, state, zipCode, profession);

        Assertions.assertEquals(fileSuccessInfo1, fileSuccessInfo2);

        Assertions.assertEquals(fileSuccessInfo1.hashCode(), fileSuccessInfo2.hashCode());
    }

    @Test
    void testFileSuccessInfoGettersAndSetters() {

        FileSuccessInfo fileSuccessInfo = new FileSuccessInfo();

        fileSuccessInfo.setId(id);
        fileSuccessInfo.setName(name);
        fileSuccessInfo.setAge(age);
        fileSuccessInfo.setGender(gender);
        fileSuccessInfo.setEmail(email);
        fileSuccessInfo.setPhone(phone);
        fileSuccessInfo.setAddress(address);
        fileSuccessInfo.setCity(city);
        fileSuccessInfo.setState(state);
        fileSuccessInfo.setZipCode(zipCode);
        fileSuccessInfo.setProfession(profession);

        Assertions.assertEquals(id, fileSuccessInfo.getId());
        Assertions.assertEquals(name, fileSuccessInfo.getName());
        Assertions.assertEquals(age, fileSuccessInfo.getAge());
        Assertions.assertEquals(gender, fileSuccessInfo.getGender());
        Assertions.assertEquals(email, fileSuccessInfo.getEmail());
        Assertions.assertEquals(phone, fileSuccessInfo.getPhone());
        Assertions.assertEquals(address, fileSuccessInfo.getAddress());
        Assertions.assertEquals(city, fileSuccessInfo.getCity());
        Assertions.assertEquals(state, fileSuccessInfo.getState());
        Assertions.assertEquals(zipCode, fileSuccessInfo.getZipCode());
        Assertions.assertEquals(profession, fileSuccessInfo.getProfession());
    }

    @Test
    void testFileSuccessInfoConstructorWithAllFields() {

        FileSuccessInfo fileSuccessInfo = new FileSuccessInfo(id, name, age, gender, email, phone, address, city, state, zipCode, profession);

        Assertions.assertEquals(id, fileSuccessInfo.getId());
        Assertions.assertEquals(name, fileSuccessInfo.getName());
        Assertions.assertEquals(age, fileSuccessInfo.getAge());
        Assertions.assertEquals(gender, fileSuccessInfo.getGender());
        Assertions.assertEquals(email, fileSuccessInfo.getEmail());
        Assertions.assertEquals(phone, fileSuccessInfo.getPhone());
        Assertions.assertEquals(address, fileSuccessInfo.getAddress());
        Assertions.assertEquals(city, fileSuccessInfo.getCity());
        Assertions.assertEquals(state, fileSuccessInfo.getState());
        Assertions.assertEquals(zipCode, fileSuccessInfo.getZipCode());
        Assertions.assertEquals(profession, fileSuccessInfo.getProfession());
    }

    @Test
    void testFileSuccessInfoConstructorWithNoFields() {

        FileSuccessInfo fileSuccessInfo = new FileSuccessInfo();

        Assertions.assertNull(fileSuccessInfo.getId());
        Assertions.assertNull(fileSuccessInfo.getName());
        Assertions.assertNull(fileSuccessInfo.getAge());
        Assertions.assertNull(fileSuccessInfo.getGender());
        Assertions.assertNull(fileSuccessInfo.getEmail());
        Assertions.assertNull(fileSuccessInfo.getPhone());
        Assertions.assertNull(fileSuccessInfo.getAddress());
        Assertions.assertNull(fileSuccessInfo.getCity());
        Assertions.assertNull(fileSuccessInfo.getState());
        Assertions.assertNull(fileSuccessInfo.getZipCode());
        Assertions.assertNull(fileSuccessInfo.getProfession());
    }

    @Test
    void testFileSuccessInfoBuilder() {

        FileSuccessInfo fileSuccessInfo = FileSuccessInfo.builder()
                .id(id)
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

        Assertions.assertEquals(id, fileSuccessInfo.getId());
        Assertions.assertEquals(name, fileSuccessInfo.getName());
        Assertions.assertEquals(age, fileSuccessInfo.getAge());
        Assertions.assertEquals(gender, fileSuccessInfo.getGender());
        Assertions.assertEquals(email, fileSuccessInfo.getEmail());
        Assertions.assertEquals(phone, fileSuccessInfo.getPhone());
        Assertions.assertEquals(address, fileSuccessInfo.getAddress());
        Assertions.assertEquals(city, fileSuccessInfo.getCity());
        Assertions.assertEquals(state, fileSuccessInfo.getState());
        Assertions.assertEquals(zipCode, fileSuccessInfo.getZipCode());
        Assertions.assertEquals(profession, fileSuccessInfo.getProfession());
    }

}
