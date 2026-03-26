package com.chatapp.chat_backend.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="messages")
public class Message {

    @Id
    private String id;

    private String senderId;

    private String receiverId;

    private String content;

    private Date timestamp;

}