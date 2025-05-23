package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.example.DbConnection.connectGenuisDb;

public class UpdateSignUpRequest {

    public static void updateSignUpRequest(String artistName, int status)
    {
        String sql = "UPDATE SignUp SET status = ? WHERE artistName = ?";

        try (Connection conn = connectGenuisDb();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, status);
            pstmt.setString(2, artistName);
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("خطا در بروزرسانی داده: " + e.getMessage());
        }
    }
}
