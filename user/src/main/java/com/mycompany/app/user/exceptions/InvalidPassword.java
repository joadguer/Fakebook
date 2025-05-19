package com.mycompany.app.user.exceptions;

public class InvalidPassword extends AuthException{
    public InvalidPassword(String message) {
        super(message);
    }
}
