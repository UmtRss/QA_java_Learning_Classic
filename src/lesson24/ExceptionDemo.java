package lesson24;

public class ExceptionDemo {

    public void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Sonuç: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Hata: Sıfıra bölme! " + e.getMessage());
        } finally {
            System.out.println("İşlem tamamlandı (finally bloğu).");
        }
    }

    public void accessArray(int[] arr, int index) {
        try {
            System.out.println("Değer: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dizi sınır dışı hatası: " + e.getMessage());
        }
    }
}
