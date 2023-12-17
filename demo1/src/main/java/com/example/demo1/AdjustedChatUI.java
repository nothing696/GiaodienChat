package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AdjustedChatUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Adjusted Chat UI");

        VBox chatContainer = new VBox(10);
        chatContainer.setPadding(new Insets(10));

        Label userMessage1 = createMessage("Hello, how are you?");
        Label botMessage1 = createMessage("I'm just a simple bot.");

        Label userMessage2 = createMessage("Nice to meet you?");
        Label botMessage2 = createMessage("Likewise!");

        HBox userContainer1 = createMessageContainer(userMessage1, false);
        HBox botContainer1 = createMessageContainer(botMessage1, true);

        HBox userContainer2 = createMessageContainer(userMessage2, false);
        HBox botContainer2 = createMessageContainer(botMessage2, true);

        chatContainer.getChildren().addAll(userContainer1, botContainer1, userContainer2, botContainer2);

        Scene scene = new Scene(chatContainer, 300, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private HBox createMessageContainer(Label message, boolean isBot) {
        HBox messageContainer = new HBox();
        messageContainer.setAlignment(isBot ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);

        messageContainer.getChildren().add(message);
        messageContainer.setMaxWidth(200);

        if (isBot) {
            message.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            message.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            messageContainer.setAlignment(Pos.CENTER_LEFT);
        }

        messageContainer.setPadding(new Insets(5, isBot ? 0 : 10, 5, isBot ? 10 : 0));

        return messageContainer;
    }

    private Label createMessage(String text) {
        Label message = new Label(text);
        message.setStyle("-fx-padding: 10;");
        message.setWrapText(true);
        return message;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
