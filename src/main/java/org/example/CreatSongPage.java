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

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);

        Label title = new Label("title : ");
        Label album = new Label("album : ");
        Label lyrics = new Label("lyrics : ");
        Label genre = new Label("genre : ");
        Label tags = new Label("tags : ");

        TextField titleField = new TextField();
        TextField albumField = new TextField();
        TextField genreField = new TextField();
        TextField tagsField = new TextField();

        TextArea lyricsTextArea = new TextArea();

        Button createSongButton = new Button("Create Song");

        createSongButton.setOnAction(event -> {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            Song song = new Song(titleField.getText(), albumField.getText(), nowArtist.getUserName(), lyricsTextArea.getText(), genreField.getText(), formattedDateTime);
            song.setTags(tagsField.getText());
            song.setViewsNumber(0);

            try {
                insertSong(connectGenuisDb(), titleField.getText(), albumField.getText(), nowArtist.getUserName(), lyricsTextArea.getText(), genreField.getText(), song.getTags(), Integer.parseInt(song.getViewsNumber()), formattedDateTime);
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
