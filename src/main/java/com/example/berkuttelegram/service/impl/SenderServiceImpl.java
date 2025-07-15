package com.example.berkuttelegram.service.impl;

import com.example.berkuttelegram.models.Messages;
import com.example.berkuttelegram.models.User;
import com.example.berkuttelegram.repository.MessageRepository;
import com.example.berkuttelegram.repository.UserRepository;
import com.example.berkuttelegram.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SenderServiceImpl implements SenderService {
    private final UserService userService;
    private final TelegramBot telegramBot;
    private final MessageFormatter messageFormatter;
    private final MessagePersistencePort messagePersistence;
    @Override
    public void sendMessage(String username, String message) {
        User user = userService.getByUsername(username);
        if (user.getChatId() == null) {
            throw new IllegalStateException("Telegram чат не привязан");
        }
        String formatted = messageFormatter.format(user, message);
        telegramBot.sendMessage(user.getChatId(), formatted);
        messagePersistence.save(user, message);
    }
}
