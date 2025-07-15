package lesson23;

public class Truck extends Vehicle {

    public Truck(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " truck engine started with a switch.");
    }
}
