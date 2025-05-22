package com.mycompany.app.user.exceptions;

public class AuthException extends Exception{
    public AuthException() {
        super("Authentication error occurred.");
    }

    public AuthException(String message) {
        super(message);
    }

 


}
