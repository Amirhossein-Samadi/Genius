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

import static org.example.DbConnection.connectAccountDb;
import static org.example.InserArtistsData.insertArtistsTable;
import static org.example.InsertUsersData.insertUsersTable;

public class SignUpPage extends Application {

    public static void showSignUpPage() {

        Stage stage = new Stage();
        stage.setTitle("Sign Up");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50, 50, 50, 50));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Font labeFont = Font.font("", FontWeight.NORMAL, 16);

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

        CheckBox userCheckBox = new CheckBox("User");
        CheckBox adminCheckBox = new CheckBox("Admin");

        userCheckBox.setSelected(false);
        adminCheckBox.setSelected(false);

        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(event -> {

            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (adminCheckBox.isSelected()) {

                try {
                    insertArtistsTable(connectAccountDb(), name, age, email, username, password, 2);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (userCheckBox.isSelected()) {
                try {
                    insertUsersTable(connectAccountDb(), name, age, email, username, password, 1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
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
        gridPane.add(userCheckBox, 1, 5);
        gridPane.add(adminCheckBox, 2, 5);

        gridPane.add(signUpButton, 1, 6);

        Scene scene = new Scene(gridPane, 500, 700);
        stage.setScene(scene);

        stage.show();

    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
