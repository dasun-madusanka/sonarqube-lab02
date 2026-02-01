package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    // VULNERABILITY: SQL Injection
    public void findUser(String username) throws Exception {

        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeQuery();
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        System.out.println("I am never called");
    }

    public void deleteUser(String username) throws SQLException {

    String query = "DELETE FROM users WHERE name = ?";

    try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/db", "root", password);
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, username);
        ps.executeUpdate();
    }
}

}
