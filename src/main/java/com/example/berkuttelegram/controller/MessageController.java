package com.example.berkuttelegram.controller;

import com.example.berkuttelegram.dto.response.MessageResponseDto;
import com.example.berkuttelegram.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/messages")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<MessageResponseDto>> getMessages(
            Authentication auth
    ) {
        return ResponseEntity.ok(messageService.getAllMessageByUser(auth.getName()));
    }

}
