package com.mycompany.app.user.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class TokenTest {
    Random random = new Random();
    
    @Test
    public void testTokenCreation() {
        int randomInt = random.nextInt(100);
        LocalDateTime expiresAt = LocalDateTime.now().plusHours(randomInt);
        Token token = Token.generate(expiresAt);
        assertEquals(token.getExpiresAt(), expiresAt);
    }

    @Test
    public void testTokenExpiry() {
        int randomInt = random.nextInt(100);
        LocalDateTime expiresAt = LocalDateTime.now().plusHours(randomInt);
        Token token = Token.generate(expiresAt);
        assertEquals(token.verifyExpiry(), true);
    }
}