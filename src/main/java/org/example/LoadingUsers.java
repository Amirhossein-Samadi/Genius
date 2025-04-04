package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;

public class LoadingUsers {

    public static List<User> usersList = new ArrayList<>();

    public static void loadUsers() throws SQLException
    {

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

                User user = new User(name, age, email, username, password, role);

                usersList.add(user);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }

    public static User searchUsers(String username, String password)
    {
        String sql = "SELECT * FROM UsersData WHERE username = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");

                if (BCrypt.checkpw(password, storedHashedPassword)) {
                    for (User user : usersList)
                    {
                        if (user.getUserName().equals(username))
                        {
                            return user;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
