package lesson61;

import java.sql.*;

public class DBUtils {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "HB140325@";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static String getEmployeeNameById(int id) {
        String employeeName = null;
        String query = "SELECT name FROM employees WHERE id = " + id;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                employeeName = rs.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeName;
    }
}
