package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingSongs.songsList;

public class LoadingComments {

    // private static List<Comment> commentsList = new ArrayList<>();

    public static void loadComments() throws SQLException {

        String sql = "SELECT * FROM Comments";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String message = rs.getString("message");
                String author = rs.getString("author");
                String date = rs.getString("date");
                String songTitle = rs.getString("songtitle");

                Comment comment = new Comment(message, author, date, songTitle);

                linkComments(songTitle, comment);
                
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkComments(String title, Comment comment) {

        for (Song song : songsList)
        {
            if (song.songGetTitle().equals(title))
            {
                song.setComments(comment);
            }
        }
    }
}
