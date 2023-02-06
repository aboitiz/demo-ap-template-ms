package com.apc.template.controller;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.constants.APIPathConstants;
import com.apc.template.commons.dto.LoginDTO;
import com.apc.template.config.SwaggerConfiguration;
import com.apc.template.model.LoginCredentials;
import com.apc.template.model.PersonalInformation;
import com.apc.template.services.LoginService;
import com.apc.template.services.helpers.ResponseHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = SwaggerConfiguration.LOGIN)
@RequestMapping(APIPathConstants.API_VERSION_1)
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/AddUserInformation")
    public ResponseEntity savePersonalInformation(@RequestBody PersonalInformation info){
        return new ResponseEntity<>(loginService.addUserInformation(info), HttpStatus.CREATED);
    }
    @PostMapping("/AddUserCredentials")
    public ResponseEntity saveUserCredentials(@RequestBody LoginCredentials info){
        return new ResponseEntity<>(loginService.addUserCredentials(info), HttpStatus.CREATED);
    }

    @PostMapping("/Login")
    public ResponseEntity getUserInformation(@RequestBody @Valid LoginDTO credentials){
        BaseResponse response = loginService.getUserLoginCredentials(credentials);
        return new ResponseEntity<>(response, ResponseHelper.getHttpStatus(response.getStatusCode()));
    }
}
