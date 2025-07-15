package lesson66;

import java.sql.*;

public class OrderByLimitExample {

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

            // ORDER BY query
            String sqlOrder = "SELECT * FROM employees ORDER BY id ASC";
            ps = conn.prepareStatement(sqlOrder);
            rs = ps.executeQuery();
            System.out.println("Employees ordered by ID (ascending):");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + department);
            }
            rs.close();
            ps.close();

            // ORDER BY with LIMIT query
            String sqlLimit = "SELECT * FROM employees ORDER BY id ASC LIMIT 3";
            ps = conn.prepareStatement(sqlLimit);
            rs = ps.executeQuery();
            System.out.println("\nTop 3 employees by ID:");
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
