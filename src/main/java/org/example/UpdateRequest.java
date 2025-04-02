package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.example.DbConnection.connectGenuisDb;

public class UpdateRequest {

    public static void updateRequestByArtist(String username, String artist, String songTitle, int status)
    {
        String sql = "UPDATE requests SET status = ? WHERE username = ? AND artistName = ? AND songTitle = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, status);
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }
}
