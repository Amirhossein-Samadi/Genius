package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAlbum {

    public static void insertAlbumsTable(Connection conn, String title, String artistName, String releaseDate) throws SQLException {

        String sql = "INSERT INTO albums(title,artistName,releaseDate) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, title);
        ps.setString(2, artistName);
        ps.setString(3, releaseDate);

        ps.executeUpdate();
    }
}
