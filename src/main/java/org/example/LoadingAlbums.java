package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingSongs.songsList;

public class LoadingAlbums {

    public static List<Album> albumsList = new ArrayList<>();

    public static void loadAlbums() throws SQLException {

        String sql = "SELECT * FROM albums";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String title = rs.getString("title");
                String artistName = rs.getString("artistName");
                String releaseDate = rs.getString("releaseDate");

                Album album = new Album(title, artistName, releaseDate);

                albumsList.add(album);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkSongsToAlbums() {

        for (Song song : songsList)
        {
            for (Album album : albumsList)
            {
                if (song.songGetAlbum().equals(album))
            }
        }
    }
}
