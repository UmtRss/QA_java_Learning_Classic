package lesson62;

import java.sql.*;

public class DBModificationTest {
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "1234";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // INSERT
            String insertSQL = "INSERT INTO employees (id, name) VALUES (2, 'Zeynep')";
            int rowsInserted = stmt.executeUpdate(insertSQL);
            System.out.println("Inserted rows: " + rowsInserted);

            // UPDATE
            String updateSQL = "UPDATE employees SET name = 'Zeynep Acar' WHERE id = 2";
            int rowsUpdated = stmt.executeUpdate(updateSQL);
            System.out.println("Updated rows: " + rowsUpdated);

            // DELETE
            String deleteSQL = "DELETE FROM employees WHERE id = 2";
            int rowsDeleted = stmt.executeUpdate(deleteSQL);
            System.out.println("Deleted rows: " + rowsDeleted);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
