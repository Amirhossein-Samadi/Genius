package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class PersonalInformationPage extends Application {

    public static void showPersonalInformation(User user)
    {
        Stage stage = new Stage();
        stage.setTitle("Personal Information");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labeFont = Font.font("", FontWeight.NORMAL, 17);

        String name = "name : " + user.getName();
        String userName = "username : " + user.getUserName();
//        String password = "password : " + user.getPassword();
        String age = "age : " + user.getAge();
        String email = "email : " + user.getEmail();

        Label nameLabel = new Label(name);
        nameLabel.setFont(labeFont);
        Label usernameLabel = new Label(userName);
        usernameLabel.setFont(labeFont);
//        Label passwordLabel = new Label(password);
        Label ageLabel = new Label(age);
        ageLabel.setFont(labeFont);
        Label emailLabel = new Label(email);
        emailLabel.setFont(labeFont);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(usernameLabel, 0, 1);
//        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(emailLabel, 0, 3);

        Scene scene = new Scene(gridPane, 350, 250);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
