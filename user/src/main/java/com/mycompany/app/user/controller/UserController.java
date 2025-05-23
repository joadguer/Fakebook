package com.mycompany.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.app.user.exceptions.AuthException;
import com.mycompany.app.user.http.request.AuthRequestBody;
import com.mycompany.app.user.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<Boolean> signUp(@Valid @RequestBody AuthRequestBody signUpRequestBody) throws AuthException{
        authService.signUp(signUpRequestBody.getEmail(), signUpRequestBody.getPassword());
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Boolean> signIn(@Valid @RequestBody AuthRequestBody signUpRequestBody) throws AuthException{
        authService.signIn(signUpRequestBody.getEmail(), signUpRequestBody.getPassword());
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/password")
    public ResponseEntity<Boolean> changePassword(@Valid @RequestBody AuthRequestBody signUpRequestBody) throws AuthException{
        authService.changePassword(signUpRequestBody.getEmail(), signUpRequestBody.getPassword());
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/token/forgot/{tokenId}")
    public ResponseEntity<Boolean> verifyForgotPasswordToken(@Valid @PathVariable String tokenId) throws AuthException{
        authService.verifyForgotPasswordToken(tokenId);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/token/forgot/{email}")
    public ResponseEntity<Boolean> sendForgotPasswordEmail(@Valid @PathVariable String email) throws AuthException{
        authService.sendForgotPasswordEmail(email);
        return ResponseEntity.status(200).build();
    }
}
