package lesson24;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("---- Bölme Testi ----");
        ExceptionDemo ed = new ExceptionDemo();
        ed.divide(10, 0);

        System.out.println("\n---- Dizi Erişim Testi ----");
        int[] arr = {1, 2, 3};
        ed.accessArray(arr, 5);

        System.out.println("\n---- Login Testi ----");
        LoginValidator lv = new LoginValidator();
        try {
            lv.login(null, "1234");
        } catch (IllegalArgumentException e) {
            System.out.println("Login hatası: " + e.getMessage());
        }

        System.out.println("\n---- Dosya Okuma Testi ----");
        FileReaderExample fe = new FileReaderExample();
        try {
            fe.readFile("sample.txt"); // Proje içinde bir dosya olmalı
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }

        System.out.println("\n---- Program Bitti ----");
    }
}
