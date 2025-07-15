package lesson22;



    class Arac {
        // Üst sınıftaki metot
        void calistir() {
            System.out.println("Araç çalıştırıldı.");
        }
    }

    class Otomobil extends Arac {
        // Bu metot override edildi, yani üst sınıftaki halinin üzerine yazıldı
        @Override
        void calistir() {
            System.out.println("Otomobil çalıştırıldı.");
        }
    }

    public class Overriding {
        public static void main(String[] args) {
            Arac a = new Arac();
            a.calistir();  // Çıktı: Araç çalıştırıldı.

            Otomobil o = new Otomobil();
            o.calistir();  // Çıktı: Otomobil çalıştırıldı.

            Arac b = new Otomobil();
            b.calistir();  // Çıktı: Otomobil çalıştırıldı. (Runtime polymorphism)
        }
    }

