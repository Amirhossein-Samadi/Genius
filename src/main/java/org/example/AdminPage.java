package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.LoadRequest.requestsList;
import static org.example.LoadingArtists.artistsList;
import static org.example.PersonalInformationPage.showPersonalInformation;
import static org.example.SearchAlbum.searchAlbum;
import static org.example.SearchArtist.searchArtist;
import static org.example.SearchSong.searchSong;
import static org.example.ShowSearchedArtist.showSearchedArtist;
import static org.example.ShowSelectedAlbum.showSelectedAlbum;
import static org.example.ShowSelectedSong.showSelectedSong;

public class AdminPage extends Application {

    public static void showAdminPage(Admin admin)
    {
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

        TextField searchField = new TextField();

        Button showMyProfile = new Button("Show My Profile");
        showMyProfile.setFont(buttonFont);
        showMyProfile.setStyle("-fx-background-color:LIGHTBLUE;");
        showMyProfile.setOnAction(e -> {showPersonalInformation(admin);});
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


        TableView<Artist> artistTableView = new TableView<>();

        TableColumn<Artist, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Artist, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        ObservableList<Artist> artistList = FXCollections.observableArrayList(artistsList);

        artistTableView.getColumns().addAll(nameColumn, usernameColumn);

        artistTableView.setItems(artistList);


        TableView<Request> requestTableView = new TableView<>();

        TableColumn<Request, String> artistNameColumn = new TableColumn<>("artist name");
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));

        TableColumn<Request, String> songTitleColumn = new TableColumn<>("song title");
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));

        TableColumn<Request, String> statusColumn = new TableColumn<>("status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Request, String> releaseDateColumn = new TableColumn<>("release date");
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        ObservableList<Request> requestList = FXCollections.observableArrayList(requestsList.reversed());

        requestTableView.getColumns().addAll(artistNameColumn, songTitleColumn, statusColumn, releaseDateColumn);

        requestTableView.setItems(requestList);


        TableView<SignUpRequest> signUpTableView = new TableView<>();

        TableColumn<SignUpRequest, String> artistColumn = new TableColumn<>("artist name");
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));

        TableColumn<SignUpRequest, String> statusColumn2 = new TableColumn<>("status");
        statusColumn2.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<SignUpRequest, String> releaseDateColumn2 = new TableColumn<>("release date");
        releaseDateColumn2.setCellValueFactory(new PropertyValueFactory<>("date"));

        signUpTableView.getColumns().addAll(artistColumn, statusColumn2, releaseDateColumn2);

        signUpTableView.setItems(...);
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
