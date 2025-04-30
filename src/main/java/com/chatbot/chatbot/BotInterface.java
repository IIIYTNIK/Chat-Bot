package com.chatbot.chatbot;

import java.util.List;

/**
 *  Интерфейс для чат-бота.
 * Позволяет легко заменить реализацию бота в будущем.
 */

public interface BotInterface {
    String respondTo(String message, String author);  // Ответ на сообщение
    List<Message> getHistory();
}
