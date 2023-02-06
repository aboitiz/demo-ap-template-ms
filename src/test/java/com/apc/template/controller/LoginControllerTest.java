package com.apc.template.controller;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.constants.APIPathConstants;
import com.apc.template.commons.dto.LoginDTO;
import com.apc.template.model.LoginCredentials;
import com.apc.template.model.PersonalInformation;
import com.apc.template.services.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;

import static com.apc.template.commons.constants.APIPathConstants.API_VERSION_1;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LoginService loginService;

    final String CONSTANT_PATH = APIPathConstants.API_VERSION_1;

    @Test
    void success_addition_of_personal_information() throws Exception {
        PersonalInformation per_info = new PersonalInformation("121212","Jeremy","Ninjakid","Sasis",5,new Date(2018,01,01));
        when(loginService.addUserInformation(any())).thenReturn(per_info);
        this.mockMvc.perform(post(CONSTANT_PATH + "/AddUserInformation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(per_info)))
                .andDo(print()).andExpect(status().isCreated());
    }
    @Test
    void success_addition_of_login_credentials() throws Exception {
        LoginCredentials user_cred = new LoginCredentials(1, "Testuser", "testuserpass1$");
        when(loginService.addUserCredentials(any())).thenReturn(user_cred);
        this.mockMvc.perform(post(CONSTANT_PATH + "/AddUserCredentials")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user_cred)))
                .andDo(print()).andExpect(status().isCreated());
    }
    @Test
    void success_login() throws Exception {
        LoginDTO dto = LoginDTO
                .builder()
                .username("rjgenovea")
                .password("rymarpassword20")
                .build();
        when(loginService.getUserLoginCredentials(any())).thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.CREATED.value())));
        this.mockMvc.perform(post(CONSTANT_PATH + "/Login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void failure_login() throws Exception {
        LoginDTO dto = LoginDTO
                .builder()
                .username("d")
                .password("as")
                .build();
        when(loginService.getUserLoginCredentials(any())).thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.CREATED.value())));
        MvcResult result = this.mockMvc.perform(post(CONSTANT_PATH + "/Login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andDo(print()).andReturn();

        String response = result.getResponse().getContentAsString();
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
