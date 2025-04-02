package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingArtists.artistsList;
import static org.example.LoadingSongs.songsList;
import static org.example.LoadingUsers.usersList;

public class LoadRequest {

    public static List<Request> requestsList = new ArrayList<>();

    public static void loadRequests() throws SQLException {

        String sql = "SELECT * FROM requests";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String username = rs.getString("username");
                String artistName = rs.getString("artistName");
                String songTitle = rs.getString("songTitle");
                String recommendedLyrics = rs.getString("recommendedLyrics");
                String description = rs.getString("description");
                String releaseDate = rs.getString("releaseDate");
                int status = rs.getInt("status");

                Request request = new Request(username, artistName, songTitle, recommendedLyrics, description, releaseDate, status);

                requestsList.add(request);

            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkRequestsToAll(Request request)
    {
        for (User user : usersList)
        {
            if (user.getUserName().equals(request.getUsername())) { user.setRequests(request);}

            for (Artist artist : artistsList)
            {
                if (artist.getUserName().equals(request.getArtistName())) { artist.setRequests(request);}

                for (Song song : songsList)
                {
                    if (song.getTitle().equals(request.getSongTitle())) { song.setRequests(request);}
                }
            }
        }
    }
}
