package com.apc.template.model;

import org.apache.juli.logging.Log;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginCredentialsTest {

    private final Integer userId = 1;
    private final String username = "Testuser", password = "testuserpass1$";

    @Test
    void success() {
        LoginCredentials login_creds = new LoginCredentials();
        login_creds.setUserId(userId);
        login_creds.setUsername(username);
        login_creds.setPassword(password);

        assertThat(login_creds.getUserId()).isEqualTo(userId);
        assertThat(login_creds.getUsername()).isEqualTo(username);
        assertThat(login_creds.getPassword()).isEqualTo(password);
    }

    @Test
    void success_overloading_constructor() {
        LoginCredentials login_creds = new LoginCredentials(userId, username, password);
        assertThat(login_creds.getUserId()).isEqualTo(userId);
        assertThat(login_creds.getUsername()).isEqualTo(username);
        assertThat(login_creds.getPassword()).isEqualTo(password);
    }

    @Test
    void success_equalsTo_hashcode(){
        LoginCredentials login_creds1 = new LoginCredentials(userId, username, password);
        LoginCredentials login_creds2 = new LoginCredentials(userId, username, password);

        assertThat(login_creds1.equals(login_creds2)).isTrue();
        assertThat(login_creds1).hasSameHashCodeAs(login_creds2);
    }
}
