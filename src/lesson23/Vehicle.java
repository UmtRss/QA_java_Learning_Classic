package lesson23;

public abstract class Vehicle {

    public String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void startEngine();

    public void stopEngine() {
        System.out.println(brand + " engine stopped.");
    }
}
