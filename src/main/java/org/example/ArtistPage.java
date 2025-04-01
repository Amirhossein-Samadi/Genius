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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.PersonalInfoArtist.showArtistInfo;
import static org.example.ShowSelectedAlbum.showSelectedAlbum;
import static org.example.ShowSelectedSong.showSelectedSong;

public class ArtistPage extends Application {

    public static void showArtistPage(Artist artist)
    {
        Stage stage = new Stage();
        stage.setTitle("Artist Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);

        Label welcomeLabel = new Label("welcome to Genius Application");
        Label mySongs = new Label("My Songs");
        Label myAlbums = new Label("My Albums");

        Button showMyProfile = new Button("Show My Profile");
        showMyProfile.setOnAction(event -> {showArtistInfo(artist);});
        Button creatSong = new Button("Create Song");
        Button creatAlbum = new Button("Create Album");
        Button songButton = new Button("Show more about song");
        Button albumButton = new Button("Show more about album");

        TableView<Song> artistSongs = new TableView<>();

        TableColumn<Song, String> titleColumn = new TableColumn<>("song title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        ObservableList<Song> songsList = FXCollections.observableArrayList(artist.getSongsList());

        artistSongs.getColumns().addAll(titleColumn, releaseDate, views);

        artistSongs.setItems(songsList);

        songButton.setOnAction(e -> {

            Song selectedSong = artistSongs.getSelectionModel().getSelectedItem();
            showSelectedSong(selectedSong);
        });


        TableView<Album> artistAlbums = new TableView<>();

        TableColumn<Album, String> albumTitle = new TableColumn<>("album title");
        albumTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Album, String> albumReleaseDate = new TableColumn<>("release date");
        albumReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        artistAlbums.getColumns().addAll(albumTitle, albumReleaseDate);

        ObservableList<Album> albumsList = FXCollections.observableArrayList(artist.getAlbumsList());

        artistAlbums.setItems(albumsList);

        albumButton.setOnAction(event -> {

            albumButton.setOnAction(e -> {

                Album selectedAlbum = artistAlbums.getSelectionModel().getSelectedItem();
                showSelectedAlbum(selectedAlbum);
            });
        });

        Scene scene = new Scene(gridPane, 900, 650);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {}
}
