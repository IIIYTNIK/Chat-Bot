package com.chatbot.chatbot;

/**
 *  Интерфейс для чат-бота.
 * Позволяет легко заменить реализацию бота в будущем.
 */

public interface BotInterface {
    String respondTo(String message, String author);  // Ответ на сообщение
    void saveHistoryToFile(String username);          // Сохранение истории в файл
    void loadHistoryFromFile(String username);        // Загрузка истории из файла

}
