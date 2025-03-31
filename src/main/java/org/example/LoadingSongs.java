package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingAlbums.albumsList;
import static org.example.LoadingArtists.artistsList;

public class LoadingSongs {

    public static List<Song> songsList = new ArrayList<>();

    public static void loadSongs() throws SQLException {

        String sql = "SELECT * FROM songs";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String title = rs.getString("title");
                String album = rs.getString("album");
                String artists = rs.getString("artists");
                String lyrics = rs.getString("lyrics");
                String genre = rs.getString("genre");
                String tags = rs.getString("tags");
                int views = rs.getInt("views");
                String releaseDate = rs.getString("releaseDate");

                Song song = new Song(title, album, artists, lyrics, genre, releaseDate);

                song.setViewsNumber(views);
                song.setTags(tags);

                songsList.add(song);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkSongsToArtists()
    {
        for (Song song : songsList)
        {
            for (Artist artist : artistsList)
            {
                if (song.getArtists().equals(artist.getUserName()))
                {
                    artist.addSong(song);
                }
            }
        }
    }

    public static void linkSongsToAlbums()
    {
        for (Song song : songsList)
        {
            for (Album album : albumsList)
            {
                if (song.getArtists().equals(album.getArtist()))
                {
                    album.addSong(song);
                }
            }
        }
    }
}
