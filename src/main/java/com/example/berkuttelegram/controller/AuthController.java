package com.example.berkuttelegram.controller;

import com.example.berkuttelegram.dto.RegisterRequest;
import com.example.berkuttelegram.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Valid RegisterRequest request) {
        userService.register(request);

        Map<String, String> response = Map.of(
                "message", "Регистрация успешна",
                "telegramBotLink", "https://t.me/berkut_telegram_messagin_bot"
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/telegram/token")
    public ResponseEntity<Map<String, String>> generateTelegramToken(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = userService.generateTelegramToken(authentication.getName());
        return ResponseEntity.ok(Map.of("telegramToken", token));
    }


}
