package com.apc.template.commons.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerLoginDTOTest {
    private final String username = "sc30";
    private final String password = "bostonIsMySon";
    @Test
    void success(){
        CustomerLoginDTO customerLoginDTO = new CustomerLoginDTO();
        customerLoginDTO.setUsername(username);
        customerLoginDTO.setPassword(password);

        assertThat(customerLoginDTO.getUsername()).isEqualTo(username);
        assertThat(customerLoginDTO.getPassword()).isEqualTo(password);
        assertThat(customerLoginDTO.getClass()).isInstanceOf(Object.class);
    }
    @Test
    void success_overloading_constructor(){
        CustomerLoginDTO customerLoginDTO = new CustomerLoginDTO(
                username,
                password
        );

        assertThat(customerLoginDTO.getUsername()).isEqualTo(username);
        assertThat(customerLoginDTO.getPassword()).isEqualTo(password);
        assertThat(customerLoginDTO.getClass()).isInstanceOf(Object.class);
    }
}
