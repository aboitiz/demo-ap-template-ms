package com.apc.template.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class APExceptionTest {
    private final String message = "FORBIDDEN";
    private final String code = "403";
    private final HttpStatus httpStatus = HttpStatus.FORBIDDEN;
    @Test
    void success_no_code() {
        APException exception = new APException(message,httpStatus);

        assertThat(exception.getHttpStatus()).isEqualTo(httpStatus);
        assertThat(exception.getMessage()).isEqualTo(message);
        assertThat(exception.getHttpStatus()).isInstanceOf(HttpStatus.class);
    }

    @Test
    void success_no_code_overloaded_constructor() {
        APException exception = new APException(code, message, httpStatus);

        assertThat(exception.getCode()).isEqualTo(code);
        assertThat(exception.getHttpStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(exception.getMessage()).isEqualTo(message);
        assertThat(exception.getHttpStatus()).isInstanceOf(HttpStatus.class);
    }
}
