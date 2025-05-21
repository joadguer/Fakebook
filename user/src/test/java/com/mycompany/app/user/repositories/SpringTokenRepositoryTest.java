package com.mycompany.app.user.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.app.user.exceptions.TokenNotFound;
import com.mycompany.app.user.models.Token;

@SpringBootTest
public class SpringTokenRepositoryTest {
    
    @Autowired
    private TokenRepository tokenRepository;

    @Test
    public void testFindById() throws TokenNotFound {
        Token token = Token.generate(LocalDateTime.now().plusHours(1));
        tokenRepository.save(token);
        Token foundToken = tokenRepository.findById(token.getId());
        assertEquals(token.getId(), foundToken.getId());
    }

}
