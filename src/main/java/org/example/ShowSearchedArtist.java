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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.DeleteFollowedArtist.deleteFollowedArtist;
import static org.example.InsertFollowedArtists.insertFollowedArtistsTable;
import static org.example.ShowSelectedAlbum.showSelectedAlbum;
import static org.example.ShowSelectedAlbum.showSelectedAlbumAdmin;
import static org.example.ShowSelectedSong.showSelectedSong;
import static org.example.ShowSelectedSong.showSelectedSongAdmin;
import static org.example.SignInPage.nowUser;

public class ShowSearchedArtist extends Application {

    public static void showSearchedArtist(Artist artist)
    {
        Stage stage = new Stage();
        stage.setTitle("Show searched artist");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setStyle("-fx-background-color:#292929;");

        String name = artist.getName();
        String userName = artist.getUserName();
        String age = Integer.toString(artist.getAge());

        Label nameLabel = new Label("Name : " + name);
        nameLabel.setTextFill(Color.WHITE);
        Label userNameLabel = new Label("Username : " + userName);
        userNameLabel.setTextFill(Color.WHITE);
        Label ageLabel = new Label("Age : " + age);
        ageLabel.setTextFill(Color.WHITE);

        Button songButton = new Button("Show more about song");
        songButton.setTextFill(Color.WHITE);
        songButton.setStyle("-fx-background-color:#00bfff;");
        Button albumButton = new Button("Show more about album");
        albumButton.setTextFill(Color.WHITE);
        albumButton.setStyle("-fx-background-color:#00bfff;");
        Button followButton = new Button("Follow artist");
        followButton.setTextFill(Color.WHITE);
        followButton.setStyle("-fx-background-color:#32cd32;");
        followButton.setOnAction(e -> {
            nowUser.setFollowedArtist(artist);
            try {
                insertFollowedArtistsTable(connectGenuisDb(), nowUser.getUserName(), artist.getUserName());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button unfollowButton = new Button("Unfollow artist");
        unfollowButton.setTextFill(Color.WHITE);
        unfollowButton.setStyle("-fx-background-color:#800000;");
        unfollowButton.setOnAction(e -> {

            try {
                deleteFollowedArtist(nowUser.getUserName(), artist.getUserName());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });

        TableView<Album> artistAlbums = new TableView<>();

        TableColumn<Album, String> albumTitle = new TableColumn<>("album title");
        albumTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Album, String> albumArtist = new TableColumn<>("artist");
        albumArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));

        TableColumn<Album, String> albumReleaseDate = new TableColumn<>("release date");
        albumReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        artistAlbums.getColumns().addAll(albumTitle, albumArtist, albumReleaseDate);

        ObservableList<Album> albumsList = FXCollections.observableArrayList(artist.getAlbumsList());

        artistAlbums.setItems(albumsList);

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

        artistSongs.setItems(songsList);

        songButton.setOnAction(e -> {

            Song selectedSong = artistSongs.getSelectionModel().getSelectedItem();
            showSelectedSong(selectedSong);
        });

        albumButton.setOnAction(e -> {

            Album selectedAlbum = artistAlbums.getSelectionModel().getSelectedItem();
            showSelectedAlbum(selectedAlbum);
        });

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(artistSongs, 0, 3);
        gridPane.add(artistAlbums, 1, 3);
        gridPane.add(songButton, 0, 4);
        gridPane.add(albumButton, 1, 4);

        boolean followFlag = true;
        for (Artist artist1 : nowUser.getFollowedArtist())
        {
            if (artist1.getUserName().equals(artist.getUserName())) {followFlag = false;}
        }
        if (followFlag) {gridPane.add(followButton,0, 5);}
        else {gridPane.add(unfollowButton,0,5);}


        Scene scene = new Scene(gridPane, 900, 650);
        stage.setScene(scene);

        stage.show();

    }

    public static void showSearchedArtistAdmin(Artist artist)
    {
        Stage stage = new Stage();
        stage.setTitle("Show searched artist");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setStyle("-fx-background-color:#292929;");

        String name = artist.getName();
        String userName = artist.getUserName();
        String age = Integer.toString(artist.getAge());

        Label nameLabel = new Label("Name : " + name);
        nameLabel.setTextFill(Color.WHITE);
        Label userNameLabel = new Label("Username : " + userName);
        userNameLabel.setTextFill(Color.WHITE);
        Label ageLabel = new Label("Age : " + age);
        ageLabel.setTextFill(Color.WHITE);

        Button songButton = new Button("Show more about song");
        songButton.setTextFill(Color.WHITE);
        songButton.setStyle("-fx-background-color:#00bfff;");
        Button albumButton = new Button("Show more about album");
        albumButton.setTextFill(Color.WHITE);
        albumButton.setStyle("-fx-background-color:#00bfff;");
//        Button followButton = new Button("Follow artist");
//        followButton.setStyle("-fx-background-color:LIGHTGREEN;");
//        followButton.setOnAction(e -> {
//            nowUser.setFollowedArtist(artist);
//            try {
//                insertFollowedArtistsTable(connectGenuisDb(), nowUser.getUserName(), artist.getUserName());
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        Button unfollowButton = new Button("Unfollow artist");
//        unfollowButton.setStyle("-fx-background-color:RED;");
//        unfollowButton.setOnAction(e -> {
//
//            try {
//                deleteFollowedArtist(nowUser.getUserName(), artist.getUserName());
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//
//        });

        TableView<Album> artistAlbums = new TableView<>();

        TableColumn<Album, String> albumTitle = new TableColumn<>("album title");
        albumTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Album, String> albumArtist = new TableColumn<>("artist");
        albumArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));

        TableColumn<Album, String> albumReleaseDate = new TableColumn<>("release date");
        albumReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        artistAlbums.getColumns().addAll(albumTitle, albumArtist, albumReleaseDate);

        ObservableList<Album> albumsList = FXCollections.observableArrayList(artist.getAlbumsList());

        artistAlbums.setItems(albumsList);

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

        artistSongs.setItems(songsList);

        songButton.setOnAction(e -> {

            Song selectedSong = artistSongs.getSelectionModel().getSelectedItem();
            showSelectedSongAdmin(selectedSong);
        });

        albumButton.setOnAction(e -> {

            Album selectedAlbum = artistAlbums.getSelectionModel().getSelectedItem();
            showSelectedAlbumAdmin(selectedAlbum);
        });

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(artistSongs, 0, 3);
        gridPane.add(artistAlbums, 1, 3);
        gridPane.add(songButton, 0, 4);
        gridPane.add(albumButton, 1, 4);

//        boolean followFlag = true;
//        for (Artist artist1 : nowUser.getFollowedArtist())
//        {
//            if (artist1.getUserName().equals(artist.getUserName())) {followFlag = false;}
//        }
//        if (followFlag) {gridPane.add(followButton,0, 5);}
//        else {gridPane.add(unfollowButton,0,5);}


        Scene scene = new Scene(gridPane, 900, 650);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
