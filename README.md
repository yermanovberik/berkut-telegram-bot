# Berkut Telegram Messaging API

REST API для приёма сообщений и отправки их в Telegram-бота.

---

## Описание проекта

Этот сервис позволяет:

- Регистрировать пользователей с логином, паролем и именем.
- Генерировать токен для привязки Telegram-чата к пользователю.
- Принимать сообщения от пользователя через API и дублировать их в Telegram.
- Просматривать список всех сообщений пользователя.
- Авторизация через Basic Auth.

---

## Технологии

- Java 17
- Spring Boot 3
- Spring Security (Basic Auth)
- Spring Data JPA
- PostgreSQL / H2 (по желанию)
- Telegram Bots API
- OpenAPI (Swagger) для документации

---

## Как запустить

1. Клонировать репозиторий

```bash
git clone https://github.com/berikyerman/berkut-telegram.git
cd berkut-telegram
