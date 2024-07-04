package com.msp.chat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.msp.chat.model.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {
}