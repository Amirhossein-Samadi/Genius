package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingSongs.songsList;

public class LoadingComments {

    public static List<Comment> commentsList = new ArrayList<>();

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

                commentsList.add(comment);
                linkCommentsToSongs(comment);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkCommentsToSongs(Comment comment) {

        for (Song song : songsList)
        {
            if (song.getTitle().equals(comment.getSongTitle()))
            {
                song.setComments(comment);
            }
        }
    }
}
