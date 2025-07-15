package com.example.berkuttelegram.dto.response;

import java.time.LocalDateTime;

public record MessageResponseDto(
        String text,
        LocalDateTime sentAt
) {}
