package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAccountDB {

    public static void insertAccount(Connection conn, String name, String email, String username, String password, int role) throws SQLException {

        String sql = "INSERT INTO AccountDatas(name,email,username,password,role) VALUES(?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, username);
        ps.setString(4, password);
        ps.setInt(5, role);

        ps.executeUpdate();
    }
}
