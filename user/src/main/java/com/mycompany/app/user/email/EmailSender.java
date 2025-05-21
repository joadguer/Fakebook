package com.mycompany.app.user.email;

import com.mycompany.app.user.exceptions.EmailNotFound;

public interface EmailSender {

    public void send(String email, String subject, String message) throws EmailNotFound;

}
