package com.chatapp.chat_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.chat_backend.dto.LoginRequest;
import com.chatapp.chat_backend.dto.RegisterRequest;
import com.chatapp.chat_backend.model.User;
import com.chatapp.chat_backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){

        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

        boolean success = authService.login(request);

        if(success)
            return "Login Successful";

        return "Invalid Credentials";
    }
}