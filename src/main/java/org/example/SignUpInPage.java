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

import static org.example.SignUpPage.showSignUpPage;

public class SignUpInPage extends Application {

    public static void showSignUpInPage() {

        Stage stage = new Stage();
        stage.setTitle("Sign-up(In) Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setVgap(20);

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);

        Label signInLabel = new Label("if you have an Account.");
        Label signUpLabel = new Label("if you don't have an Account.");

        signUpLabel.setFont(labeFont);
        signInLabel.setFont(labeFont);

        Button signInButton = new Button("Sign In");
        Button signUpButton = new Button("Sign Up");

        signInButton.setOnAction(event -> {});
        signUpButton.setOnAction(event -> {showSignUpPage();});

        Font buttonFont = Font.font("Verdana", FontWeight.BOLD, 18);

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
