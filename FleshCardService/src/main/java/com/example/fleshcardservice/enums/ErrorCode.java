package com.example.fleshcardservice.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    TEST_EXCEPTION(100),
    VALIDATION_ERROR(900),
    INTERNAL_ERROR(999);


    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }
}
