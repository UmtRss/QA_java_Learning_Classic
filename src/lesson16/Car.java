package lesson16;

public class Car {
    String brand;
    int modelYear;

    // Constructor
    public Car(String brand, int modelYear) {
        this.brand = brand;
        this.modelYear = modelYear;
    }

    public void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
    }
}
