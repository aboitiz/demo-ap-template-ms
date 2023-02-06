package com.apc.template.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomerAuthTest {
    private final String username = "test";
    private final String password = "password";

    @Test
    void success(){
        CustomerAuth custAuth = new CustomerAuth();

        custAuth.setUsername(username);
        custAuth.setPassword(password);

        assertThat(custAuth.getUsername()).isEqualTo(username);
        assertThat(custAuth.getPassword()).isEqualTo(password);
    }

    @Test
    void success_toString(){
        String customerAuth = new CustomerAuthTest().toString();

        assertThat(customerAuth).isInstanceOf(String.class);
    }
}
