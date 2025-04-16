package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.example.DbConnection.connectGenuisDb;

public class UpdateArtists
{
    public static void updateArtistStatus(String username, int status)
    {
        String sql = "UPDATE ArtistsData SET status = ? WHERE username = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, status);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }
}
