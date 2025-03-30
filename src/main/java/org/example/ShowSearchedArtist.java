package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static org.example.ShowSelectedSong.showSelectedSong;

public class ShowSearchedArtist extends Application {

    public static void showSearchedArtist(Artist artist)
    {
        Stage stage = new Stage();
        stage.setTitle("Show searched artist");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        String name = artist.getName();
        String userName = artist.getUserName();
        String age = Integer.toString(artist.getAge());

        Label nameLabel = new Label(name);
        Label userNameLabel = new Label(userName);
        Label ageLabel = new Label(age);

        Button songButton = new Button("Show more about song");

        TableView<Album> artistAlbums = new TableView<>();

        TableColumn<Album, String> albumTitle = new TableColumn<>("album title");
        albumTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Album, String> albumArtist = new TableColumn<>("artist");
        albumArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));

        TableColumn<Album, String> albumReleaseDate = new TableColumn<>("release date");
        albumReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        artistAlbums.getColumns().addAll(albumTitle, albumArtist, albumReleaseDate);

        ObservableList<Album> albumsList = FXCollections.observableArrayList(artist.getAlbumsList());

        TableView<Song> artistSongs = new TableView<>();

        TableColumn<Song, String> songTitle = new TableColumn<>("song title");
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> artistName = new TableColumn<>("artist name");
        artistName.setCellValueFactory(new PropertyValueFactory<>("artists"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        artistSongs.getColumns().addAll(songTitle, artistName, releaseDate, views);

        ObservableList<Song> songsList = FXCollections.observableArrayList(artist.getSongsList());

        songButton.setOnAction(e -> {

            Song selectedSong = artistSongs.getSelectionModel().getSelectedItem();
            showSelectedSong(selectedSong);
        });

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(artistSongs, 0, 3);
        gridPane.add(artistAlbums, 1, 3);
        gridPane.add(songButton, 0, 4);


        Scene scene = new Scene(gridPane, 900, 650);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {}
}
