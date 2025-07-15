package com.example.berkuttelegram.service;

import com.example.berkuttelegram.config.properties.TelegramBotConfig;
import com.example.berkuttelegram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final TelegramBotConfig config;
    private final UserRepository userRepository;

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String token = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            userRepository.findByTelegramToken(token).ifPresentOrElse(user -> {
                user.setChatId(chatId);
                userRepository.save(user);
                sendMessage(chatId, "✅ Бот успешно привязан к вашему аккаунту!");
            }, () -> {
                sendMessage(chatId, "❌ Токен не найден. Сначала сгенерируйте токен через API.");
            });
        }
    }

    public void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage(chatId.toString(), text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}