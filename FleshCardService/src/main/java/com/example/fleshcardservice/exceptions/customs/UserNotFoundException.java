package com.example.fleshcardservice.exceptions.customs;

import com.example.fleshcardservice.enums.ErrorCode;
import com.example.fleshcardservice.exceptions.BaseException;

public class UserNotFoundException extends BaseException {

    @Override
    public ErrorCode errorType() {
        return ErrorCode.USER_NOT_FOUND;
    }
}
