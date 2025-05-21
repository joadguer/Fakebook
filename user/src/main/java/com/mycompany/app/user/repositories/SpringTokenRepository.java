package com.mycompany.app.user.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.app.user.exceptions.TokenNotFound;
import com.mycompany.app.user.models.Token;

@Repository
public class SpringTokenRepository implements TokenRepository{
    
    @Autowired
    private InnerSpringTokenRepository innerSpringTokenRepository;

    @Override
    public Token findById(String id) throws TokenNotFound {
        Token token = innerSpringTokenRepository.findById(id).orElseThrow(
            () -> TokenNotFound.notFound(id)
        );
        return token;
    }

    @Override
    public void save(Token token) {
        innerSpringTokenRepository.save(token);
    }

    @Override
    public void delete(String id) {
        innerSpringTokenRepository.deleteById(id);
    }
    
}


interface InnerSpringTokenRepository extends JpaRepository<Token, String> {

}