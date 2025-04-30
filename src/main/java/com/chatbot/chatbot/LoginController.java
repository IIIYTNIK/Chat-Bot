package com.chatbot.chatbot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField login_edit;

    @FXML
    private Button LoginButton;

    private void showErrorStyle(TextField field) {
        // Устанавливаем красную границу и подсказку
        field.setStyle("-fx-border-color: #ff6b6b; -fx-border-width: 2px;");
        field.setPromptText("Имя не может быть пустым!");
        field.setText("");
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String username = login_edit.getText().trim();

        // Проверяем, что имя не пустое
        if (username.isEmpty()) {
            // Подсвечиваем поле ввода
            showErrorStyle(login_edit);
            return;
        }

        // Сбрасываем стиль, если был ошибка
        login_edit.setStyle("");

        // Загружаем ChatWindow
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("ChatWindow.fxml"));
        Scene scene = new Scene(loader.load(), 400, 400);  // Размеры как у ChatWindow

        // Получаем контроллер чата и передаём имя пользователя
        ChatController chatController = loader.getController();
        chatController.setUsername(username);

        // Настраиваем и показываем новое окно
        Stage chatStage = new Stage();
        chatStage.setTitle("Чат с ботом - " + username);
        chatStage.setScene(scene);
        chatStage.show();

        // Закрываем текущее окно (логин)
        Stage currentStage = (Stage) login_edit.getScene().getWindow();
        currentStage.close();
    }
}
