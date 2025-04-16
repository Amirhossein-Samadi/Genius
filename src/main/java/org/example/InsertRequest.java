package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRequest {

    public static void insertRequest(Connection conn, String username, String artistName, String songTitle, String recommendedLyrics, String description, String releaseDate, int status) throws SQLException {

        String sql = "INSERT INTO requests(username,artistName,songTitle,recommendedLyrics,description,releaseDate,status) VALUES(?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, artistName);
        ps.setString(3, songTitle);
        ps.setString(4, recommendedLyrics);
        ps.setString(5, description);
        ps.setString(6, releaseDate);
        ps.setInt(7, status);

        ps.executeUpdate();
    }
}
