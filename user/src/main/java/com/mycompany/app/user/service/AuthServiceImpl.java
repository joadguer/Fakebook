package com.mycompany.app.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycompany.app.user.email.EmailSender;
import com.mycompany.app.user.exceptions.AuthException;
import com.mycompany.app.user.exceptions.InvalidPassword;
import com.mycompany.app.user.exceptions.InvalidToken;
import com.mycompany.app.user.exceptions.UserAlreadyRegistered;
import com.mycompany.app.user.models.Token;
import com.mycompany.app.user.models.User;
import com.mycompany.app.user.repositories.TokenRepository;
import com.mycompany.app.user.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
    @Value("{FORGOT_PASSWORD_LINK}")
    private String FORGOT_PASSWORD_LINK;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public void signUp(String email, String password) throws AuthException{
        if (userRepository.exists(email)) throw UserAlreadyRegistered.withEmail(email);
        User user = User.builder().email(email).password(password).build();
        userRepository.save(user);
    }

    @Override
    public void signIn(String email, String password) throws AuthException{
        User user = userRepository.find(email);
        if (!user.verifyPassword(password)) throw new InvalidPassword();
    }

    @Override
    public void changePassword(String email, String password) throws AuthException{
        User user = userRepository.find(email);
        user.updatePassword(password);
        userRepository.save(user);
    }

    @Override
    public void verifyForgotPasswordToken(String tokenId) throws AuthException{
        Token token = tokenRepository.findById(tokenId);
        tokenRepository.delete(tokenId);
        if (!token.verifyExpiry()) throw InvalidToken.invalid(tokenId);
    }

    @Override
    public void sendForgotPasswordEmail(String email) throws AuthException{
        Token token = Token.generate(LocalDateTime.now().plusMinutes(30));
        String subject = "Password Reset Request";
        String body = "Click the link to reset your password: " + FORGOT_PASSWORD_LINK + token.getId();
        emailSender.send(email, subject, body);
        tokenRepository.save(token);
    }
    
}
