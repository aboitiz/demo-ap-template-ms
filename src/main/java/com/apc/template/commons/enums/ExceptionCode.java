package com.apc.template.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    UNEXPECTED_EXCEPTION(100,"Unexpected Error");

    private final int code;
    private final String description;
}
