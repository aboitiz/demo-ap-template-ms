package com.apc.template.controller;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.constants.APIPathConstants;
import com.apc.template.commons.dto.CustomerLoginDTO;
import com.apc.template.commons.dto.CustomerRegisterDTO;
import com.apc.template.services.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    final String CUSTOMER_PATH = APIPathConstants.API_VERSION_1 + APIPathConstants.CUSTOMER_BASE_PATH;

    @Test
    void success_customerLogin() throws Exception {
        CustomerLoginDTO loginDTO = new CustomerLoginDTO("testuser", "password");
        when(customerService.login(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.OK.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDTO)))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void failure_customerLogin_validation_bad_request() throws Exception {
        CustomerLoginDTO loginDTO = new CustomerLoginDTO("1", "");
        when(customerService.login(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.OK.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void failure_customerLogin_bad_request() throws Exception {
        CustomerLoginDTO loginDTO = new CustomerLoginDTO("test", "invalid");
        when(customerService.login(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDTO)))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    void failure_customerLogin_exception() throws Exception {
        CustomerLoginDTO loginDTO = new CustomerLoginDTO("1", "");
        when(customerService.login(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDTO)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void success_customerRegister() throws Exception {
        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO("test", "password",
                "test", "user",
                new Date(2011, 2, 5) ,"vdc");
        when(customerService.register(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.CREATED.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDTO)))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void failure_customerRegister_validation() throws Exception {
        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO("1", "p",
                "", "user",
                new Date(2011, 2, 5) ,"vdc");
        when(customerService.register(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.CREATED.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerDTO)))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void failure_customerRegister() throws Exception {
        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO("Test", "invalid",
                "test", "user",
                new Date(2011, 2, 5) ,"vdc");
        when(customerService.register(any()))
                .thenReturn(new BaseResponse<>().setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST.value())));
        this.mockMvc.perform(post(CUSTOMER_PATH+"/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerDTO)))
                .andDo(print()).andExpect(status().isBadRequest());
    }
}
