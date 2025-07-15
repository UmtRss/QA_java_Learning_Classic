package lesson64;

import java.sql.*;

public class SqlOperatorsExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "HB140325@";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully.");

            // 1. LIKE operator
            String sqlLike = "SELECT * FROM employees WHERE name LIKE ?";
            ps = conn.prepareStatement(sqlLike);
            ps.setString(1, "%ah%");
            rs = ps.executeQuery();
            System.out.println("Results for LIKE '%ah%':");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + department);
            }
            rs.close();
            ps.close();

            // 2. BETWEEN operator
            String sqlBetween = "SELECT * FROM employees WHERE id BETWEEN ? AND ?";
            ps = conn.prepareStatement(sqlBetween);
            ps.setInt(1, 2);
            ps.setInt(2, 4);
            rs = ps.executeQuery();
            System.out.println("\nResults for id BETWEEN 2 AND 4:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + department);
            }
            rs.close();
            ps.close();

            // 3. IN operator
            String sqlIn = "SELECT * FROM employees WHERE department IN (?, ?)";
            ps = conn.prepareStatement(sqlIn);
            ps.setString(1, "IT");
            ps.setString(2, "HR");
            rs = ps.executeQuery();
            System.out.println("\nResults for department IN ('IT', 'HR'):");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                System.out.println(id + " | " + name + " | " + department);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                System.out.println("Connection close error: " + e.getMessage());
            }
        }
    }
}
