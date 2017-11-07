package GenericsTest;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    public static void main(String[] args) {
        new Animals().go();
    }

    private void go() {
        Animal[] animals = {new Dog(), new Cat()};
        Dog[] dogs = {new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Dog());
        animalList.add(new Cat());
        takeAnimals(animalList);
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());
        takeAnimals(dogList);
        takeAnimals(animalList, dogList);
    }

    private void takeAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    //the same declaration
    //private <T extends Animal> void takeAnimals(List<T> animals) {
    private void takeAnimals(List<? extends Animal> animals) {
        animals.forEach(Animal::eat);
    }

    //the same declaration
    //private void takeAnimals(List<? extends Animal> animals1, List<? extends Animal> animals2) {
    //the same declaration, but accept parameters with equal type
    //private <T extends Animal> void takeAnimals(List<T> animals1, List<T> animals2) {
    private <T extends Animal, A extends Animal> void takeAnimals(List<T> animals1, List<A> animals2) {
        animals1.forEach(Animal::eat);
        animals2.forEach(Animal::eat);
    }
}

abstract class Animal {
    void eat() {
        System.out.println("animal eating");
    }
}

class Dog extends Animal {
}

class Cat extends Animal {
}
