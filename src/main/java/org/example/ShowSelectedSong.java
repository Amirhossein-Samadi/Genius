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
import static org.example.ShowCommentsPage.showCommentsPage;
import static org.example.ShowSelectedRequest.showSelectedRequest;
import static org.example.UpdateSong.updateSongViews;

public class ShowSelectedSong extends Application {

    static Song nowSong;

    public static void showSelectedSong(Song song)
    {
        nowSong = song;

        updateSongViews(song.getViewsNumber() + 1, song.getTitle());

        Stage stage = new Stage();
        stage.setTitle("Selected Song");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setStyle("-fx-background-color:#292929;");

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
        showCommentsButton.setStyle("-fx-background-color:#00bfff;");
        showCommentsButton.setOnAction(e -> {showCommentsPage(song);});

        Button creatComment = new Button("add a comment");
        creatComment.setTextFill(Color.WHITE);
        creatComment.setStyle("-fx-background-color:#32cd32;");
        creatComment.setOnAction(e -> {showCreateCommentPage(song);});

        Button editRequestButton = new Button("Edit Request");
        editRequestButton.setTextFill(Color.WHITE);
        editRequestButton.setStyle("-fx-background-color:#32cd32;");
        editRequestButton.setOnAction(e -> {showSelectedRequest(song);});

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(artistsLabel, 0, 1);
        gridPane.add(albumLabel, 0, 2);
        gridPane.add(lyricsArea, 0, 3);
        gridPane.add(genreLabel, 0, 4);
        gridPane.add(tagsLabel, 0, 5);
        gridPane.add(releaseDateLabel, 0, 6);
        gridPane.add(viewsNumberLabel, 0, 7);
        gridPane.add(showCommentsButton,0, 8);
        gridPane.add(creatComment,0, 9);
        gridPane.add(editRequestButton,0, 10);

        Scene scene = new Scene(gridPane, 650, 450);
        stage.setScene(scene);

        stage.show();

    }



    public static void showSelectedSongAdmin(Song song)
    {
        nowSong = song;

        updateSongViews(song.getViewsNumber() + 1, song.getTitle());

        Stage stage = new Stage();
        stage.setTitle("Selected Song");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setStyle("-fx-background-color:#292929;");

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
        showCommentsButton.setStyle("-fx-background-color:#00bfff;");
        showCommentsButton.setOnAction(e -> {showCommentsPage(song);});

//        Button creatComment = new Button("add a comment");
//        creatComment.setStyle("-fx-background-color:LIGHTGREEN;");
//        creatComment.setOnAction(e -> {showCreateCommentPage();});
//
//        Button editRequestButton = new Button("Edit Request");
//        editRequestButton.setStyle("-fx-background-color:LIGHTGREEN;");
//        editRequestButton.setOnAction(e -> {showSelectedRequest(song);});

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
//        gridPane.add(editRequestButton,0, 10);

        Scene scene = new Scene(gridPane, 650, 450);
        stage.setScene(scene);

        stage.show();

    }


    @Override
    public void start(Stage stage) throws Exception {}
}
