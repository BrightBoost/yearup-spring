package com.yearup.demo.services;

import com.yearup.demo.models.Message;
import com.yearup.demo.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return this.messageRepository.findAll();
    }
}
