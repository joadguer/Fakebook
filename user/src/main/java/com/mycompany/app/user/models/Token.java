package com.mycompany.app.user.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    private String id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "expires_at")
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
