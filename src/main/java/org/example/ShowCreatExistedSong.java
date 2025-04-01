package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static org.example.SearchSong.searchSong;

public class ShowCreatExistedSong extends Application {

    public static void showCreateExistedSong(Album album)
    {
        Stage stage = new Stage();
        stage.setTitle("add an existed song Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);

        Label titleLabel = new Label("title");

        TextField titleField = new TextField();

        Button addSongButton = new Button("add song");
        addSongButton.setOnAction(event -> {

            album.addSong(searchSong(titleField.getText()));
        });

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(titleField, 1, 0);
        gridPane.add(addSongButton, 1, 1);

        Scene scene = new Scene(gridPane, 300, 150);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
