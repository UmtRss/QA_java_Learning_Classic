package lesson24;

public class LoginValidator {

    public void login(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Kullanıcı adı veya şifre null olamaz.");
        }
        System.out.println("Giriş başarılı: " + username);
    }
}
