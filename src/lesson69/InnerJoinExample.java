package lesson69;

import java.sql.*;

public class InnerJoinExample {

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

            // INNER JOIN query
            String sql = "SELECT e.name, d.department_name " +
                    "FROM employees e " +
                    "INNER JOIN departments d ON e.department_id = d.id";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("Employee name | Department name:");
            while (rs.next()) {
                String name = rs.getString("name");
                String department = rs.getString("department_name");
                System.out.println(name + " | " + department);
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
