package com.mycompany.app.user.exceptions;

public class TokenNotFound extends AuthException{
    
    public TokenNotFound(String message) {
        super(message);
    }

    public static TokenNotFound notFound(String id) {
        return new TokenNotFound("Token with ID " + id + " not found.");
    }
    
}
