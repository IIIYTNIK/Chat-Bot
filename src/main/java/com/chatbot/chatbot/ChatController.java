package com.chatbot.chatbot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    // Все FXML-элементы должны быть помечены аннотацией
    @FXML
    private TextField inputTextField;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private Button sendButton;

    private BotInterface bot;
    private String username;

    // Конструктор без параметров (требование JavaFX)
    public ChatController() {
        this.bot = new RegularBot();
    }

    @FXML
    private void initialize() {
        // Инициализация, которая не зависит от username
        chatTextArea.setEditable(false);
    }

    // Установка имени пользователя (вызывается из LoginController)
    public void setUsername(String username) {
        this.username = username;
        bot.loadHistoryFromFile(username);
        showWelcomeMessage();
    }

    private void showWelcomeMessage() {
        chatTextArea.appendText("Бот: Добро пожаловать, " + username + "!\n\n");
        chatTextArea.appendText("Бот: Введите /help для списка команд\n");
    }

    @FXML
    private void handleSendMessage() {
        String message = inputTextField.getText().trim();
        if (!message.isEmpty()) {
            addMessageToChat(username + ": " + message);

            String response = bot.respondTo(message, username);
            addMessageToChat("Бот: " + response);

            inputTextField.clear();
        }
    }

    private void addMessageToChat(String message) {
        chatTextArea.appendText(message + "\n");
        chatTextArea.setScrollTop(Double.MAX_VALUE);
    }

    public void saveHistory() {
        //ToDo SaveHistory
    }
}