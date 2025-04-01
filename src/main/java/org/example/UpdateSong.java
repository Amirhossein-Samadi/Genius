package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.example.DbConnection.connectGenuisDb;

public class UpdateSong {

    public static void updateSongAlbum(String album)
    {
        String sql = "UPDATE songs SET album = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, album);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Updated.");
            }
            else
            {
                System.out.println("کاربری با این username یافت نشد.");
            }
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }
}
