package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFollowedArtists {

    public static void insertFollowedArtistsTable(Connection conn, String username, String artistname) throws SQLException {

        String sql = "INSERT INTO FollowArtists(username,artistname) VALUES(?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, username);
        ps.setString(2, artistname);

        ps.executeUpdate();
    }
}
