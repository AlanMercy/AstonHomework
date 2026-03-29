package ru.aston.hometasks.dz3.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("Паттерн Адаптер - пример работы\n");

        Animal cat = new Cat("Мурка");
        Animal dog = new Dog("Шериф");

        WildAnimal lion = new WildAnimal("Лев");

        Animal adaptedLion = new WildAnimalAdapter(lion);

        System.out.println("Животные в зоопарке");
        makeAnimalSound(cat);
        makeAnimalSound(dog);
        makeAnimalSound(adaptedLion);

        System.out.println("\nДополнительно: список имён");
        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(adaptedLion.getName());
    }

    private static void makeAnimalSound(Animal animal) {
        System.out.print("Слышен звук: ");
        animal.makeSound();
    }
}
