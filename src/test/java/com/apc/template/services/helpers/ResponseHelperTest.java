package com.apc.template.services.helpers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseHelperTest {

    @Test
    void success_200() {
        assertThat(ResponseHelper.getHttpStatus("200")).isEqualTo(HttpStatus.OK);
    }

    @Test
    void success_201() {
        assertThat(ResponseHelper.getHttpStatus("201")).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void success_400() {
        assertThat(ResponseHelper.getHttpStatus("400")).isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    void success_401() {
        assertThat(ResponseHelper.getHttpStatus("401")).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
    @Test
    void success_503() {
        assertThat(ResponseHelper.getHttpStatus("503")).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Test
    void success_default() {
        assertThat(ResponseHelper.getHttpStatus("500")).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
