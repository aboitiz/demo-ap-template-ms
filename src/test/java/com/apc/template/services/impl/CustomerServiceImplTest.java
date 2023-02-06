package com.apc.template.services.impl;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.CustomerLoginDTO;
import com.apc.template.commons.dto.CustomerRegisterDTO;
import com.apc.template.model.Customer;
import com.apc.template.model.CustomerAuth;
import com.apc.template.repository.CustomerAuthRepository;
import com.apc.template.repository.CustomerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerAuthRepository customerAuthRepository;

    @Spy
    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void success_register() throws Exception {
        CustomerAuth customerAuth = new CustomerAuth("test","password");
        when(customerAuthRepository.save(Mockito.any(CustomerAuth.class))).thenReturn(customerAuth);

        Customer customer = new Customer(customerAuth.getId(),"test", "user",
                new Date(2011, 2, 5) ,"vdc");
        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO(customerAuth.getUsername(),
                customerAuth.getPassword(), customer.getFirstName(), customer.getLastName(),
                customer.getBirthDate(), customer.getAddress());

        BaseResponse response = customerService.register(registerDTO);

        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void failure_register_invalid_Auth(){
        CustomerAuth customerAuth = new CustomerAuth("test","password");
        when(customerAuthRepository.save(Mockito.any())).thenReturn(new IllegalStateException());

        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO(customerAuth.getUsername(),
                customerAuth.getPassword(), "test", "test",
                new Date(), "test");

        BaseResponse response = customerService.register(registerDTO);

        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    void failure_register_invalid_customerInfo(){
        CustomerAuth customerAuth = new CustomerAuth("test","password");
        when(customerAuthRepository.save(Mockito.any(CustomerAuth.class))).thenReturn(customerAuth);

        Customer customer = new Customer(customerAuth.getId(),"test", "user",
                new Date(2011, 2, 5) ,"vdc");
        when(customerRepository.save(Mockito.any())).thenReturn(new IllegalStateException());

        CustomerRegisterDTO registerDTO = new CustomerRegisterDTO(customerAuth.getUsername(),
                customerAuth.getPassword(), customer.getFirstName(), customer.getLastName(),
                customer.getBirthDate(), customer.getAddress());

        BaseResponse response = customerService.register(registerDTO);

        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @Test
    void success_login(){
        CustomerAuth customerAuth = new CustomerAuth("test","password");
        when(customerAuthRepository.getByUsernameAndPassword(Mockito.anyString(),
                Mockito.anyString())).thenReturn(customerAuth);

        CustomerLoginDTO loginDTO = new CustomerLoginDTO();
        loginDTO.setPassword(customerAuth.getPassword());
        loginDTO.setUsername(customerAuth.getUsername());

        BaseResponse response = customerService.login(loginDTO);

        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void failure_login(){
        CustomerAuth customerAuth = new CustomerAuth("test","password");
        CustomerLoginDTO loginDTO = new CustomerLoginDTO();
        loginDTO.setPassword(customerAuth.getPassword());
        loginDTO.setUsername(customerAuth.getUsername());

        BaseResponse response = customerService.login(loginDTO);

        assertThat(Integer.parseInt(response.getStatusCode())).isEqualTo(HttpStatus.UNAUTHORIZED.value());
    }
}
