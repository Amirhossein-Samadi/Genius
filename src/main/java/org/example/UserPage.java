package org.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.SignUpPage.showSignUpPage;

public class UserPage extends Application {

    public static void showUserPage(User user) {

        Stage stage = new Stage();
        stage.setTitle("User Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);

        Label welcomeLabel = new Label("welcome to Genius Application");
        Label searchLabel = new Label("Search");

        TextField searchField = new TextField();

        Button showMyProfile = new Button("Show My Profile");
        Button searchButton = new Button("Search");

        TableView<Artist> artistTableView = new TableView<>();

        TableColumn<Artist, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Artist, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        artistTableView.getColumns().addAll(nameColumn, usernameColumn);

        artistTableView.setItems((ObservableList<Artist>) user.getFollowedArtist());



        TableView<Song> followedArtistsSongsTableVie = new TableView<>();

        TableColumn<Song, String> songTitle = new TableColumn<>("song title");
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> artistName = new TableColumn<>("artist name");
        artistName.setCellValueFactory(new PropertyValueFactory<>("artists"));

//        TableColumn<Song, String> artistUsername = new TableColumn<>("artist username");
//        artistUsername.setCellValueFactory(new PropertyValueFactory<>("artist username"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        followedArtistsSongsTableVie.getColumns().addAll(songTitle, artistName, releaseDate, views);

        followedArtistsSongsTableVie.setItems((ObservableList<Song>) user.getFollowedSong());

        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(showMyProfile, 1, 0);
        gridPane.add(searchLabel, 0, 1);
        gridPane.add(searchField, 1, 1);
        gridPane.add(searchButton, 2, 1);
        gridPane.add(artistTableView, 0, 3);
        gridPane.add(followedArtistsSongsTableVie, 1, 3);

        Scene scene = new Scene(gridPane, 800, 650);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
