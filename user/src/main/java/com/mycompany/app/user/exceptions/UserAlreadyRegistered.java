package com.mycompany.app.user.exceptions;

public class UserAlreadyRegistered extends AuthException{
    
    public UserAlreadyRegistered() {
        super("User is already registered.");
    }

    public UserAlreadyRegistered(String message) {
        super(message);
    }

    public static UserAlreadyRegistered withEmail(String email) {
        return new UserAlreadyRegistered("User with email " + email + " is already registered.");
    }
}
