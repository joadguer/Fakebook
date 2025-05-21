package com.mycompany.app.user.repositories;

import com.mycompany.app.user.exceptions.TokenNotFound;
import com.mycompany.app.user.models.Token;

public interface TokenRepository {

    public Token findById(String id) throws TokenNotFound;

    public void save(Token token);

    public void delete(String id);

}
