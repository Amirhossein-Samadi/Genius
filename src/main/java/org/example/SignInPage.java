package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.sql.SQLException;

import static org.example.AdminPage.showAdminPage;
import static org.example.Artist.searchArtists;
import static org.example.ArtistPage.showArtistPage;
import static org.example.LoadAdmin.searchAdmins;
import static org.example.LoadFollowedArtists.*;
import static org.example.LoadingAlbums.loadAlbums;
import static org.example.LoadingArtists.artistsList;
import static org.example.LoadingArtists.loadArtists;
import static org.example.LoadingComments.loadComments;
import static org.example.LoadingSongs.*;
import static org.example.LoadingUsers.loadUsers;
import static org.example.LoadingUsers.searchUsers;
import static org.example.UserPage.showUserPage;

public class SignInPage extends Application {

    static User nowUser;
    static Artist nowArtist;

    public static void showSignInPage()
    {
        Stage stage = new Stage();
        stage.setTitle("Sign In Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);

        Label usernameLabel = new Label("Enter Username");
        usernameLabel.setTextFill(Color.WHITE);
        Label passwordLabel = new Label("Enter Password");
        passwordLabel.setTextFill(Color.WHITE);
        Label invalid = new Label("Invalid Username or Password");
        invalid.setTextFill(Color.WHITE);

        TextField usernameTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setTextFill(Color.WHITE);
        loginButton.setStyle("-fx-background-color:#32cd32;");

        loginButton.setOnAction(event -> {

            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            User currentUser = searchUsers(username, password);
            Artist currentArtist = searchArtists(username, password);
            Admin currentAdmin = searchAdmins(username, password);

            nowUser = currentUser;
            nowArtist = currentArtist;

            if (currentUser != null)
            {
                // Loads :

                linkArtistsToUsers(currentUser);
                currentUser.setFollowedSong();
                showUserPage(currentUser);

//                for(Song song : currentUser.getFollowedSong()){System.out.println(song.getTitle());}
            }
            else if (currentArtist != null)
            {
                if (currentArtist.getStatus() == 1)
                {
                    showArtistPage(currentArtist);
                } else if (currentArtist.getStatus() == 2) {

                    Label notExist = new Label("Your registration request has not been approved. ");
                    notExist.setFont(labelFont2);
                    gridPane.add(notExist, 0, 3);
                }
                else
                {
                    Label indeterminateLabel = new Label("Your request is under review.. ");
                    indeterminateLabel.setFont(labelFont2);
                    gridPane.add(indeterminateLabel, 0, 3);
                    System.out.println(currentArtist.getStatus());
                }
            } else if (currentAdmin != null) {
                showAdminPage(currentAdmin);
            } else
            {
                gridPane.add(invalid, 0, 3);
            }
        });

        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordTextField, 1, 1);
        gridPane.add(loginButton, 0, 2);

        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
