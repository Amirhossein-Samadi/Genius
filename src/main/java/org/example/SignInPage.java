package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.sql.SQLException;

import static org.example.LoadFollowedArtists.linkFollowedArtists;
import static org.example.LoadFollowedArtists.loadFollowedArtists;
import static org.example.LoadingAlbums.loadAlbums;
import static org.example.LoadingArtists.loadArtists;
import static org.example.LoadingComments.loadComments;
import static org.example.LoadingSongs.loadSongs;
import static org.example.LoadingUsers.searchUsers;
import static org.example.UserPage.showUserPage;

public class SignInPage extends Application {

    public static void showSignInPage()
    {
        Stage stage = new Stage();
        stage.setTitle("Sign In Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label usernameLabel = new Label("Enter Username");
        Label passwordLabel = new Label("Enter Password");
        Label invalid = new Label("Invalid Username or Password");

        TextField usernameTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();

        Button loginButton = new Button("Login");

        loginButton.setOnAction(event -> {

            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            User currentUser = searchUsers(username, password);

            if (currentUser != null)
            {
                currentUser.setFollowedSong();
                showUserPage(currentUser);
            }
            else
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
