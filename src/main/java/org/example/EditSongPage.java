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
import static org.example.LoadingSongs.songsList;
import static org.example.SignInPage.nowArtist;
import static org.example.UpdateSong.updateSongArtist;

public class EditSongPage extends Application {

    public static void showEditSongPage(Song song) {
        Stage stage = new Stage();
        stage.setTitle("Creat Song Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label album = new Label("album : ");
        album.setFont(labelFont2);
        Label lyrics = new Label("lyrics : ");
        lyrics.setFont(labelFont2);
        Label genre = new Label("genre : ");
        genre.setFont(labelFont2);
        Label tags = new Label("tags : ");
        tags.setFont(labelFont2);

        TextField titleField = new TextField();
        titleField.setText(song.getTitle());
        TextField albumField = new TextField();
        albumField.setText(song.getAlbum());
        TextField genreField = new TextField();
        genreField.setText(song.getGenre());
        TextField tagsField = new TextField();
        tagsField.setText(song.getTags());

        TextArea lyricsTextArea = new TextArea();
        lyricsTextArea.setText(song.getLyrics());

        Button createSongButton = new Button("Edit song");
        createSongButton.setFont(buttonFont);
        createSongButton.setOnAction(e -> {

            updateSongArtist(albumField.getText(), lyricsTextArea.getText(), genreField.getText(), tagsField.getText(), song.getTitle());

            for (Song song1 : songsList)
            {
                if (song1.getTitle().equals(song.getTitle()))
                {
                    song1.setAlbum(albumField.getText());
                    song1.setLyrics(lyricsTextArea.getText());
                    song1.setGenre(genreField.getText());
                    song1.setTags(tagsField.getText());
                }
            }
        });

        createSongButton.setStyle("-fx-background-color:LIGHTGREEN;");

        createSongButton.setOnAction(event -> {
        });

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
