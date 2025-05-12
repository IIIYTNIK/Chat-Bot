package com.chatbot.chatbot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
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
        else if (message.matches("-?\\d+\\s*[-+*/]\\s*-?\\d+")) {
            Pattern pattern = Pattern.compile("(-?\\d+)\\s*([-+*/])\\s*(-?\\d+)");
            Matcher matcher = pattern.matcher(message);
            matcher.matches();
            int x = Integer.parseInt(matcher.group(1));  // Первое число (с учётом знака)
            int y = Integer.parseInt(matcher.group(3)); // Второе число (с учётом знака)
            String op = matcher.group(2);               // Оператор (+, -, *, /)

            switch (op) {
                case "+": return String.format("%d + %d = %d", x, y, x + y);
                case "-": return String.format("%d - %d = %d", x, y, x - y);
                case "*": return String.format("%d * %d = %d", x, y, x * y);
                case "/": return y != 0 ? String.format("%d / %d = %d", x, y, x / y) : "Делить на ноль нельзя!";
            }
        }

        return "Не понимаю. Напишите /help для списка команд.";
    }

    public List<Message> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public boolean is_empty(){
        return history.isEmpty();
    }
}



