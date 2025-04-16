package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertArtistsData.insertArtistsTable;
import static org.example.InsertSignUpRequests.insertSignUpRequests;
import static org.example.InsertUsersData.insertUsersTable;

public class SignUpPage extends Application {

    public static void showSignUpPage() {

        Stage stage = new Stage();
        stage.setTitle("Sign Up");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label nameLabel = new Label("Name : ");
        nameLabel.setTextFill(Color.WHITE);
        Label ageLabel = new Label("Age : ");
        ageLabel.setTextFill(Color.WHITE);
        Label emailLabel = new Label("Email : ");
        emailLabel.setTextFill(Color.WHITE);
        Label usernameLabel = new Label("Username : ");
        usernameLabel.setTextFill(Color.WHITE);
        Label passwordLabel = new Label("Password : ");
        passwordLabel.setTextFill(Color.WHITE);
        Label roleLabel = new Label("Role (artist or user) : ");
        roleLabel.setTextFill(Color.WHITE);

        nameLabel.setFont(labeFont);
        ageLabel.setFont(labeFont);
        emailLabel.setFont(labeFont);
        usernameLabel.setFont(labeFont);
        passwordLabel.setFont(labeFont);
        roleLabel.setFont(labeFont);

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField emailField = new TextField();
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        RadioButton userRadio = new RadioButton("user");
        userRadio.setTextFill(Color.WHITE);
        RadioButton artistRadio = new RadioButton("artist");
        artistRadio.setTextFill(Color.WHITE);

        ToggleGroup roleGroup = new ToggleGroup();
        userRadio.setToggleGroup(roleGroup);
        artistRadio.setToggleGroup(roleGroup);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setTextFill(Color.WHITE);
        signUpButton.setFont(buttonFont);
        signUpButton.setStyle("-fx-background-color:#32cd32;");
        signUpButton.setOnAction(event -> {

            if (roleGroup.getSelectedToggle() != null)
            {
                RadioButton selectedRadio = (RadioButton) roleGroup.getSelectedToggle();

                if (selectedRadio == artistRadio)
                {
                    LocalDateTime now = LocalDateTime.now();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = now.format(formatter);

                    try {
                        insertArtistsTable(connectGenuisDb(), nameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), usernameField.getText(), passwordField.getText(), 2, 3);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        insertSignUpRequests(connectGenuisDb(), usernameField.getText(), 3, formattedDateTime);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (selectedRadio == userRadio)
                {
                    try {
                        insertUsersTable(connectGenuisDb(), nameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), usernameField.getText(), passwordField.getText(), 1);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else
            {
                Label errorLabel = new Label("Please select a role");
                errorLabel.setTextFill(Color.WHITE);
                errorLabel.setFont(labeFont);

                gridPane.add(errorLabel, 1, 7);
            }
        });

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(ageLabel, 0, 1);
        gridPane.add(ageField, 1, 1);
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailField, 1, 2);
        gridPane.add(usernameLabel, 0, 3);
        gridPane.add(usernameField, 1, 3);
        gridPane.add(passwordLabel, 0, 4);
        gridPane.add(passwordField, 1, 4);
        gridPane.add(roleLabel, 0, 5);
        gridPane.add(userRadio, 1, 5);
        gridPane.add(artistRadio, 2, 5);


        gridPane.add(signUpButton, 1, 6);

        Scene scene = new Scene(gridPane, 600, 500);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
