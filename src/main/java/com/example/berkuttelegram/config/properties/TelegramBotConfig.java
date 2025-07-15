package com.example.berkuttelegram.config.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "telegram.bot")
@ComponentScan
@Data
public class TelegramBotConfig {
    private String token;
    private String username;
}
