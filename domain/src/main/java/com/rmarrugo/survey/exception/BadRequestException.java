package com.rmarrugo.survey.exception;

public class BadRequestException extends GenericException{

    public BadRequestException(ErrorCode errorCode){
        super(errorCode);
    }

    public BadRequestException(ErrorCode errorCode, Throwable throwable){
        super(errorCode, throwable);
    }

}
