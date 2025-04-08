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

import static org.example.UpdateSong.updateSongArtist;

public class EditSongPage extends Application {

    public static void showEditSongPage(Song song)
    {
        Stage stage = new Stage();
        stage.setTitle("Edit Song Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label albumLabel = new Label("Album : ");
        albumLabel.setTextFill(Color.WHITE);
        albumLabel.setFont(labelFont2);
        Label lyricsLabel = new Label("Lyrics : ");
        lyricsLabel.setTextFill(Color.WHITE);
        lyricsLabel.setFont(labelFont2);
        Label genreLabel = new Label("Genre : ");
        genreLabel.setTextFill(Color.WHITE);
        genreLabel.setFont(labelFont2);
        Label tagsLabel = new Label("Tags : ");
        tagsLabel.setTextFill(Color.WHITE);
        tagsLabel.setFont(labelFont2);

        TextField albumTextField = new TextField();
        albumTextField.setText(song.getAlbum());
        TextField genreTextField = new TextField();
        genreTextField.setText(song.getGenre());
        TextField tagsTextField = new TextField();
        tagsTextField.setText(song.getTags());

        TextArea lyricsTextArea = new TextArea();
        lyricsTextArea.setText(song.getLyrics());

        Button editSongButton = new Button("Edit Song");
        editSongButton.setTextFill(Color.WHITE);
        editSongButton.setFont(buttonFont);
        editSongButton.setStyle("-fx-background-color:LIGHTGREEN;");
        editSongButton.setOnAction(e -> {

            String album = albumTextField.getText();
            String lyrics = lyricsTextArea.getText();
            String genre = genreTextField.getText();
            String tags = tagsTextField.getText();

            updateSongArtist(album, lyrics, genre, tags, song.getTitle());
        });

        gridPane.add(albumLabel, 0, 0);
        gridPane.add(albumTextField, 0, 1);
        gridPane.add(lyricsLabel, 0, 2);
        gridPane.add(lyricsTextArea, 0, 3);
        gridPane.add(genreLabel, 0, 4);
        gridPane.add(genreTextField, 0, 5);
        gridPane.add(tagsLabel, 0, 6);
        gridPane.add(tagsTextField, 0, 7);
        gridPane.add(editSongButton, 0, 8);

        Scene scene = new Scene(gridPane, 650, 500);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
