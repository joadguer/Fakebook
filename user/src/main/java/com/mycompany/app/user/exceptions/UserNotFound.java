package com.mycompany.app.user.exceptions;

public class UserNotFound extends AuthException{
    public UserNotFound(String message) {
        super(message);
    }
}
