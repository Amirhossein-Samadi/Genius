package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static org.example.SearchSong.searchSong;
import static org.example.UpdateSong.updateSongAlbum;

public class ShowCreatExistedSong extends Application {

    public static void showCreateExistedSong(Album album, Artist artist)
    {
        Stage stage = new Stage();
        stage.setTitle("add an existed song Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:#292929;");

//        Label titleLabel = new Label("title");
//
//        TextField titleField = new TextField();


        TableView<Song> albumSongs = new TableView<>();

        TableColumn<Song, String> songTitle = new TableColumn<>("song title");
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> artistName = new TableColumn<>("artist name");
        artistName.setCellValueFactory(new PropertyValueFactory<>("artists"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        albumSongs.getColumns().addAll(songTitle, artistName, releaseDate, views);

        ObservableList<Song> songsList = FXCollections.observableArrayList(artist.getSongsList());

        albumSongs.setItems(songsList);


        Button addSongButton = new Button("add song");
        addSongButton.setTextFill(Color.WHITE);
        addSongButton.setStyle("-fx-background-color:#32cd32;");
        addSongButton.setOnAction(event -> {

            Song song = albumSongs.getSelectionModel().getSelectedItem();

            album.addSong(song);
            updateSongAlbum(album.getTitle(), song.getTitle());
        });

        gridPane.add(albumSongs, 0, 0);
        gridPane.add(addSongButton, 0, 1);

        Scene scene = new Scene(gridPane, 550, 450);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
