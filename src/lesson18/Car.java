package lesson18;

public class Car extends Vehicle {
    int doorCount;

    public void showCarInfo() {
        showInfo(); // Vehicle'ın metodu
        System.out.println("Door Count: " + doorCount);
    }
}
