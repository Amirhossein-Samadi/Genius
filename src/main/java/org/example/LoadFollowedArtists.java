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

                linkFollowedArtists(username, artistname);
            }
        } catch (Exception e)
        {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void linkFollowedArtists(String username, String artistname)
    {
        for (User user : usersList)
        {
            if (user.getUserName().equals(username))
            {
                for (Artist artist : artistsList)
                {
                    if (artist.getUserName().equals(artistname))
                    {
                        user.setFollowedArtist(artist);
                    }
                }
            }
        }
    }
}
