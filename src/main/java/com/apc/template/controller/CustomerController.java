package com.apc.template.controller;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.constants.APIPathConstants;
import com.apc.template.commons.dto.CustomerLoginDTO;
import com.apc.template.commons.dto.CustomerRegisterDTO;
import com.apc.template.config.SwaggerConfiguration;
import com.apc.template.services.CustomerService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(APIPathConstants.API_VERSION_1)
@Api(tags = {SwaggerConfiguration.CUSTOMER_TAG})
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(APIPathConstants.CUSTOMER_BASE_PATH + "/login")
    public ResponseEntity<BaseResponse> customerLogin(@RequestBody @Valid CustomerLoginDTO cred){
        BaseResponse<?> response = customerService.login(cred);
        HttpStatus status = HttpStatus.OK;
        if(!response.getStatusCode().equals("200")){
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<>(response, status);
    }

    @PostMapping(APIPathConstants.CUSTOMER_BASE_PATH + "/register")
    public ResponseEntity<BaseResponse> customerRegister(@RequestBody @Valid CustomerRegisterDTO customer){
        BaseResponse<?> response = customerService.register(customer);
        HttpStatus status = HttpStatus.CREATED;
        if(!response.getStatusCode().equals("201")){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }
}
