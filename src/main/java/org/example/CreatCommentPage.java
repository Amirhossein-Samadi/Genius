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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.SQLException;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertComment.insertCommentsTable;
import static org.example.LoadingComments.commentsList;
import static org.example.ShowSelectedSong.nowSong;
import static org.example.SignInPage.nowUser;
import static org.example.SignInPage.nowArtist;

public class CreatCommentPage extends Application {

    public static void showCreateCommentPage(Song song)
    {
        Stage stage = new Stage();
        stage.setTitle("Create Comment");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("", FontWeight.NORMAL, 15);

        Label label = new Label("Write Your Comment : ");
        label.setTextFill(Color.WHITE);

        TextField commentTextField = new TextField();

        Button commentButton = new Button("Comment");
        commentButton.setTextFill(Color.WHITE);
        commentButton.setStyle("-fx-background-color:#32cd32;");

        commentButton.setOnAction(event -> {

            LocalDateTime now = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            if (nowUser != null)
            {
                Comment comment = new Comment(commentTextField.getText(), nowUser.getUserName(), formattedDateTime,nowSong.getTitle());
                commentsList.add(comment);
                try {
                    insertCommentsTable(connectGenuisDb(), commentTextField.getText(), nowUser.getUserName(), formattedDateTime, song.getTitle());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        gridPane.add(label, 0, 0);
        gridPane.add(commentTextField, 1, 0);
        gridPane.add(commentButton, 1, 1);

        Scene scene = new Scene(gridPane, 400, 200);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
