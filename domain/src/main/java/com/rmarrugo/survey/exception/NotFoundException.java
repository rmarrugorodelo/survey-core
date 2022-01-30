package com.rmarrugo.survey.exception;

public class NotFoundException extends GenericException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

}
