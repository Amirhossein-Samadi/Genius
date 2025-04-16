package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertSongs.insertSong;
import static org.example.SignInPage.nowArtist;

public class CreatSongPage extends Application {

    public static void showCreateSongPage()
    {
        Stage stage = new Stage();
        stage.setTitle("Creat Song Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label title = new Label("title : ");
        title.setTextFill(Color.WHITE);
        title.setFont(labelFont2);
        Label album = new Label("album : ");
        album.setTextFill(Color.WHITE);
        album.setFont(labelFont2);
        Label lyrics = new Label("lyrics : ");
        lyrics.setTextFill(Color.WHITE);
        lyrics.setFont(labelFont2);
        Label genre = new Label("genre : ");
        genre.setTextFill(Color.WHITE);
        genre.setFont(labelFont2);
        Label tags = new Label("tags : ");
        tags.setTextFill(Color.WHITE);
        tags.setFont(labelFont2);

        TextField titleField = new TextField();
        TextField albumField = new TextField();
        TextField genreField = new TextField();
        TextField tagsField = new TextField();

        TextArea lyricsTextArea = new TextArea();

        Button createSongButton = new Button("Create Song");
        createSongButton.setTextFill(Color.WHITE);
        createSongButton.setFont(buttonFont);

        createSongButton.setStyle("-fx-background-color:#32cd32;");

        createSongButton.setOnAction(event -> {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            Song song = new Song(titleField.getText(), albumField.getText(), nowArtist.getUserName(), lyricsTextArea.getText(), genreField.getText(), formattedDateTime);
            song.setTags(tagsField.getText());
            song.setViewsNumber(0);

            try {
                insertSong(connectGenuisDb(), titleField.getText(), albumField.getText(), nowArtist.getUserName(), lyricsTextArea.getText(), genreField.getText(), song.getTags(), Integer.parseInt(String.valueOf(song.getViewsNumber())), formattedDateTime);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        gridPane.add(title, 0, 0);
        gridPane.add(titleField, 1, 0);
        gridPane.add(album, 0, 1);
        gridPane.add(albumField, 1, 1);
        gridPane.add(lyrics, 0, 2);
        gridPane.add(lyricsTextArea, 1, 2);
        gridPane.add(genre, 0, 3);
        gridPane.add(genreField, 1, 3);
        gridPane.add(tags, 0, 4);
        gridPane.add(tagsField, 1, 4);
        gridPane.add(createSongButton, 0, 5);


        Scene scene = new Scene(gridPane, 650, 500);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
