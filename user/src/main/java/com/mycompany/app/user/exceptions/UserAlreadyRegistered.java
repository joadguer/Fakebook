package com.mycompany.app.user.exceptions;

public class UserAlreadyRegistered extends AuthException{
    
    public UserAlreadyRegistered() {
        super("User is already registered.");
    }

    public UserAlreadyRegistered(String message) {
        super(message);
}
}
