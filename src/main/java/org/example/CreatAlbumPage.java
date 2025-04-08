package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertAlbum.insertAlbumsTable;
import static org.example.LoadingAlbums.albumsList;
import static org.example.SignInPage.nowArtist;

public class CreatAlbumPage extends Application {

    public static void showCreatAlbumPage()
    {
        Stage stage = new Stage();
        stage.setTitle("Creat Song Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("Verdana", FontWeight.BOLD, 18);
        Font labelFont2 = Font.font("", FontWeight.NORMAL, 14);
        Font buttonFont = Font.font("", FontWeight.NORMAL, 12);

        Label titleLabel = new Label("title : ");
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setFont(labelFont2);

        TextField titleField = new TextField();

        Button creatAlbumButton = new Button("Create Album");
        creatAlbumButton.setTextFill(Color.WHITE);
        creatAlbumButton.setFont(buttonFont);
        creatAlbumButton.setStyle("-fx-background-color:#32cd32;");
        creatAlbumButton.setOnAction(e -> {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            Album album = new Album(titleField.getText(), nowArtist.getUserName(), formattedDateTime);
            albumsList.add(album);
            try {
                insertAlbumsTable(connectGenuisDb(), titleField.getText(), nowArtist.getUserName(), formattedDateTime);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(titleField, 1, 0);
        gridPane.add(creatAlbumButton, 1, 2);

        Scene scene = new Scene(gridPane, 350, 170);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
