package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.example.DbConnection.connectGenuisDb;

public class UpdateSong {

    public static void updateSongAlbum(String album, String title)
    {
        String sql = "UPDATE songs SET album = ? WHERE title = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, album);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }

    public static void updateSongViews(int viewsNumber, String title)
    {
        String sql = "UPDATE songs SET views = ? WHERE title = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, viewsNumber);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }

    public static void updateLyricsByRequest(String lyrics, String title)
    {
        String sql = "UPDATE songs SET lyrics = ? WHERE title = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, lyrics);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }

    public static void updateSongArtist(String album, String lyrics, String genre, String tags, String title)
    {
        String sql = "UPDATE songs SET album = ?, lyrics = ?, genre = ?, tags = ? WHERE title = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, album);
            pstmt.setString(2, lyrics);
            pstmt.setString(3, genre);
            pstmt.setString(4, tags);
            pstmt.setString(5, title);

            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }
}
