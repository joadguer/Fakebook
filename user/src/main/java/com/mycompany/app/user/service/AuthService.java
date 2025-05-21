package com.mycompany.app.user.service;

import com.mycompany.app.user.exceptions.AuthException;

public interface AuthService {

    public void signUp(String email, String password) throws AuthException;

    public void signIn(String email, String password) throws AuthException;

    public void changePassword(String email, String password) throws AuthException;

    public void verifyForgotPasswordToken(String tokenId) throws AuthException;

    public void sendForgotPasswordEmail(String email) throws AuthException;

}
