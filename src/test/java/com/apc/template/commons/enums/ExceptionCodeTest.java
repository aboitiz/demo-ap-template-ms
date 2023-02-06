package com.apc.template.commons.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExceptionCodeTest {
    @Test
    void success_unexpected_exception() {
        assertThat(ExceptionCode.UNEXPECTED_EXCEPTION.getCode()).isEqualTo(100);
        assertThat(ExceptionCode.UNEXPECTED_EXCEPTION.getDescription()).isEqualTo("Unexpected Error");
    }
}
