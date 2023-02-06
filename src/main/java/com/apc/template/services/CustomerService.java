package com.apc.template.services;

import com.apc.commons.response.BaseResponse;
import com.apc.template.commons.dto.CustomerRegisterDTO;
import com.apc.template.commons.dto.CustomerLoginDTO;

public interface CustomerService {

    BaseResponse login(CustomerLoginDTO creds);

    BaseResponse register(CustomerRegisterDTO customerRegisterDTO);
}
