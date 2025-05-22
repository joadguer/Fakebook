package com.mycompany.app.user.exceptions;

public class InvalidToken extends AuthException{
    public InvalidToken(String message) {
        super(message);
    }

    public static InvalidToken invalid(String token) {
        return new InvalidToken("Invalid token: " + token);
    }

}
