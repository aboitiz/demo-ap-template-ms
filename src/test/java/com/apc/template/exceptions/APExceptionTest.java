package com.apc.template.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class APExceptionTest {
    @Test
    void success() {
        APException exception = new APException();
        exception.setCode(HttpStatus.CREATED.toString());
        exception.setHttpStatus(HttpStatus.CREATED);

        assertThat(exception.getCode()).isEqualTo(HttpStatus.CREATED.toString());
        assertThat(exception.getHttpStatus()).isInstanceOf(HttpStatus.class);
    }

    @Test
    void success_overloaded_constructor() {
        APException exception = new APException(HttpStatus.CREATED.toString(), HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);

        assertThat(exception.getCode()).isEqualTo(HttpStatus.CREATED.toString());
        assertThat(exception.getMessage()).isEqualTo(HttpStatus.CREATED.getReasonPhrase());
        assertThat(exception.getHttpStatus()).isInstanceOf(HttpStatus.class);
    }
}
