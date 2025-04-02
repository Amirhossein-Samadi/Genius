package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertRequest.insertRequest;
import static org.example.SignInPage.nowUser;

public class ShowSelectedRequest extends Application {

    public static void showSelectedRequest(Song song)
    {
        Stage stage = new Stage();
        stage.setTitle("Creat Request Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setVgap(17);
        gridPane.setHgap(17);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labelFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label recommendedLyricsLabel = new Label("Recommended Lyrics : ");
        recommendedLyricsLabel.setFont(labelFont2);

        TextArea recommendedLyricsTextArea = new TextArea();

        Label descriptionLabel = new Label("description : ");
        descriptionLabel.setFont(labelFont2);

        TextArea descriptionTextArea = new TextArea();

        Button createRequestButton = new Button("Create Request");
        createRequestButton.setStyle("-fx-background-color:LIGHTGREEN;");
        createRequestButton.setFont(buttonFont);
        createRequestButton.setOnAction(e -> {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            Request request = new Request(nowUser.getUserName(), song.getArtists(), song.getTitle(), recommendedLyricsTextArea.getText(), descriptionTextArea.getText(), formattedDateTime, 3);
            try {
                insertRequest(connectGenuisDb(), nowUser.getUserName(), song.getArtists(), song.getTitle(), recommendedLyricsTextArea.getText(), descriptionTextArea.getText(), formattedDateTime, 3);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridPane.add(recommendedLyricsLabel, 0, 1);
        gridPane.add(recommendedLyricsTextArea, 0, 2);
        gridPane.add(descriptionLabel, 0, 3);
        gridPane.add(descriptionTextArea, 0, 4);
        gridPane.add(createRequestButton, 0, 5);

        Scene scene = new Scene(gridPane, 600, 500);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
