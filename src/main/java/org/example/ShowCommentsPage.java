package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class ShowCommentsPage extends Application {

    public static void showCommentsPage(Song song) {

        Stage stage = new Stage();
        stage.setTitle("Personal Information");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);
        gridPane.setStyle("-fx-background-color:#292929;");

        Font labeFont = Font.font("", FontWeight.NORMAL, 15);

        List<Comment> comments = song.getComments();

        int numComments = comments.size();
        int i = 0;

        for (Comment comment : comments.reversed())
        {
            if (i < numComments)
            {
                Label commentLabel = new Label(comment.getAuthor() + " : " + comment.getMessage() + "   " + comment.getDate());
                commentLabel.setTextFill(Color.WHITE);
                commentLabel.setFont(labeFont);
                gridPane.add(commentLabel, 0, i);
                i++;
            }

        }

        Scene scene = new Scene(gridPane, 600, 400);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
