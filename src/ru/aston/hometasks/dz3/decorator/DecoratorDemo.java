package ru.aston.hometasks.dz3.decorator;

public class DecoratorDemo {
    public static void main() {
        Animal cat = new Cat();
        Animal aggressiveCat = new AggressiveAnimalDecorator(new Cat());
        Animal aggressiveDog = new AggressiveAnimalDecorator(new Dog());

        System.out.println("\nОбычный кот");
        cat.makeSound();

        System.out.println("\nЗлой кот");
        aggressiveCat.makeSound();

        System.out.println("\nЗлой пёс");
        aggressiveDog.makeSound();

    }
}
