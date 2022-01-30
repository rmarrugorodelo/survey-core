package com.rmarrugo.survey.exception;

import lombok.Getter;

@Getter
public abstract class GenericException extends RuntimeException {

    private final ErrorCode errorCode;

    protected GenericException(ErrorCode errorCode) {
        super(errorCode.getReasonPhrase());
        this.errorCode = errorCode;
    }

    protected GenericException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode.getReasonPhrase(), throwable);
        this.errorCode = errorCode;
    }

}
