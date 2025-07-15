package com.example.berkuttelegram.service.impl;

import com.example.berkuttelegram.models.Messages;
import com.example.berkuttelegram.models.User;
import com.example.berkuttelegram.repository.MessageRepository;
import com.example.berkuttelegram.service.MessagePersistencePort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageJpaAdapter implements MessagePersistencePort {
    private final MessageRepository messageRepository;

    public MessageJpaAdapter(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void save(User user, String message) {
        Messages msg = new Messages(user, message, LocalDateTime.now());
        messageRepository.save(msg);
    }
}
