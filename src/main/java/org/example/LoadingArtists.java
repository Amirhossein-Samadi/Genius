package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;

public class LoadingArtists {

    public static List<Artist> artistsList = new ArrayList<>();

    public static void loadArtists() throws SQLException {

        String sql = "SELECT * FROM ArtistsData";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                int status = rs.getInt("status");

                Artist artist = new Artist(name, age, email, username, password, role);
                artist.setStatus(status);

                artistsList.add(artist);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            loadArtists();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Artist artist : artistsList) {System.out.println(artist.getUserName());}
    }
}
