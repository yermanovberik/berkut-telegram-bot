package com.example.berkuttelegram.service.impl;

import com.example.berkuttelegram.dto.response.MessageResponseDto;
import com.example.berkuttelegram.models.User;
import com.example.berkuttelegram.repository.MessageRepository;
import com.example.berkuttelegram.service.MessageService;
import com.example.berkuttelegram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final UserService userService;

    private final MessageRepository messageRepository;

    public List<MessageResponseDto> getAllMessageByUser(String username) {
        User user = userService.getByUsername(username);
        return messageRepository.findAllByUser(user).stream()
                .map(message -> new MessageResponseDto(
                        message.getText(),
                        message.getSentAt()
                ))
                .toList();
    }

}
