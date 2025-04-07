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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.example.LoadingSongs.songsList;
import static org.example.PersonalInformationPage.showPersonalInformation;
import static org.example.SearchAlbum.searchAlbum;
import static org.example.SearchArtist.searchArtist;
import static org.example.SearchSong.searchSong;
import static org.example.ShowRequestUser.showRequestUser;
import static org.example.ShowSearchedArtist.showSearchedArtist;
import static org.example.ShowSelectedAlbum.showSelectedAlbum;
import static org.example.ShowSelectedSong.showSelectedSong;
import static org.example.SignUpPage.showSignUpPage;

public class UserPage extends Application {

    public static void showUserPage(User user) {

        Stage stage = new Stage();
        stage.setTitle("User Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label welcomeLabel = new Label("welcome to Genius Application");
        welcomeLabel.setFont(labeFont);
        Label searchLabel = new Label("                                                             Search");
        searchLabel.setFont(labelFont2);
        Label followedArtistsLabel = new Label("                   Followed Artists");
        followedArtistsLabel.setFont(labelFont2);
        Label followedSongsLabel = new Label("                    Followed Artists Songs");
        followedSongsLabel.setFont(labelFont2);
        Label popularSongs = new Label("                           Popular Songs");
        popularSongs.setFont(labelFont2);
        Label requestsLabel = new Label("                            Requests");
        requestsLabel.setFont(labelFont2);

        TextField searchField = new TextField();

        Button showMyProfile = new Button("Show My Profile");
        showMyProfile.setFont(buttonFont);
        showMyProfile.setStyle("-fx-background-color:LIGHTBLUE;");
        showMyProfile.setOnAction(e -> {showPersonalInformation(user);});
        Button searchButton = new Button("Search");
        searchButton.setFont(buttonFont);
        searchButton.setStyle("-fx-background-color:LIGHTBLUE;");
        searchButton.setOnAction(e -> {

            String search = searchField.getText();

            if (searchArtist(search) != null)
            {
                Artist artist = searchArtist(search);
                showSearchedArtist(artist);
            }

            if (searchAlbum(search) != null)
            {
                Album album = searchAlbum(search);
                showSelectedAlbum(album);
            }

            if (searchSong(search) != null)
            {
                Song song = searchSong(search);
                showSelectedSong(song);
            }

        });
        Button artistButton = new Button("Show more about artist");
        artistButton.setFont(buttonFont);
        artistButton.setStyle("-fx-background-color:LIGHTGREEN;");
        Button songButton = new Button("Show more about song");
        songButton.setFont(buttonFont);
        songButton.setStyle("-fx-background-color:LIGHTGREEN;");
        Button popularSongButton = new Button("Show more about songs");
        popularSongButton.setFont(buttonFont);
        popularSongButton.setStyle("-fx-background-color:LIGHTGREEN;");
        Button requestButton = new Button("Show more about request");
        requestButton.setFont(buttonFont);
        requestButton.setStyle("-fx-background-color:LIGHTGREEN;");

        TableView<Artist> artistTableView = new TableView<>();

        TableColumn<Artist, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Artist, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        ObservableList<Artist> artistList = FXCollections.observableArrayList(user.getFollowedArtist());

        artistTableView.getColumns().addAll(nameColumn, usernameColumn);

        artistTableView.setItems(artistList);


        TableView<Song> followedArtistsSongsTableVie = new TableView<>();

        TableColumn<Song, String> songTitle = new TableColumn<>("song title");
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> artistName = new TableColumn<>("artist name");
        artistName.setCellValueFactory(new PropertyValueFactory<>("artists"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        followedArtistsSongsTableVie.getColumns().addAll(songTitle, artistName, releaseDate, views);

        ObservableList<Song> songsList = FXCollections.observableArrayList(user.getFollowedSong().reversed());

        followedArtistsSongsTableVie.setItems(songsList);



        TableView<Song> popularSongTable = new TableView<>();

        TableColumn<Song, String> popularSongTitle = new TableColumn<>("song title");
        popularSongTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> popularArtistName = new TableColumn<>("artist name");
        popularArtistName.setCellValueFactory(new PropertyValueFactory<>("artists"));

        TableColumn<Song, String> popularReleaseDate = new TableColumn<>("release date");
        popularReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> popularViews = new TableColumn<>("views");
        popularViews.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        popularSongTable.getColumns().addAll(popularSongTitle, popularArtistName, popularReleaseDate, popularViews);

        ObservableList<Song> pList = FXCollections.observableArrayList(popularSongs());

        popularSongTable.setItems(pList);


        TableView<Request> requestTableView = new TableView<>();

        TableColumn<Request, String> artistNameColumn = new TableColumn<>("artist name");
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));

        TableColumn<Request, String> songTitleColumn = new TableColumn<>("song title");
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));

        TableColumn<Request, String> statusColumn = new TableColumn<>("status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Request, String> releaseDateColumn = new TableColumn<>("release date");
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        ObservableList<Request> requestList = FXCollections.observableArrayList(user.getRequests().reversed());

        requestTableView.getColumns().addAll(artistNameColumn, songTitleColumn, statusColumn, releaseDateColumn);

        requestTableView.setItems(requestList);


        songButton.setOnAction(e -> {

            Song selectedSong = followedArtistsSongsTableVie.getSelectionModel().getSelectedItem();
            showSelectedSong(selectedSong);
        });

        artistButton.setOnAction(e -> {

            Artist selectedArtist = artistTableView.getSelectionModel().getSelectedItem();
            showSearchedArtist(selectedArtist);
        });

        popularSongButton.setOnAction(e -> {

            Song selectedSong = popularSongTable.getSelectionModel().getSelectedItem();
            showSelectedSong(selectedSong);
        });

        requestButton.setOnAction(e -> {

            Request request = requestTableView.getSelectionModel().getSelectedItem();
            showRequestUser(request);
        });

        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(showMyProfile, 0, 1);
        gridPane.add(searchLabel, 0, 2);
        gridPane.add(searchField, 1, 2);
        gridPane.add(searchButton, 2, 2);
        gridPane.add(followedArtistsLabel, 0, 3);
        gridPane.add(followedSongsLabel, 1, 3);
        gridPane.add(popularSongs, 2, 3);
        gridPane.add(requestsLabel, 3, 3);
        gridPane.add(artistTableView, 0, 4);
        gridPane.add(followedArtistsSongsTableVie, 1, 4);
        gridPane.add(popularSongTable, 2, 4);
        gridPane.add(artistButton, 0, 5);
        gridPane.add(songButton, 1, 5);
        gridPane.add(popularSongButton, 2, 5);
        gridPane.add(requestTableView,3, 4);
        gridPane.add(requestButton, 3, 5);

        Scene scene = new Scene(gridPane, 1450, 800);
        stage.setScene(scene);

        stage.show();

    }

    public static List<Song> popularSongs()
    {
        Collections.sort(songsList, Comparator.comparingInt(Song::getViewsNumber).reversed());

        List <Song> popularSongsList = new ArrayList<>();

        for (int i = 0; i < 6; i++)
        {
            popularSongsList.add(songsList.get(i));
        }

        return popularSongsList;
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
