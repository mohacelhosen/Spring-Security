package com.mohacel.security.exception;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(){}
    public UsernameNotFoundException(String message){super(message);}
}
