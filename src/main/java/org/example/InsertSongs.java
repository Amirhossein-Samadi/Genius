package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSongs {

    public static void insertSong(Connection conn, String title, String album, String artists, String lyrics, String genre, String tags, int views, String releaseDate) throws SQLException {

        String sql = "INSERT INTO songs(title,album,artists,lyrics,genre,tags,views,releasedate) VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, title);
        ps.setString(2, album);
        ps.setString(3, artists);
        ps.setString(4, lyrics);
        ps.setString(5, genre);
        ps.setString(6, tags);
        ps.setInt(7, views);
        ps.setString(8, releaseDate);

        ps.executeUpdate();
    }
}
