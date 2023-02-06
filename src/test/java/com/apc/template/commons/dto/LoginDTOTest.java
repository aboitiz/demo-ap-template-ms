package com.apc.template.commons.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class LoginDTOTest {
    private final String username = "myusername";

    private final String password = "mypassword";

    @Test
    void success() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(username);
        loginDTO.setPassword(password);

        assertThat(loginDTO.getUsername()).isEqualTo(username);
        assertThat(loginDTO.getPassword()).isEqualTo(password);
    }

    @Test
    void success_overloading_constructor() {
        LoginDTO loginDTO = new LoginDTO(
            username,
            password
        );
        assertThat(loginDTO.getUsername()).isEqualTo(username);
        assertThat(loginDTO.getPassword()).isEqualTo(password);
    }
}
