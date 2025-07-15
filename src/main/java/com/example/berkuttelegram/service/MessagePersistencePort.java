package com.example.berkuttelegram.service;

import com.example.berkuttelegram.models.User;

public interface MessagePersistencePort {
    void save(User user, String message);
}

