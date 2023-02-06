package com.apc.template.commons.dto;

import com.apc.template.commons.enums.APIResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class BaseAPIResponseTest {
    @Test
    void success() {
        BaseAPIResponse responseDTO = new BaseAPIErrorResponse();
        responseDTO.setTimestamp(new Date().toString());
        responseDTO.setStatusCode(String.valueOf(APIResponse.SUCCESS.getCode()));
        responseDTO.setMessage(APIResponse.SUCCESS.getMessage());
        responseDTO.setData(new Object());

        assertThat(responseDTO.getTimestamp()).isNotNull();
        assertThat(responseDTO.getStatusCode()).isEqualTo(String.valueOf(APIResponse.SUCCESS.getCode()));
        assertThat(responseDTO.getMessage()).isEqualTo(APIResponse.SUCCESS.getMessage());
        assertThat(responseDTO.getData()).isInstanceOf(Object.class);
    }
}
