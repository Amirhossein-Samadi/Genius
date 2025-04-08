package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.UpdateRequest.updateRequestByArtist;
import static org.example.UpdateSong.updateLyricsByRequest;

public class ShowRequestArtist extends Application {

    public static void showRequestArtist(Request request)
    {
        Stage stage = new Stage();
        stage.setTitle("Request Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labelFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label usernameLabel = new Label("username : " + request.getUsername());
        usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(labelFont2);
        Label arttistNameLabel = new Label("Artist Name : " + request.getArtistName());
        arttistNameLabel.setTextFill(Color.WHITE);
        arttistNameLabel.setFont(labelFont2);
        Label songTitleLabel = new Label("Song Title : " + request.getSongTitle());
        songTitleLabel.setTextFill(Color.WHITE);
        songTitleLabel.setFont(labelFont2);

        Label recommendedLyricsLabel = new Label("Recommended Lyrics : ");
        recommendedLyricsLabel.setTextFill(Color.WHITE);
        recommendedLyricsLabel.setFont(labelFont2);

        TextArea recommendedLyricsTextArea = new TextArea();
        recommendedLyricsTextArea.setText(request.getRecommendedLyrics());
        recommendedLyricsTextArea.setWrapText(true);
        recommendedLyricsTextArea.setEditable(false);

        Label descriptionLabel = new Label("description : ");
        descriptionLabel.setTextFill(Color.WHITE);
        descriptionLabel.setFont(labelFont2);

        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setText(request.getDescription());
        descriptionTextArea.setWrapText(true);
        descriptionTextArea.setEditable(false);

        Label statusLabel = new Label("Status : " + request.getStatus());
        statusLabel.setTextFill(Color.WHITE);
        statusLabel.setFont(labelFont2);

        Label releaseDateLabel = new Label("Release Date : " + request.getReleaseDate());
        releaseDateLabel.setTextFill(Color.WHITE);
        releaseDateLabel.setFont(labelFont2);

        Button acceptButton = new Button("Accept Request");
        acceptButton.setTextFill(Color.WHITE);
        acceptButton.setFont(buttonFont);
        acceptButton.setStyle("-fx-background-color:#32cd32;");
        acceptButton.setOnAction(e -> {

            updateRequestByArtist(request.getUsername(), request.getArtistName(), request.getSongTitle(), 1);
            updateLyricsByRequest(request.getRecommendedLyrics(), request.getSongTitle());
        });

        Button declineButton = new Button("Decline Request");
        declineButton.setTextFill(Color.WHITE);
        declineButton.setFont(buttonFont);
        declineButton.setStyle("-fx-background-color:#800000;");
        declineButton.setOnAction(e -> {
            updateRequestByArtist(request.getUsername(), request.getArtistName(), request.getSongTitle(), 2);
        });

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(arttistNameLabel, 0, 1);
        gridPane.add(songTitleLabel, 0, 2);
        gridPane.add(recommendedLyricsLabel, 0, 3);
        gridPane.add(recommendedLyricsTextArea, 0, 4);
        gridPane.add(descriptionLabel, 0, 5);
        gridPane.add(descriptionTextArea, 0, 6);
        gridPane.add(statusLabel, 0, 7);
        gridPane.add(releaseDateLabel, 0, 8);
        if (request.getStatus() == "Unread")
        {
            gridPane.add(acceptButton, 0, 9);
            gridPane.add(declineButton, 0, 10);
        }



        Scene scene = new Scene(gridPane, 750, 750);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
