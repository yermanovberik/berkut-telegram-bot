package com.example.berkuttelegram.service;

import com.example.berkuttelegram.dto.response.MessageResponseDto;
import com.example.berkuttelegram.models.User;

import java.util.List;

public interface MessageService {

    List<MessageResponseDto> getAllMessageByUser(String usernam);
}
