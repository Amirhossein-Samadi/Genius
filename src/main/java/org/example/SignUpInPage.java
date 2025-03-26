package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignUpInPage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        launch();
    }

    public static void showSignUpInPage() {

        Stage stage = new Stage();
        stage.setTitle("Sign-up(In) Page");

        GridPane gridPane = new GridPane();

        Label signInLabel = new Label("if you have an Account.");
        Label signUpLabel = new Label("if you don't have an Account.");

        Button signInButton = new Button("Sign In");
        Button signUpButton = new Button("Sign Up");

        gridPane.add(signInLabel, 0, 0);
        gridPane.add(signInButton, 1, 0);
        gridPane.add(signUpLabel, 0, 1);
        gridPane.add(signUpButton, 1, 1);

        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);

        stage.show();
    }
}
