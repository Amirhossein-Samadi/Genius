package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static org.example.ShowSelectedSong.showSelectedSong;

public class ShowSelectedAlbum extends Application {

    public static void showSelectedAlbum(Album album)
    {
        Stage stage = new Stage();
        stage.setTitle("Album Information");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setStyle("-fx-background-color:LIGHTGRAY;");

        Label titleLabel = new Label("album title : " + album.getTitle());
        Label artistLabel = new Label("album artist : " + album.getArtist());
        Label releaseDateLabel = new Label("album release date : " + album.getReleaseDate());

        Button songButton = new Button("show more about song");
        songButton.setStyle("-fx-background-color:LIGHTBLUE;");

        TableView<Song> albumSongs = new TableView<>();

        TableColumn<Song, String> songTitle = new TableColumn<>("song title");
        songTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Song, String> artistName = new TableColumn<>("artist name");
        artistName.setCellValueFactory(new PropertyValueFactory<>("artists"));

        TableColumn<Song, String> releaseDate = new TableColumn<>("release date");
        releaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        TableColumn<Song, Integer> views = new TableColumn<>("views");
        views.setCellValueFactory(new PropertyValueFactory<>("viewsNumber"));

        albumSongs.getColumns().addAll(songTitle, artistName, releaseDate, views);

        ObservableList<Song> songsList = FXCollections.observableArrayList(album.getTrackList());

        albumSongs.setItems(songsList);

        songButton.setOnAction(e -> {

            Song selectedSong = albumSongs.getSelectionModel().getSelectedItem();
            showSelectedSong(selectedSong);
        });

        gridPane.add(titleLabel, 0, 0);
        gridPane.add(artistLabel, 0, 1);
        gridPane.add(releaseDateLabel, 0, 2);
        gridPane.add(albumSongs, 0, 3);
        gridPane.add(songButton, 0, 4);


        Scene scene = new Scene(gridPane, 900, 650);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
