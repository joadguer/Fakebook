package com.mycompany.app.user.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mycompany.app.user.exceptions.UserNotFound;
import com.mycompany.app.user.models.User;

@Repository
public class SpringUserRepository implements UserRepository {

    @Autowired
    private InnerSpringUserRepository innerSpringUserRepository;

    @Override
    public User find(String email) throws UserNotFound {
        return innerSpringUserRepository.findById(email)
                .orElseThrow(() -> new UserNotFound("User with email " + email + " not found."));
    }

    @Override
    public void save(User user){
        innerSpringUserRepository.save(user);
    }

    @Override
    public boolean exists(String email) {
        return innerSpringUserRepository.existsById(email);
    }

}
interface InnerSpringUserRepository extends JpaRepository<User, String> {

}