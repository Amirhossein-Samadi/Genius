package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.DbConnection.connectGenuisDb;
import static org.example.InsertArtistsData.insertArtistsTable;

public class InsertAdmin
{
    public static void insertAdmin(Connection conn, String name, int age, String email, String username, String password, int role) throws SQLException {

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        String sql = "INSERT INTO Admin(name,age,email,username,password,role) VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, email);
        ps.setString(4, username);
        ps.setString(5, hashedPassword);
        ps.setInt(6, role);

        ps.executeUpdate();
    }

    public static void main(String[] args) {
        try {
            insertAdmin(connectGenuisDb(), "admin", 20, "admin@gmail.com", "Admin", "1234", 3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
