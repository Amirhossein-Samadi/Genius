package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.SQLException;


import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertArtistsData.insertArtistsTable;
import static org.example.InsertUsersData.insertUsersTable;

public class SignUpPage extends Application {

    public static void showSignUpPage() {

        Stage stage = new Stage();
        stage.setTitle("Sign Up");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labeFont = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label nameLabel = new Label("Name : ");
        Label ageLabel = new Label("Age : ");
        Label emailLabel = new Label("Email : ");
        Label usernameLabel = new Label("Username : ");
        Label passwordLabel = new Label("Password : ");
        Label roleLabel = new Label("Role (artist or user) : ");

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
        RadioButton artistRadio = new RadioButton("artist");

        ToggleGroup roleGroup = new ToggleGroup();
        userRadio.setToggleGroup(roleGroup);
        artistRadio.setToggleGroup(roleGroup);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setFont(buttonFont);
        signUpButton.setStyle("-fx-background-color:LIGHTGREEN;");
        signUpButton.setOnAction(event -> {

            if (roleGroup.getSelectedToggle() != null)
            {
                RadioButton selectedRadio = (RadioButton) roleGroup.getSelectedToggle();

                if (selectedRadio == artistRadio)
                {
                    try {
                        insertArtistsTable(connectGenuisDb(), nameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), usernameField.getText(), passwordField.getText(), 2, 3);
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
