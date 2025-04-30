module com.chatbot.chatbot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.chatbot.chatbot to javafx.fxml;
    exports com.chatbot.chatbot;
}