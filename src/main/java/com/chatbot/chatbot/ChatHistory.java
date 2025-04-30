package com.chatbot.chatbot;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import com.google.gson.Gson;

/**
 * Управление историей сообщений: сохранение/загрузка.
 */
public class ChatHistory {
    private static final String HISTORY_DIR = "chat_history/";
    private static final Gson gson = new Gson();
    private static final Path historyPath = Paths.get(HISTORY_DIR);

    public static void save(List<Message> history, String username) throws IOException {
        // Создаем директорию, если не существует
        if (!Files.exists(historyPath)) {
            Files.createDirectories(historyPath);
        }

        Path userFile = historyPath.resolve(username + ".json");
        try (Writer writer = Files.newBufferedWriter(userFile)) {
            gson.toJson(history, writer);
        }
    }


    public static List<Message> load(String username) {
        return null;
    }
}
