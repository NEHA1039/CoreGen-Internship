package com.chatapp.chat_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chatapp.chat_backend.model.Message;

public interface MessageRepository extends MongoRepository<Message,String>{

    List<Message> findBySenderIdAndReceiverId(
            String senderId,
            String receiverId
    );
}
