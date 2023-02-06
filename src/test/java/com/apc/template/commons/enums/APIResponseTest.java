package com.apc.template.commons.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APIResponseTest {
    @Test
    void success_200() {
        assertThat(APIResponse.SUCCESS.getCode()).isEqualTo(200);
        assertThat(APIResponse.SUCCESS.getError()).isEmpty();
        assertThat(APIResponse.SUCCESS.getMessage()).isEqualTo("SUCCESS");
        assertThat(APIResponse.SUCCESS.getDescription()).isEqualTo("The request was successful and the response body contains the representation requested.");
    }

    @Test
    void success_201() {
        assertThat(APIResponse.SUCCESS_CREATED.getCode()).isEqualTo(201);
        assertThat(APIResponse.SUCCESS_CREATED.getError()).isEmpty();
        assertThat(APIResponse.SUCCESS_CREATED.getMessage()).isEqualTo("CREATED");
        assertThat(APIResponse.SUCCESS_CREATED.getDescription()).isEqualTo("The request has been fulfilled, resulting in the creation of a new resource");
    }

    @Test
    void success_500() {
        assertThat(APIResponse.GENERAL_DECLINE.getCode()).isEqualTo(500);
        assertThat(APIResponse.GENERAL_DECLINE.getError()).isEqualTo("UNEXPECTED_ERROR");
        assertThat(APIResponse.GENERAL_DECLINE.getMessage()).isEqualTo("An internal server error occurred. Please contact your administrator.");
        assertThat(APIResponse.GENERAL_DECLINE.getDescription()).isEqualTo("The request was failed due to unexpected error");
    }
}
