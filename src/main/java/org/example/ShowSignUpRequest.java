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

public class ShowSignUpRequest extends Application {

    public static void showSignUpRequest(SignUpRequest signUpRequest)
    {
        Stage stage = new Stage();
        stage.setTitle("User Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 16);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 14);

        Label artistUserNameLabel = new Label("Artist User Name :" + signUpRequest.getArtistName());
        artistUserNameLabel.setFont(labelFont2);
        Label dateLabel = new Label("Registration application date :" + signUpRequest.getDate());
        dateLabel.setFont(labelFont2);
        Label statusLabel = new Label("Status :" + signUpRequest.getStatus());
        statusLabel.setFont(labelFont2);

        Button acceptButton = new Button("Accept");
        acceptButton.setFont(buttonFont);
        acceptButton.setStyle("-fx-background-color:LIGHTGREEN;");
        acceptButton.setOnAction(e -> {

            
        });

        Button rejectButton = new Button("Reject");
        rejectButton.setFont(buttonFont);
        rejectButton.setStyle("-fx-background-color:Red;");

        gridPane.add(artistUserNameLabel, 0, 0);
        gridPane.add(statusLabel, 0, 1);
        gridPane.add(dateLabel, 0, 2);

        if (signUpRequest.getStatus() == "Unread")
        {
            gridPane.add(acceptButton, 0, 3);
            gridPane.add(rejectButton, 1, 3);
        }

        Scene scene = new Scene(gridPane, 350, 300);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
