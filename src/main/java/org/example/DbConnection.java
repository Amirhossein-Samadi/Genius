package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection connectGenuisDb() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:\\my data\\AP\\Genuis\\src\\main\\java\\org\\example\\GenuisDB";
            conn = DriverManager.getConnection(url);
            // System.out.println("اتصال به دیتابیس برقرار شد.");
        } catch (SQLException e) {
            System.out.println("خطا در اتصال به دیتابیس: " + e.getMessage());
        }
        return conn;
    }

}
