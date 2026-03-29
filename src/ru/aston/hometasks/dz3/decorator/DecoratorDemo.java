package ru.aston.hometasks.dz3.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal aggressiveCat = new AggressiveAnimalDecorator(new Cat());
        Animal lazyAggressiveDog = new AggressiveAnimalDecorator(new LazyAnimalDecorator(new Dog()));

        System.out.println("\nОбычный кот");
        cat.makeSound();

        System.out.println("\nЗлой кот");
        aggressiveCat.makeSound();

        System.out.println("\nЗлой и ленивый пёс");
        lazyAggressiveDog.makeSound();
    }
}
