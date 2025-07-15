package com.example.berkuttelegram.service;

import com.example.berkuttelegram.dto.RegisterRequest;
import com.example.berkuttelegram.models.User;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserService {

    User getByUsername(String username);

    void register(RegisterRequest request);

    String generateTelegramToken(String username);
}
