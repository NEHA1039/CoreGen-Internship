package com.chatapp.chat_backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chatapp.chat_backend.model.User;

public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByEmail(String email);

}