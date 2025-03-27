package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsersData {

    public static void insertUsersTable(Connection conn, String name, int age, String email, String username, String password, int role) throws SQLException {

        String sql = "INSERT INTO UsersData(name,age,email,username,password,role) VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, email);
        ps.setString(4, username);
        ps.setString(5, password);
        ps.setInt(6, role);

        ps.executeUpdate();
    }
}
