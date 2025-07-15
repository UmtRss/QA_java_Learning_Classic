package lesson23;

public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car("BMW");
        Vehicle motorcycle = new Motorcycle("Yamaha");
        Vehicle truck = new Truck("Volvo");

        car.startEngine();
        car.stopEngine();

        motorcycle.startEngine();
        motorcycle.stopEngine();

        truck.startEngine();
        truck.stopEngine();
    }
}
