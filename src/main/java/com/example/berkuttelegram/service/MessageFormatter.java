package com.example.berkuttelegram.service;

import com.example.berkuttelegram.models.User;

public interface MessageFormatter {
    String format(User user, String message);
}

