package com.apc.template.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class PersonalInformationTest {

    private final String employeeNum = "333111", firstName = "Dummyuser", middleName = "Fortesting", lastName = "Purposes";
    private final Integer age = 30;

    @Test
    void success() {
        PersonalInformation per_info = new PersonalInformation();
        per_info.setEmployeeNum(employeeNum);
        per_info.setFirstName(firstName);
        per_info.setMiddleName(middleName);
        per_info.setLastName(lastName);
        per_info.setAge(age);
        per_info.setBirthDate(new Date());

        assertThat(per_info.getEmployeeNum()).isEqualTo(employeeNum);
        assertThat(per_info.getFirstName()).isEqualTo(firstName);
        assertThat(per_info.getMiddleName()).isEqualTo(middleName);
        assertThat(per_info.getLastName()).isEqualTo(lastName);
        assertThat(per_info.getAge()).isEqualTo(age);
        assertThat(per_info.getBirthDate()).isInstanceOf(Date.class);
    }
    @Test
    void success_overloading_constructor(){
        PersonalInformation per_info = new PersonalInformation(employeeNum, firstName, middleName, lastName, age, new Date());

        assertThat(per_info.getEmployeeNum()).isEqualTo(employeeNum);
        assertThat(per_info.getFirstName()).isEqualTo(firstName);
        assertThat(per_info.getMiddleName()).isEqualTo(middleName);
        assertThat(per_info.getLastName()).isEqualTo(lastName);
        assertThat(per_info.getAge()).isEqualTo(age);
        assertThat(per_info.getBirthDate()).isInstanceOf(Date.class);
    }

    @Test
    void success_equalsTo_hashcode(){

        PersonalInformation per_info1 = new PersonalInformation(employeeNum, firstName, middleName, lastName, age, new Date());
        PersonalInformation per_info2 = new PersonalInformation(employeeNum, firstName, middleName, lastName, age, new Date());

        assertThat(per_info1.equals(per_info2)).isTrue();
        assertThat(per_info1).hasSameHashCodeAs(per_info2);
    }
}
