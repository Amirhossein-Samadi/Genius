package org.example;

import javafx.application.Application;
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

        Button showMyProfile = new Button("Show My Profile");


        TableView<Artist> artistTableView = new TableView<>();

        TableColumn<Artist, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Artist, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));

        artistTableView.getColumns().addAll(nameColumn, usernameColumn);

        artistTableView.setItems((ObservableList<Artist>) user.getFollowedArtist());

        TableView<Song> followedArtistsSongsTableVie = new TableView<>();

        TableColumn<Song, String> songTitle = new TableColumn<>("song title");
        songTitle.setCellValueFactory(new PropertyValueFactory<>("song title"));

        TableColumn<Song, String> artistName = new TableColumn<>("artist name");
        artistName.setCellValueFactory(new PropertyValueFactory<>("artist name"));

        TableColumn<Song, String> artistUsername = new TableColumn<>("artist username");
        artistUsername.setCellValueFactory(new PropertyValueFactory<>("artist username"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("release date"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("views"));

        followedArtistsSongsTableVie.getColumns().addAll(songTitle, artistName, artistUsername, releaseDate, views);

        followedArtistsSongsTableVie.setItems((ObservableList<Song>) user.getFollowedSong());

        Scene scene = new Scene(gridPane, 800, 650);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
