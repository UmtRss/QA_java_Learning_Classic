package lesson63;

import java.sql.*;

public class PreparedStatementExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company_db"; // kendi DB'ne göre güncelle
        String username = "root";
        String password = "1234";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1. Veritabanına bağlan
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Veritabanına bağlantı başarılı!");

            // 2. SQL Injection'a karşı güvenli sorgu hazırla
            String sql = "SELECT * FROM employees WHERE department = ?";
            ps = conn.prepareStatement(sql);

            // 3. Dinamik değer yerleştir
            String departmentName = "IT"; // burası kullanıcıdan da alınabilir
            ps.setString(1, departmentName);

            // 4. Sorguyu çalıştır
            rs = ps.executeQuery();

            // 5. Sonuçları yazdır
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");

                System.out.println(id + " | " + name + " | " + department);
            }

        } catch (SQLException e) {
            System.out.println("❌ Hata oluştu: " + e.getMessage());
        } finally {
            // 6. Kaynakları kapat
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
                System.out.println("🔒 Kaynaklar kapatıldı.");
            } catch (SQLException e) {
                System.out.println("❌ Kapatma hatası: " + e.getMessage());
            }
        }
    }
}
