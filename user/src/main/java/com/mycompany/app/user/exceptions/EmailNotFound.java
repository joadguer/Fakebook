package com.mycompany.app.user.exceptions;

public class EmailNotFound extends AuthException{
    public EmailNotFound() {
        super("Email not found.");
    }

    public EmailNotFound(String message) {
        super(message);
    }
}
