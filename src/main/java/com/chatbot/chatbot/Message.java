package com.chatbot.chatbot;

import java.time.LocalDateTime;

/**
 * Класс для хранения данных о сообщении: автор, текст, время.
 */
public class Message {
    private String author;
    private String text;
    private LocalDateTime timestamp;

    public Message(String author, String text) {
        this.author = author;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    // Геттеры и toString()
    public String getAuthor() { return author; }
    public String getText() { return text; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s",
                timestamp.toString(), author, text);
    }
}
