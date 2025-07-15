package lesson17;

public class Car {
    private String brand;
    private int modelYear;

    // Constructor
    public Car(String brand, int modelYear) {
        this.brand = brand;
        this.modelYear = modelYear;

    }

    // Getter - brand
    public String getBrand() {
        return brand;
    }

    // Setter - brand
    public void setBrand(String brand) {
        this.brand = brand;

    }

    // Getter -modelYear
    public int getModelYear() {
        return modelYear;

    }

    // Setter -modelYear
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;

    }
    public void showInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
    }
}
