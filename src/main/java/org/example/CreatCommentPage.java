package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static org.example.SignInPage.nowUser;
import static org.example.SignInPage.passUser;

public class CreatCommentPage extends Application {

    public static void showCreateCommentPage(User user)
    {
        Stage stage = new Stage();
        stage.setTitle("Create Comment");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(12);
        gridPane.setHgap(12);

        Font labeFont = Font.font("", FontWeight.NORMAL, 15);

        Label label = new Label("Write Your Comment : ");

        TextField commentTextField = new TextField();

        Button commentButton = new Button("Comment");

        /// //////////////////////////////////////////// Dateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
        commentButton.setOnAction(event -> {
            Comment comment = new Comment(commentTextField.getText(), nowUser.getUserName(), )
        });

        Scene scene = new Scene(gridPane, 600, 400);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {}
}
