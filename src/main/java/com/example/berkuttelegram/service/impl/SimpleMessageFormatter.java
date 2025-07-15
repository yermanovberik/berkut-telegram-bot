package com.example.berkuttelegram.service.impl;

import com.example.berkuttelegram.models.User;
import com.example.berkuttelegram.service.MessageFormatter;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageFormatter implements MessageFormatter {
    @Override
    public String format(User user, String message) {
        return user.getName() + ", я получил от тебя сообщение:\n" + message;
    }
}
