package com.example.fleshcardservice.exceptions.customs;

import com.example.fleshcardservice.enums.ErrorCode;
import com.example.fleshcardservice.exceptions.BaseException;

public class exceptions extends BaseException {
    @Override
    public ErrorCode errorType() {
        return ErrorCode.TEST_EXCEPTION;
    }
}
