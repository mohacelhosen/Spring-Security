package com.mohacel.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = InappropriateDataException.class)
    public ResponseEntity<ExceptionInfo> inappropriateData(InappropriateDataException wrongData){
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setCode("w101");
        exceptionInfo.setMessage(wrongData.getMessage());

        return  new ResponseEntity<>(exceptionInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionInfo> usernameNotFoundException(UsernameNotFoundException usernameNotFoundException){
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setCode("w101");
        exceptionInfo.setMessage(usernameNotFoundException.getMessage());
        return  new ResponseEntity<>(exceptionInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
