package com.mycompany.app.user.models;

import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mycompany.app.user.exceptions.InvalidEmail;
import com.mycompany.app.user.exceptions.InvalidPassword;

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
@Table(name = "users")
public class User {

    
    @Id
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
 
    private boolean validateMail() {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regex, this.email);
    }


    private boolean validatePassword() {
        return this.password != null && this.password.length() >= 8;
    }


    public void validate() throws Exception {
        if (!validateMail()) {
            throw new InvalidEmail();
        }
        if (!validatePassword()) {
            throw new InvalidPassword();
        }
    }

    public void updatePassword(String newPassword) throws InvalidPassword {
        if (newPassword == null || newPassword.length() < 8) {
            throw new InvalidPassword("Password must be at least 8 characters long");
        }
        this.password = BCrypt.hashpw(newPassword, BCrypt.gensalt());
    }

    public boolean verifyPassword(String yourPassword) {
        return BCrypt.checkpw(yourPassword, this.password);
    }

    public void encryptPassword(String password) {
        password = BCrypt.hashpw(this.password, BCrypt.gensalt());
    }

}
