package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        for (User user : usersList)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                return user;
            }
        }

        return null;
    }
}
