package com.apc.template.services.impl;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.LoginDTO;
import com.apc.template.model.LoginCredentials;
import com.apc.template.model.PersonalInformation;
import com.apc.template.repository.LoginCredentialsRepository;
import com.apc.template.repository.PersonalInformationRepository;
import com.apc.template.services.LoginService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class LoginImpl implements LoginService {
    @Autowired
    private PersonalInformationRepository personalinformation;

    @Autowired
    private LoginCredentialsRepository logincredentials;

    @Override
    public PersonalInformation addUserInformation(PersonalInformation info){
        PersonalInformation information = null;
        try{
            information = personalinformation.save(info);
            log.info("Successfully saved personal information ");
        }catch (Exception e){
            log.info("Fail to execute API. Reason {} ", e.getMessage());
        }
        return information;
    }

    @Override
    public LoginCredentials addUserCredentials(LoginCredentials info){
        LoginCredentials credentials = null;
        try{
            credentials = logincredentials.save(info);
            log.info("Successfully saved user credentials ");
        }catch (Exception e){
            log.info("Fail to execute API. Reason {} ", e.getMessage());
        }
        return credentials;
    }

    @Override
    public BaseResponse<?> getUserLoginCredentials(LoginDTO credentials){
        LoginCredentials user_creds = logincredentials.getUserCred(credentials.getUsername(), credentials.getPassword());
        if (user_creds != null){
            PersonalInformation personal_info = personalinformation.getUserInfo(user_creds.getUserId());
            return new BaseResponse<>(personal_info).setStatusCodeMessage(String.valueOf(HttpStatus.ACCEPTED.value()),
                    HttpStatus.ACCEPTED.getReasonPhrase());
        }else {
            log.info("Login Failed! : user cannot be found.");
            return new BaseResponse<>().setStatusCodeMessage(String.valueOf(HttpStatus.UNAUTHORIZED.value()),
                    HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }

    }

}
