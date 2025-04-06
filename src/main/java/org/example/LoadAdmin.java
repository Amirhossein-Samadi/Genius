package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;

public class LoadAdmin
{
    public static List<Admin> adminList = new ArrayList<>();

    public static void loadAdmins() throws SQLException
    {

        String sql = "SELECT * FROM Admin";

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

                Admin admin = new Admin(name, age, email, username, password, role);

                adminList.add(admin);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }


    public static Admin searchAdmins(String username, String password)
    {
        String sql = "SELECT * FROM Admin WHERE username = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");

                if (BCrypt.checkpw(password, storedHashedPassword)) {
                    for (Admin admin : adminList)
                    {
                        if (admin.getUserName().equals(username))
                        {
                            return admin;
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
