package lesson21;

    // Üst sınıf (Superclass)
    class Arac {
        String marka = "Toyota";

        void calistir() {
            System.out.println("Araç çalıştırıldı.");
        }
    }

    // Alt sınıf (Subclass) - Arac sınıfından kalıtım alıyor
    class Otomobil extends Arac {
        void parkEt() {
            System.out.println("Otomobil park edildi.");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Otomobil oto = new Otomobil();

            oto.calistir();                // Üst sınıftan miras alınan metod
            oto.parkEt();                  // Alt sınıfa ait metod
            System.out.println(oto.marka); // Üst sınıftan gelen değişken
        }
    }


