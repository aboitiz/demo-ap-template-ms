package com.apc.template.services.impl;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.LoginDTO;
import com.apc.template.model.LoginCredentials;
import com.apc.template.model.PersonalInformation;
import com.apc.template.repository.LoginCredentialsRepository;
import com.apc.template.repository.PersonalInformationRepository;
import org.apache.juli.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LoginImplTest {

    @Mock
    private PersonalInformationRepository personalinformation;

    @Mock
    private LoginCredentialsRepository logincredentials;

    @Spy
    @InjectMocks
    private LoginImpl loginImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private PersonalInformation personalinfo;

    private LoginCredentials logincreds;

    private LoginDTO loginDTO = new LoginDTO();

    @Test
    void success_adding_personal_information(){
        PersonalInformation per_info = new PersonalInformation("333222", "Dwayne", "TheRock", "Johnson", 40, new Date());
        when(personalinformation.save(Mockito.any())).thenReturn(per_info);

        PersonalInformation response = loginImpl.addUserInformation(personalinfo);

        assertThat(response).isNotNull();
    }
    @Test
    void failure_adding_personal_information(){
        when(personalinformation.save(personalinfo)).thenReturn(personalinfo);

        PersonalInformation response = loginImpl.addUserInformation(personalinfo);

        assertThat(response).isNull();
    }

    @Test
    void success_adding_login_credentials(){
        LoginCredentials user_creds = new LoginCredentials(4, "newuser", "newpass1$");
        when(logincredentials.save(Mockito.any())).thenReturn(user_creds);

        LoginCredentials response = loginImpl.addUserCredentials(logincreds);

        assertThat(response).isNotNull();
    }
    @Test
    void failure_adding_login_credentials(){
        when(logincredentials.save(logincreds)).thenReturn(logincreds);

        LoginCredentials response = loginImpl.addUserCredentials(logincreds);

        assertThat(response).isNull();
    }
    @Test
    void success_login() throws Exception{
        LoginCredentials login_creds = new LoginCredentials( 3,"rjgenovea","rymarpassword20");
        when(logincredentials.getUserCred(Mockito.anyString(),Mockito.anyString())).thenReturn(login_creds);


        LoginDTO login = new LoginDTO();
        login.setUsername(login_creds.getUsername());
        login.setPassword(login_creds.getPassword());

        BaseResponse response = loginImpl.getUserLoginCredentials(login);

        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.ACCEPTED.value());
    }
    @Test
    void failure_login() throws Exception{

        LoginDTO login = new LoginDTO();

        BaseResponse response = loginImpl.getUserLoginCredentials(login);
        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }
}
