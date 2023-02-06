package com.apc.template.services.impl;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.CustomerRegisterDTO;
import com.apc.template.commons.dto.CustomerLoginDTO;
import com.apc.template.exceptions.APException;
import com.apc.template.model.Customer;
import com.apc.template.model.CustomerAuth;
import com.apc.template.repository.CustomerAuthRepository;
import com.apc.template.repository.CustomerRepository;
import com.apc.template.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAuthRepository customerAuthRepository;

    @Override
    public BaseResponse<?> login(CustomerLoginDTO creds){
        log.info("Username: " + creds.getUsername() + " Password: "+creds.getPassword());
        CustomerAuth customerCreds = customerAuthRepository.getByUsernameAndPassword(creds.getUsername(),
               creds.getPassword());
        if(customerCreds != null){
            Customer customer = customerRepository.findByCustomerAuthId(customerCreds.getId());
            return new BaseResponse<>(customer).setStatusCodeMessage(String.valueOf(HttpStatus.OK.value()),
                    HttpStatus.OK.getReasonPhrase());
        }else{
            log.error("login failed: user not found");
            return new BaseResponse<>().setStatusCodeMessage(String.valueOf(HttpStatus.UNAUTHORIZED.value()),
                    HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }
    }

    @Override
    public BaseResponse<?> register(CustomerRegisterDTO customerRegisterDTO){
        Customer customer = new Customer();
        CustomerAuth customerAuth = new CustomerAuth();
        Long customerAuthId = 0L;
        //save credentials
        try {
            customerAuth.setUsername(customerRegisterDTO.getUsername());
            customerAuth.setPassword(customerRegisterDTO.getPassword());
            customerAuth.setCreatedAt(new Date());
            customerAuthId = customerAuthRepository.save(customerAuth).getId();
            log.info("Auth creation ok");
        } catch (Exception e) {
            log.error("Error Auth Creation: {}", e.getMessage());
            return new BaseResponse<>().setStatusCodeMessage(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }

        //save customer info
        try {
            customer.setCustomerAuthId(customerAuthId);
            customer.setFirstName(customerRegisterDTO.getFirstName());
            customer.setLastName(customerRegisterDTO.getLastName());
            customer.setBirthDate(customerRegisterDTO.getBirthDate());
            customer.setAddress(customerRegisterDTO.getAddress());
            customer.setCreatedAt(new Date());
            customerRepository.save(customer);
            return new BaseResponse<>(customerRegisterDTO).setStatusCodeMessage(String.valueOf(HttpStatus.CREATED.value()),
                    HttpStatus.CREATED.getReasonPhrase());
        } catch (Exception e) {
            log.error("Error Customer Info Creation: {}", e.getMessage());
            return new BaseResponse<>().setStatusCodeMessage(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                    HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }
}
