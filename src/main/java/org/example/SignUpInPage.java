package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.sql.SQLException;

import static org.example.LoadAdmin.loadAdmins;
import static org.example.LoadFollowedArtists.loadFollowedArtists;
import static org.example.LoadRequest.loadRequests;
import static org.example.LoadSignUpRequests.loadSignUpRequests;
import static org.example.LoadingAlbums.*;
import static org.example.LoadingArtists.loadArtists;
import static org.example.LoadingComments.loadComments;
import static org.example.LoadingSongs.*;
import static org.example.LoadingUsers.loadUsers;
import static org.example.SignInPage.showSignInPage;
import static org.example.SignUpPage.showSignUpPage;

public class SignUpInPage extends Application {

    public static void showSignUpInPage() {

        Stage stage = new Stage();
        stage.setTitle("Sign-up(In) Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setVgap(20);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label signInLabel = new Label("if you have an Account.");
        signInLabel.setTextFill(Color.WHITE);
        Label signUpLabel = new Label("if you don't have an Account.");
        signUpLabel.setTextFill(Color.WHITE);

        signUpLabel.setFont(labeFont);
        signInLabel.setFont(labeFont);

        Button signInButton = new Button("Sign In");
        signInButton.setFont(buttonFont);
        signInButton.setTextFill(Color.WHITE);
        signInButton.setStyle("-fx-background-color:#32cd32;");
        Button signUpButton = new Button("Sign Up");
        signUpButton.setFont(buttonFont);
        signUpButton.setTextFill(Color.WHITE);
        signUpButton.setStyle("-fx-background-color:#00bfff;");

        signInButton.setOnAction(event -> {
            try {
                loadUsers();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadArtists();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadAdmins();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadSignUpRequests();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadSongs();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadAlbums();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadComments();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                loadRequests();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            linkSongsToAlbums();
            linkSongsToArtists();
            linkAlbumsToArtists();
            try {
                loadFollowedArtists();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            showSignInPage();
        });
        signUpButton.setOnAction(event -> {showSignUpPage();});

//        Font buttonFont = Font.font("Verdana", FontWeight.BOLD, 18);

        gridPane.add(signInLabel, 0, 0);
        gridPane.add(signInButton, 0, 1);
        gridPane.add(signUpLabel, 0, 2);
        gridPane.add(signUpButton, 0, 3);

        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {}
}
