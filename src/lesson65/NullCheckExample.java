package lesson65;

import java.sql.*;

public class NullCheckExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "1234";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully.");

            // IS NULL query
            String sql = "SELECT * FROM employees WHERE department IS NULL";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("Employees with NULL department:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + department);
            }
            rs.close();
            ps.close();

            // IS NOT NULL query
            String sqlNotNull = "SELECT * FROM employees WHERE department IS NOT NULL";
            ps = conn.prepareStatement(sqlNotNull);
            rs = ps.executeQuery();
            System.out.println("\nEmployees with NON-NULL department:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + department);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                System.out.println("Connection close error: " + e.getMessage());
            }
        }
    }
}
