package com.mycompany.app.user.models;

import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mycompany.app.user.exceptions.AuthException;
import com.mycompany.app.user.exceptions.InvalidEmail;
import com.mycompany.app.user.exceptions.InvalidPassword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Builder
    public User(String email, String password) throws AuthException {
        this.email = email;
    
        validate(password);
        this.password = encryptPassword(password);
    }

    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
 
    private boolean validateMail() {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, this.email);
    }


    private boolean validatePassword(String password) {
        return  password.length() >= 8;
    }


    private void validate(String password) throws AuthException {
        if (!validateMail()) {
            throw new InvalidEmail();
        }
        if (!validatePassword(password)) {
            throw new InvalidPassword();
        }
    }

    public void updatePassword(String newPassword) throws InvalidPassword {
        if (newPassword.length() < 8) {
            throw new InvalidPassword("Password must be at least 8 characters long");
        }
            this.password = encryptPassword(newPassword);
        }

    public boolean verifyPassword(String password) {
        return BCrypt.checkpw(password, this.password);
    }
    
    private String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
