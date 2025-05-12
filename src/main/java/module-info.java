module com.chatbot.chatbot {
        requires javafx.controls;
        requires javafx.fxml;
        requires com.google.gson;

        opens com.chatbot.chatbot to javafx.fxml, com.google.gson;

        exports com.chatbot.chatbot;
        }