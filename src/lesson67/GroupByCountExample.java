package lesson67;

import java.sql.*;

public class GroupByCountExample {

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

            // GROUP BY with COUNT
            String sql = "SELECT department, COUNT(*) AS total FROM employees GROUP BY department";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("Employee count by department:");
            while (rs.next()) {
                String department = rs.getString("department");
                int total = rs.getInt("total");
                System.out.println(department + " | " + total);
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
