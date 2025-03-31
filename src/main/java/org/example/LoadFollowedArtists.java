package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.LoadingArtists.artistsList;
import static org.example.LoadingUsers.usersList;

public class LoadFollowedArtists
{
    public static List<FollowedArtists> followedArtistsList = new ArrayList<>();

    public static void loadFollowedArtists() throws SQLException
    {
        String sql = "SELECT * FROM FollowArtists";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                String username = rs.getString("username");
                String artistname = rs.getString("artistname");

                FollowedArtists followedArtists = new FollowedArtists(username, artistname);

                followedArtistsList.add(followedArtists);
            }
        } catch (Exception e)
        {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkFollowedArtists()
    {
        for (FollowedArtists followedArtists : followedArtistsList)
        {
            for (User user : usersList)
            {
                for (Artist artist : artistsList)
                {
                    if (user.getUserName().equals((followedArtists.getUserName())) && artist.getUserName().equals((followedArtists.getArtistName()))) {user.setFollowedArtist(artist);}
                    else if (user.getUserName().equals(followedArtists.getUserName()) && artist.getName().equals(followedArtists.getArtistName())) {user.setFollowedArtist(artist);}
                }
            }
        }
    }
}
