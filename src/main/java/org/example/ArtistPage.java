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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.CreatAlbumPage.showCreatAlbumPage;
import static org.example.CreatSongPage.showCreateSongPage;
import static org.example.PersonalInfoArtist.showArtistInfo;
import static org.example.ShowAlbumArtist.showAlbumArtist;
import static org.example.ShowRequestArtist.showRequestArtist;
import static org.example.ShowSelectedAlbum.showSelectedAlbum;
import static org.example.ShowSelectedSong.showSelectedSong;
import static org.example.ShowSelectedSongArtist.showSelectedSongArtist;

public class ArtistPage extends Application {

    public static void showArtistPage(Artist artist)
    {
        Stage stage = new Stage();
        stage.setTitle("Artist Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(25);
        gridPane.setHgap(25);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 14);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label welcomeLabel = new Label("welcome to Genius Application");
        welcomeLabel.setTextFill(Color.WHITE);
        welcomeLabel.setFont(labeFont);
        Label mySongs = new Label("                     My Songs");
        mySongs.setTextFill(Color.WHITE);
        mySongs.setFont(labelFont2);
        Label myAlbums = new Label("                        My Albums");
        myAlbums.setTextFill(Color.WHITE);
        myAlbums.setFont(labelFont2);
        Label requestsLabel = new Label("                                   Requests");
        requestsLabel.setTextFill(Color.WHITE);
        requestsLabel.setFont(labelFont2);

        Button showMyProfile = new Button("Show My Profile");
        showMyProfile.setTextFill(Color.WHITE);
        showMyProfile.setStyle("-fx-background-color:#00bfff;");
        showMyProfile.setFont(buttonFont);
        showMyProfile.setOnAction(event -> {showArtistInfo(artist);});
        Button creatSong = new Button("Create Song");
        creatSong.setTextFill(Color.WHITE);
        creatSong.setStyle("-fx-background-color:#32cd32;");
        creatSong.setFont(buttonFont);
        creatSong.setOnAction(event -> {showCreateSongPage();});
        Button creatAlbum = new Button("Create Album");
        creatAlbum.setTextFill(Color.WHITE);
        creatAlbum.setStyle("-fx-background-color:#32cd32;");
        creatAlbum.setFont(buttonFont);
        creatAlbum.setOnAction(event -> {showCreatAlbumPage();});
        Button songButton = new Button("Show more about song");
        songButton.setTextFill(Color.WHITE);
        songButton.setStyle("-fx-background-color:#00bfff;");
        songButton.setFont(buttonFont);
        Button albumButton = new Button("Show more about album");
        albumButton.setTextFill(Color.WHITE);
        albumButton.setStyle("-fx-background-color:#00bfff;");
        albumButton.setFont(buttonFont);
        Button requestButton = new Button("Show more about request");
        requestButton.setTextFill(Color.WHITE);
        requestButton.setStyle("-fx-background-color:#00bfff;");
        requestButton.setFont(buttonFont);

        TableView<Song> artistSongs = new TableView<>();

        TableColumn<Song, String> titleColumn = new TableColumn<>("song title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        ObservableList<Song> songsList = FXCollections.observableArrayList(artist.getSongsList().reversed());

        artistSongs.getColumns().addAll(titleColumn, releaseDate, views);

        artistSongs.setItems(songsList);

        songButton.setOnAction(e -> {

            Song selectedSong = artistSongs.getSelectionModel().getSelectedItem();
            showSelectedSongArtist(selectedSong);
        });


        TableView<Album> artistAlbums = new TableView<>();

        TableColumn<Album, String> albumTitle = new TableColumn<>("album title");
        albumTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Album, String> albumReleaseDate = new TableColumn<>("release date");
        albumReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        artistAlbums.getColumns().addAll(albumTitle, albumReleaseDate);

        ObservableList<Album> albumsList = FXCollections.observableArrayList(artist.getAlbumsList().reversed());

        artistAlbums.setItems(albumsList);


        TableView<Request> requestTableView = new TableView<>();

        TableColumn<Request, String> usernameColumn = new TableColumn<>("username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Request, String> songTitleColumn = new TableColumn<>("song title");
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));

        TableColumn<Request, String> statusColumn = new TableColumn<>("status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Request, String> releaseDateColumn = new TableColumn<>("release date");
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        ObservableList<Request> requestList = FXCollections.observableArrayList(artist.getRequests().reversed());

        requestTableView.getColumns().addAll(usernameColumn, songTitleColumn, statusColumn, releaseDateColumn);

        requestTableView.setItems(requestList);


        albumButton.setOnAction(event -> {

            albumButton.setOnAction(e -> {

                Album selectedAlbum = artistAlbums.getSelectionModel().getSelectedItem();
                showAlbumArtist(selectedAlbum);
            });
        });

        requestButton.setOnAction(event -> {

            Request selectedRequest = requestTableView.getSelectionModel().getSelectedItem();
            showRequestArtist(selectedRequest);
        });

        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(showMyProfile, 0, 1);
        gridPane.add(creatSong, 0, 2);
        gridPane.add(creatAlbum, 0, 3);
        gridPane.add(mySongs, 1, 4);
        gridPane.add(myAlbums, 2, 4);
        gridPane.add(requestsLabel, 3, 4);
        gridPane.add(artistSongs, 1, 5);
        gridPane.add(artistAlbums, 2, 5);
        gridPane.add(requestTableView, 3, 5);
        gridPane.add(songButton, 1, 6);
        gridPane.add(albumButton, 2, 6);
        gridPane.add(requestButton, 3, 6);


        Scene scene = new Scene(gridPane, 1400, 800);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {}
}
