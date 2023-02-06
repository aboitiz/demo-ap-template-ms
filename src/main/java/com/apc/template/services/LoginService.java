package com.apc.template.services;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.LoginDTO;
import com.apc.template.model.LoginCredentials;
import com.apc.template.model.PersonalInformation;

public interface LoginService {

    PersonalInformation addUserInformation(PersonalInformation info);

    LoginCredentials addUserCredentials(LoginCredentials info);

    BaseResponse getUserLoginCredentials(LoginDTO credentials);

}
