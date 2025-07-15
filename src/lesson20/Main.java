package lesson20;

public class Main {
    public static void main (String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // polymorphism
        Animal myCat = new Cat(); // polymorphism


        myAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
    }
}
