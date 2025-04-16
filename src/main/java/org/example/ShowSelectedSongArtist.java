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

import static org.example.CreatCommentPage.showCreateCommentPage;
import static org.example.EditSongPage.showEditSongPage;
import static org.example.ShowCommentsPage.showCommentsPage;

public class ShowSelectedSongArtist extends Application {

    static Song nowSong;

    public static void showSelectedSongArtist(Song song)
    {
        nowSong = song;

        Stage stage = new Stage();
        stage.setTitle("Selected Song");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 14);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 12);

        String title = "title : " + song.getTitle();
        String artists = "artists : " + song.getArtists();
        String album = "album : " + song.getAlbum();
        String lyrics = "lyrics : " + song.getLyrics();
        String genre = "genre : " + song.getGenre();
        String tags = "tags : " + song.getTags();
        String releaseDate = "releaseDate : " + song.getReleaseDate();
        String viewsNumber = "viewsNumber : " + song.getViewsNumber();

        Label titleLabel = new Label(title);
        titleLabel.setTextFill(Color.WHITE);
        Label artistsLabel = new Label(artists);
        artistsLabel.setTextFill(Color.WHITE);
        Label albumLabel = new Label(album);
        albumLabel.setTextFill(Color.WHITE);
        Label genreLabel = new Label(genre);
        genreLabel.setTextFill(Color.WHITE);
        Label tagsLabel = new Label(tags);
        tagsLabel.setTextFill(Color.WHITE);
        Label releaseDateLabel = new Label(releaseDate);
        releaseDateLabel.setTextFill(Color.WHITE);
        Label viewsNumberLabel = new Label(viewsNumber);
        viewsNumberLabel.setTextFill(Color.WHITE);

        TextArea lyricsArea = new TextArea();
        lyricsArea.setText(lyrics);
        lyricsArea.setWrapText(true);
        lyricsArea.setEditable(false);

        Button showCommentsButton = new Button("Show Comments");
        showCommentsButton.setTextFill(Color.WHITE);
        showCommentsButton.setFont(buttonFont);
        showCommentsButton.setStyle("-fx-background-color:#00bfff;");
        showCommentsButton.setOnAction(e -> {showCommentsPage(song);});

//        Button creatComment = new Button("add a comment");
//        creatComment.setFont(buttonFont);
//        creatComment.setStyle("-fx-background-color:LIGHTGREEN;");
//        creatComment.setOnAction(e -> {showCreateCommentPage(song);});

        Button editSongButton = new Button("Edit Song");
        editSongButton.setTextFill(Color.WHITE);
        editSongButton.setFont(buttonFont);
        editSongButton.setStyle("-fx-background-color:#32cd32;");
        editSongButton.setOnAction(e -> {showEditSongPage(song);});

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(artistsLabel, 0, 1);
        gridPane.add(albumLabel, 0, 2);
        gridPane.add(lyricsArea, 0, 3);
        gridPane.add(genreLabel, 0, 4);
        gridPane.add(tagsLabel, 0, 5);
        gridPane.add(releaseDateLabel, 0, 6);
        gridPane.add(viewsNumberLabel, 0, 7);
        gridPane.add(showCommentsButton,0, 8);
//        gridPane.add(creatComment,0, 9);
        gridPane.add(editSongButton,0, 10);

        Scene scene = new Scene(gridPane, 650, 450);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {}
}
