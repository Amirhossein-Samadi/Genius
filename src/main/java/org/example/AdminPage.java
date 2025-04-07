package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.LoadRequest.requestsList;
import static org.example.LoadSignUpRequests.signUpRequestList;
import static org.example.LoadingArtists.artistsList;
import static org.example.LoadingUsers.*;
import static org.example.PersonalInformationPage.showPersonalInformation;
import static org.example.SearchAlbum.searchAlbum;
import static org.example.SearchArtist.searchArtist;
import static org.example.SearchSong.searchSong;
import static org.example.ShowRequestArtist.showRequestArtist;
import static org.example.ShowSearchedArtist.showSearchedArtistAdmin;
import static org.example.ShowSelectedAlbum.showSelectedAlbum;
import static org.example.ShowSelectedSong.showSelectedSongAdmin;
import static org.example.ShowSignUpRequest.showSignUpRequest;

public class AdminPage extends Application {

    public static void showAdminPage(Admin admin)
    {
        Stage stage = new Stage();
        stage.setTitle("User Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(25);
        gridPane.setHgap(20);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label welcomeLabel = new Label("welcome to Genius Application");
        welcomeLabel.setFont(labeFont);
        Label searchLabel = new Label("                                                             Search");
        searchLabel.setFont(labelFont2);
        Label artistsLabel = new Label("                             Artists");
        artistsLabel.setFont(labelFont2);
        Label usersLabel = new Label("                              Users");
        usersLabel.setFont(labelFont2);
        Label signUpLabel = new Label("                Sign Up Requests");
        signUpLabel.setFont(labelFont2);
        Label editLabel = new Label("                               Edit Requests");
        editLabel.setFont(labelFont2);

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
                showSearchedArtistAdmin(artist);
            }

            if (searchAlbum(search) != null)
            {
                Album album = searchAlbum(search);
                showSelectedAlbum(album);
            }

            if (searchSong(search) != null)
            {
                Song song = searchSong(search);
                showSelectedSongAdmin(song);
            }

            if (searchUser2(search) != null)
            {
                User user = searchUser2(search);
                showPersonalInformation(user);
            }

        });

        Button artistButton = new Button("Show more about this artist");
        artistButton.setFont(buttonFont);
        artistButton.setStyle("-fx-background-color:LIGHTGREEN;");

        Button signUpButton = new Button("Determining the situation");
        signUpButton.setFont(buttonFont);
        signUpButton.setStyle("-fx-background-color:LIGHTGREEN;");

        Button editButton = new Button("Edit the request");
        editButton.setFont(buttonFont);
        editButton.setStyle("-fx-background-color:LIGHTGREEN;");

        Button userButton = new Button("Show more about this user");
        userButton.setFont(buttonFont);
        userButton.setStyle("-fx-background-color:LIGHTGREEN;");



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

        TableColumn<Request, String> userNameColumn2 = new TableColumn<>("user name");
        userNameColumn2.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Request, String> songTitleColumn = new TableColumn<>("song title");
        songTitleColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));

        TableColumn<Request, String> statusColumn = new TableColumn<>("status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Request, String> releaseDateColumn = new TableColumn<>("release date");
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        ObservableList<Request> requestList = FXCollections.observableArrayList(requestsList.reversed());

        requestTableView.getColumns().addAll(artistNameColumn, userNameColumn2, songTitleColumn, statusColumn, releaseDateColumn);

        requestTableView.setItems(requestList);


        TableView<SignUpRequest> signUpTableView = new TableView<>();

        TableColumn<SignUpRequest, String> artistColumn = new TableColumn<>("artist name");
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artistName"));

        TableColumn<SignUpRequest, String> statusColumn2 = new TableColumn<>("status");
        statusColumn2.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<SignUpRequest, String> releaseDateColumn2 = new TableColumn<>("release date");
        releaseDateColumn2.setCellValueFactory(new PropertyValueFactory<>("date"));

        signUpTableView.getColumns().addAll(artistColumn, statusColumn2, releaseDateColumn2);

        ObservableList<SignUpRequest> signUpList = FXCollections.observableArrayList(signUpRequestList.reversed());

        signUpTableView.setItems(signUpList);



        TableView<User> userTableView = new TableView<>();

        TableColumn<User, String> nameColumn3 = new TableColumn<>("name");
        nameColumn3.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> userNameColumn = new TableColumn<>("username");
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        userTableView.getColumns().addAll(nameColumn3, userNameColumn);

        ObservableList<User> userObservableList = FXCollections.observableArrayList(usersList);

        userTableView.setItems(userObservableList);

        artistButton.setOnAction(e -> {

            Artist artist = artistTableView.getSelectionModel().getSelectedItem();
            if (artist != null) {showSearchedArtistAdmin(artist);}
        });

        editButton.setOnAction(e -> {

            Request request = requestTableView.getSelectionModel().getSelectedItem();
            if (request != null) {showRequestArtist(request);}
        });

        signUpButton.setOnAction(e -> {

            SignUpRequest signUpRequest = signUpTableView.getSelectionModel().getSelectedItem();
            if (signUpRequest != null) {showSignUpRequest(signUpRequest);}
        });

        userButton.setOnAction(e -> {

            User user = userTableView.getSelectionModel().getSelectedItem();
            if (user != null) {showPersonalInformation(user);}
        });


        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(showMyProfile, 0, 1);
        gridPane.add(searchLabel, 1, 1);
        gridPane.add(searchField, 2, 1);
        gridPane.add(searchButton, 3, 1);
        gridPane.add(artistsLabel, 0, 2);
        gridPane.add(usersLabel, 1, 2);
        gridPane.add(signUpLabel, 2, 2);
        gridPane.add(editLabel, 3, 2);
        gridPane.add(artistTableView, 0, 3);
        gridPane.add(userTableView, 1, 3);
        gridPane.add(signUpTableView, 2, 3);
        gridPane.add(requestTableView, 3, 3);
        gridPane.add(artistButton, 0, 4);
        gridPane.add(userButton, 1, 4);
        gridPane.add(signUpButton, 2, 4);
        gridPane.add(editButton, 3, 4);

        Scene scene = new Scene(gridPane, 1450, 800);
        stage.setScene(scene);

        stage.show();


    }

    @Override
    public void start(Stage stage) throws Exception {}
}
