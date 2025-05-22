package com.mycompany.app.user.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mycompany.app.user.exceptions.EmailNotFound;

@Service
public class SpringEmailSender implements EmailSender{
    
    @Autowired
    private JavaMailSender mailSender;

    @Value("${EMAIL_USERNAME}")
    private String emailFrom;

    @Override
    public void send(String email, String subject, String message) throws EmailNotFound{
        try {
            sendMail(email, subject, message);
        } catch (Exception e) {
            throw EmailNotFound.notFound(email);
        }
    }

    private void sendMail(String email, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(emailFrom);
        mailSender.send(mailMessage);
    }

}
