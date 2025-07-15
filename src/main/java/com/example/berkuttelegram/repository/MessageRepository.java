package com.example.berkuttelegram.repository;

import com.example.berkuttelegram.models.Messages;
import com.example.berkuttelegram.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {

    List<Messages> findAllByUser(User user);
}
