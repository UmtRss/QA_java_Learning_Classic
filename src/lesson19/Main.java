package lesson19;

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Car c = new Car();
        ElectricCar e = new ElectricCar();

        v.startEngine();
        c.startEngine();
        e.startEngine();
    }
}
