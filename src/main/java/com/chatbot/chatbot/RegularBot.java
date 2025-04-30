package com.chatbot.chatbot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Чат-бот, обрабатывающий команды через регулярные выражения.
 */

public class RegularBot  implements BotInterface{
    private List<Message> history = new ArrayList<>();

    @Override
    public String respondTo(String message, String author) {
        // Сохраняем сообщение пользователя в историю
        history.add(new Message(author, message));

        // Обработка команд
        if (message.equalsIgnoreCase("/help")) {
            return "Доступные команды:\n" +
                    "/help - список команд\n" +
                    "Привет - поздороваться\n" +
                    "Который час? - текущее время\n" +
                    "умножь X на Y - произведение чисел";
        }
        else if (message.matches("(?i)привет.*")) {
            return "Привет, " + author + "!";
        }
        else if (message.matches("(?i)который час\\??")) {
            return "Сейчас " + LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        }
        else if (message.matches("(?i)умножь \\d+ на \\d+")) {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                int x = Integer.parseInt(matcher.group());
                if (matcher.find()) {
                    int y = Integer.parseInt(matcher.group());
                    return String.format("%d * %d = %d", x, y, x * y);
                }
            }
        }

        return "Не понимаю. Напишите /help для списка команд.";
    }

    @Override
    public void saveHistoryToFile(String username) {
        // TODO: Реализовать сохранение в JSON/CSV
    }

    @Override
    public void loadHistoryFromFile(String username) {
        // TODO: Загрузка из файла
    }
}



