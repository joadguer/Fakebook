package com.mycompany.app.user.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class Token {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public boolean verifyExpiry() {
        return LocalDateTime.now().isBefore(expiresAt);
    }

    public static Token generate(LocalDateTime expiresAt) {
        return Token.builder()
                .id(java.util.UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .expiresAt(expiresAt)
                .build();
    }
}
