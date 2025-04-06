package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSignUpRequests
{
    public static void insertSignUpRequests(Connection conn, String artistName, int status, String date) throws SQLException {

        String sql = "INSERT INTO SignUp(artistName,status,date) VALUES(?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, artistName);
        ps.setInt(2, status);
        ps.setString(3, date);

        ps.executeUpdate();
    }
}
