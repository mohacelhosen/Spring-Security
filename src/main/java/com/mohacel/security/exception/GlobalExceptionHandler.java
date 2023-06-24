package com.mohacel.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
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

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionInfo> userNotFoundException(UserNotFoundException userNotFoundException){
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setMessage(userNotFoundException.getMessage());
        exceptionInfo.setCode("N-102");
        return  new ResponseEntity<>(exceptionInfo, HttpStatus.BAD_REQUEST);
    }


    //Access Denied
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        String message="░░▄▀░░░░░░░░░░░░░░░▀▀▄▄░░░░░ \n" +
                "░░▄▀░░░░░░░░░░░░░░░░░░░░▀▄░░░ \n" +
                "░▄▀░░░░░░░░░░░░░░░░░░░░░░░█░░ \n" +
                "░█░░░░░░░░░░░░░░░░░░░░░░░░░█░ \n" +
                "▐░░░░░░░░░░░░░░░░░░░░░░░░░░░█ \n" +
                "█░░░░▀▀▄▄▄▄░░░▄▌░░░░░░░░░░░░▐ \n" +
                "▌░░░░░▌░░▀▀█▀▀░░░▄▄░░░░░░░▌░▐ \n" +
                "▌░░░░░░▀▀▀▀░░░░░░▌░▀██▄▄▄▀░░▐ \n" +
                "▌░░░░░░░░░░░░░░░░░▀▄▄▄▄▀░░░▄▌ \n" +
                "▐░░░░▐░░░░░░░░░░░░░░░░░░░░▄▀░ \n" +
                "░█░░░▌░░▌▀▀▀▄▄▄▄░░░░░░░░░▄▀░░ \n" +
                "░░█░░▀░░░░░░░░░░▀▌░░▌░░░█░░░░ \n" +
                "░░░▀▄░░░░░░░░░░░░░▄▀░░▄▀░░░░░ \n" +
                "░░░░░▀▄▄▄░░░░░░░░░▄▄▀▀░░░░░░░ \n" +
                "░░░░░░░░▐▌▀▀▀▀▀▀▀▀░░░░░░░░░░░ \n" +
                "░░░░░░░░█░░░░░░░░░░░░░░░░░░░░ \n" +
                "░░╔═╗╔═╗╔═╗░░░░░║░║╔═╗║░║░░░░ \n" +
                "░░╠═╣╠╦╝╠╣░░░░░░╚╦╝║░║║░║░░░░ \n" +
                "░░║░║║╚═╚═╝░░░░░░║░╚═╝╚═╝░░░░ \n" +
                "║╔═░╦░╦═╗╦═╗╦╔╗║╔═╗░░╔╦╗╔═╗╔╗ \n" +
                "╠╩╗░║░║░║║░║║║║║║═╗░░║║║╠╣░╔╝ \n" +
                "║░╚░╩░╩═╝╩═╝╩║╚╝╚═╝░░║║║╚═╝▄░ ";
        return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
    }
}
