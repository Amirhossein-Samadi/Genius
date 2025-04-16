package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.DbConnection.connectGenuisDb;

public class LoadSignUpRequests
{
    public static List<SignUpRequest> signUpRequestList  = new ArrayList<>();

    public static void loadSignUpRequests() throws SQLException {

        String sql = "SELECT * FROM SignUp";

        try (
                Statement stmt = connectGenuisDb().createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String artistName = rs.getString("artistName");
                int status = rs.getInt("status");
                String date = rs.getString("date");

                SignUpRequest signUpRequest = new SignUpRequest(artistName, status, date);

                signUpRequestList.add(signUpRequest);
            }
        } catch (Exception e) {
            System.out.println("خطا در خواندن داده‌ها: " + e.getMessage());
        }
    }
}
