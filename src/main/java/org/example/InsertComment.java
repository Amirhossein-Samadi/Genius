package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertComment {

    public static void insertCommentsTable(Connection conn, String message, String author, String date, String songTitle) throws SQLException {

        String sql = "INSERT INTO ArtistsData(message,author,date,songTitle) VALUES(?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, message);
        ps.setString(2, author);
        ps.setString(3, date);
        ps.setString(4, songTitle);

        ps.executeUpdate();
    }
}
