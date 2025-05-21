package com.mycompany.app.user.exceptions;

public class InvalidEmail extends AuthException{
    public InvalidEmail() {
        super("Invalid email.");
    }

    // Constructor con mensaje personalizado
    public InvalidEmail(String message) {
        super(message);
}
}