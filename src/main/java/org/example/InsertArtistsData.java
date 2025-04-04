package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class InsertArtistsData {

    public static void insertArtistsTable(Connection conn, String name, int age, String email, String username, String password, int role) throws SQLException {

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        String sql = "INSERT INTO ArtistsData(name,age,email,username,password,role) VALUES(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, email);
        ps.setString(4, username);
        ps.setString(5, hashedPassword);
        ps.setInt(6, role);

        ps.executeUpdate();
    }
}
