package com.mycompany.app.user.repositories;

import com.mycompany.app.user.exceptions.UserAlreadyRegistered;
import com.mycompany.app.user.exceptions.UserNotFound;
import com.mycompany.app.user.models.User;

public interface UserRepository {
    User find(String email) throws UserNotFound;
    void save(User user) throws UserAlreadyRegistered;
    boolean exists(String email);
}
