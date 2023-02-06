package com.apc.template.commons.dto;

import com.apc.template.commons.enums.APIResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BaseAPIErrorResponseTest {
    @Test
    void success() {
        BaseAPIErrorResponse baseAPIErrorResponseDTO = new BaseAPIErrorResponse();
        baseAPIErrorResponseDTO.setError("Sample Error");
        baseAPIErrorResponseDTO.setTimestamp(new Date().toString());
        baseAPIErrorResponseDTO.setMessage(APIResponse.GENERAL_DECLINE.getMessage());
        baseAPIErrorResponseDTO.setStatusCode(String.valueOf(APIResponse.GENERAL_DECLINE.getCode()));
        baseAPIErrorResponseDTO.setData(new Object());

        assertThat(baseAPIErrorResponseDTO.getError()).isEqualTo("Sample Error");
        assertThat(baseAPIErrorResponseDTO.getTimestamp()).isNotNull();
        assertThat(baseAPIErrorResponseDTO.getStatusCode()).isEqualTo(String.valueOf(APIResponse.GENERAL_DECLINE.getCode()));
        assertThat(baseAPIErrorResponseDTO.getMessage()).isEqualTo(APIResponse.GENERAL_DECLINE.getMessage());
        assertThat(baseAPIErrorResponseDTO.getData()).isInstanceOf(Object.class);
    }

    @Test
    void success_overloading_constructor() {
        BaseAPIErrorResponse baseAPIErrorResponseDTO = new BaseAPIErrorResponse(
                new Date().toString(),
                String.valueOf(APIResponse.GENERAL_DECLINE.getCode()),
                "Sample Error",
                APIResponse.GENERAL_DECLINE.getMessage(),
                new Object()
        );

        assertThat(baseAPIErrorResponseDTO.getError()).isEqualTo("Sample Error");
        assertThat(baseAPIErrorResponseDTO.getTimestamp()).isNotNull();
        assertThat(baseAPIErrorResponseDTO.getStatusCode()).isEqualTo(String.valueOf(APIResponse.GENERAL_DECLINE.getCode()));
        assertThat(baseAPIErrorResponseDTO.getMessage()).isEqualTo(APIResponse.GENERAL_DECLINE.getMessage());
        assertThat(baseAPIErrorResponseDTO.getData()).isInstanceOf(Object.class);
    }
}
