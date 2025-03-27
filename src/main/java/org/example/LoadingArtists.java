package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.DbConnection.connectGenuisDb;

public class LoadingArtists {

    private static ArrayList<Artist> artistsList;

    public static void loadUsers() throws SQLException {

        String sql = "SELECT * FROM UsersData";

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

                Artist artist = new Artist(name, age, email, username, password, role);

                artistsList.add(artist);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }
}
