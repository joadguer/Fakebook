package com.mycompany.app.user.exceptions;

public class UserAlreadyRegistered extends AuthException{
    public UserAlreadyRegistered(String message) {
        super(message);
    }   
}
