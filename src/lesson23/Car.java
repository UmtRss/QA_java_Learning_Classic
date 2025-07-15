package lesson23;

public class Car extends Vehicle {

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " car engine started with a key.");
    }
}
