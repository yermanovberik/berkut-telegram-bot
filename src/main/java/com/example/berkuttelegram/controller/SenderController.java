package com.example.berkuttelegram.controller;

import com.example.berkuttelegram.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/send")
@RequiredArgsConstructor
public class SenderController {
    private final SenderService senderService;

    @PostMapping
    public void sendMessage(
            @RequestParam String message,
            Authentication authentication
    ) {
        senderService.sendMessage(authentication.getName(),message);
    }
}
