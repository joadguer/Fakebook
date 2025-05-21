package com.mycompany.app.user.exceptions;

public class EmailNotFound extends AuthException{
    public EmailNotFound(String message) {
        super(message);
    }

    public static EmailNotFound notFound(String email) {
        return new EmailNotFound("Email not found: " + email);
    }
    
}
