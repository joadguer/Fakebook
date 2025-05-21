package com.mycompany.app.user.exceptions;

public class UserNotFound extends AuthException{
    public UserNotFound() {
        super("User not found.");
    }

    public UserNotFound(String message) {
        super(message);
    }
}
