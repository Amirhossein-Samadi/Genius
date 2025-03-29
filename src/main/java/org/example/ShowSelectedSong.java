package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.ShowCommentsPage.showCommentsPage;

public class ShowSelectedSong extends Application {

    public static void showSelectedSong(Song song)
    {
        Stage stage = new Stage();
        stage.setTitle("Personal Information");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);

        Font labeFont = Font.font("", FontWeight.NORMAL, 15);

        String title = "title : " + song.getTitle();
        String artists = "artists : " + song.getArtists();
        String album = "album : " + song.getAlbum();
        String lyrics = "lyrics : " + song.getLyrics();
        String genre = "genre : " + song.getGenre();
        String tags = "tags : " + song.getTags();
        String releaseDate = "releaseDate : " + song.getReleaseDate();
        String viewsNumber = "viewsNumber : " + song.getViewsNumber();

        Label titleLabel = new Label(title);
        Label artistsLabel = new Label(artists);
        Label albumLabel = new Label(album);
        Label genreLabel = new Label(genre);
        Label tagsLabel = new Label(tags);
        Label releaseDateLabel = new Label(releaseDate);
        Label viewsNumberLabel = new Label(viewsNumber);

        TextArea lyricsArea = new TextArea();
        lyricsArea.setText(lyrics);
        lyricsArea.setWrapText(true);
        lyricsArea.setEditable(false);

        Button showCommentsButton = new Button("Show Comments");
        showCommentsButton.setOnAction(e -> {showCommentsPage(song);});

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(artistsLabel, 0, 1);
        gridPane.add(albumLabel, 0, 2);
        gridPane.add(lyricsArea, 0, 3);
        gridPane.add(genreLabel, 0, 4);
        gridPane.add(tagsLabel, 0, 5);
        gridPane.add(releaseDateLabel, 0, 6);
        gridPane.add(viewsNumberLabel, 0, 7);
        gridPane.add(showCommentsButton,0, 8);

        Scene scene = new Scene(gridPane, 600, 400);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {}
}
