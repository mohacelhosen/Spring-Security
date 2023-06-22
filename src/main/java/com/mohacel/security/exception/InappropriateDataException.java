package com.mohacel.security.exception;

public class InappropriateDataException extends RuntimeException{
    public InappropriateDataException(){}
    public InappropriateDataException(String message){
        super(message);
    }

}
