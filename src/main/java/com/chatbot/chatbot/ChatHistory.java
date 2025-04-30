package com.chatbot.chatbot;
import java.util.List;

/**
 * Управление историей сообщений: сохранение/загрузка.
 */
public class ChatHistory {
    private static final String HISTORY_DIR = "chat_history/";

    public static void saveToFile(List<Message> history, String username) {
        // Пример: сохраняем в JSON с помощью Gson
        // File: HISTORY_DIR + username + ".json"
    }

    public static List<Message> loadFromFile(String username) {
        // Загрузка из файла
        return null;  // TODO
    }
}
