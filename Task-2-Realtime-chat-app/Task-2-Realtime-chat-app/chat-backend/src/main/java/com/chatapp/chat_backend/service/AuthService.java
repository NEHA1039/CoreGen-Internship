package com.chatapp.chat_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatapp.chat_backend.dto.LoginRequest;
import com.chatapp.chat_backend.dto.RegisterRequest;
import com.chatapp.chat_backend.model.User;
import com.chatapp.chat_backend.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User register(RegisterRequest request){

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(
                encoder.encode(request.getPassword())
        );

        return userRepository.save(user);
    }

    public boolean login(LoginRequest request){

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if(user == null)
            return false;

        return encoder.matches(
                request.getPassword(),
                user.getPassword()
        );
    }
}
