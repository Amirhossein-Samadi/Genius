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

        TextField username = new TextField();
        PasswordField password = new PasswordField();

        Button loginButton = new Button("Login");


        Scene scene = new Scene(gridPane, 500, 700);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
