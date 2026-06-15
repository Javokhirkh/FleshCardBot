package com.example.fleshcardservice.exceptions;

import com.example.fleshcardservice.enums.ErrorCode;

public abstract class BaseException extends RuntimeException{
    public abstract ErrorCode errorType();
}
