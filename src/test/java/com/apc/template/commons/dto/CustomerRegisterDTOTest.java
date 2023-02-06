package com.apc.template.commons.dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerRegisterDTOTest {
    private final String username = "lbj23";
    private final String password = "CurryIsMySon";
    private final String firstName = "Lebron";
    private final String lastName = "James";
    private final Date birthDate = new Date(2010,01,20);
    private final String address = "Mercury";

    @Test
    void success(){
        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO();
        registerDTO.setUsername(username);
        registerDTO.setPassword(password);
        registerDTO.setFirstName(firstName);
        registerDTO.setLastName(lastName);
        registerDTO.setBirthDate(birthDate);
        registerDTO.setAddress(address);

        assertThat(registerDTO.getUsername()).isEqualTo(username);
        assertThat(registerDTO.getPassword()).isEqualTo(password);
        assertThat(registerDTO.getFirstName()).isEqualTo(firstName);
        assertThat(registerDTO.getLastName()).isEqualTo(lastName);
        assertThat(registerDTO.getBirthDate()).isEqualTo(birthDate);
        assertThat(registerDTO.getAddress()).isEqualTo(address);
    }

    @Test
    void success_overloading_constructor(){
        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO(
                username, password, firstName, lastName, birthDate, address
        );

        assertThat(registerDTO.getUsername()).isEqualTo(username);
        assertThat(registerDTO.getPassword()).isEqualTo(password);
        assertThat(registerDTO.getFirstName()).isEqualTo(firstName);
        assertThat(registerDTO.getLastName()).isEqualTo(lastName);
        assertThat(registerDTO.getBirthDate()).isEqualTo(birthDate);
        assertThat(registerDTO.getAddress()).isEqualTo(address);
    }
}
