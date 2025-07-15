package lesson23;

public class Motorcycle extends Vehicle {

    public Motorcycle(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " motorcycle engine started with a button.");
    }
}
