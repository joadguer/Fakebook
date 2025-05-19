package com.mycompany.app.user.exceptions;

public class InvalidEmail extends AuthException{
    public InvalidEmail(String message) {
        super(message);
    }
}
