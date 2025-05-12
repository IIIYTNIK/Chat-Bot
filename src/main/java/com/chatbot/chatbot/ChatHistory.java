package com.chatbot.chatbot;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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



    public static List<Message> load(String username) throws IOException {
        Path userFile = historyPath.resolve(username + ".json");

        if (!Files.exists(userFile)) {
            return new ArrayList<>(); // Возвращаем пустой список, если файла нет
        }

        try (Reader reader = Files.newBufferedReader(userFile)) {
            return gson.fromJson(reader, new TypeToken<List<Message>>() {
            }.getType());
        } catch (IOException e) {
            System.err.println("Ошибка загрузки истории: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}