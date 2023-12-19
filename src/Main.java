
interface Run {
    void run();
}

interface Speak {
    void speak();
}


class Animal {

}


class Dog extends Animal implements Run, Speak {
    @Override
    public void run() {
        System.out.println("Dog is running.");
    }

    @Override
    public void speak() {
        System.out.println("Dog is barking.");
    }
}


class Cat extends Animal implements Run, Speak {
    @Override
    public void run() {
        System.out.println("Cat is running.");
    }

    @Override
    public void speak() {
        System.out.println("Cat is meowing.");
    }
}


class Shark extends Animal {

}

class HomeAnimal<T extends Animal & Run & Speak> {
    private T animal;

    public HomeAnimal(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void showAnimalType() {
        System.out.println("Animal type: " + animal.getClass().getSimpleName());
    }

    public void sleepOnTheCouch() {
        System.out.println(animal.getClass().getSimpleName() + " is sleeping on the couch.");
    }
}


public class Main {
    public static void main(String[] args) {

        HomeAnimal<Dog> homeDog = new HomeAnimal<>(new Dog());
        homeDog.getAnimal().run();
        homeDog.getAnimal().speak();
        homeDog.showAnimalType();
        homeDog.sleepOnTheCouch();

        HomeAnimal<Cat> homeCat = new HomeAnimal<>(new Cat());
        homeCat.getAnimal().run();
        homeCat.getAnimal().speak();
        homeCat.showAnimalType();
        homeCat.sleepOnTheCouch();

        // Attempting to create Shark object (error)
        // HomeAnimal<Shark> homeShark = new HomeAnimal<>(new Shark());
    }
}
