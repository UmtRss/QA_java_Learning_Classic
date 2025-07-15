package lesson17;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 2020);
        car1.showInfo();

        // Change value with Setter
        car1.setBrand("Honda");
        car1.setModelYear(2022);
        System.out.println("Updated Brand: " + car1.getBrand());
        System.out.println("Updated Model Year: " + car1.getModelYear());


        // Read value with Getter
        System.out.println("Updated Brand: " + car1.getBrand());
        System.out.println("Updated Model Year: " + car1.getModelYear());

        car1.showInfo();
    }
}

