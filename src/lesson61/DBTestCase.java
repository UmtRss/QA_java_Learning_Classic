package lesson61;

import java.sql.*;

public class DBTestCase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Veritabanı adı testdb
        String username = "root"; // Sen kurarken ne belirlediysen
        String password = "HB140325@"; // Senin kendi şifreni yaz

        try {
            // Bağlantı oluştur
            Connection conn = DriverManager.getConnection(url, username, password);

            // SQL çalıştır
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM employees WHERE id = 1");

            // Sonucu kontrol et
            if (rs.next()) {
                String name = rs.getString("name");
                if ("Ali".equals(name)) {
                    System.out.println("✅ Test Passed: " + name);
                } else {
                    System.out.println("❌ Test Failed: Expected 'Ali' but found '" + name + "'");
                }
            } else {
                System.out.println("❌ Test Failed: No result found");
            }

            // Kapat
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
