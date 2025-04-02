package org.example;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import static org.example.DbConnection.connectGenuisDb;

public class DeleteFollowedArtist {

    public static void deleteFollowedArtist(String username, String artistName) throws SQLException {
        String sql = "DELETE FROM FollowArtists WHERE username=? AND artistname=?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, artistName);
            pstmt.executeUpdate();
            System.out.println("کاربر حذف شد.");
        } catch (Exception e) {
            System.out.println("خطا در حذف داده: " + e.getMessage());
        }
    }
}
