package ru.aston.hometasks.dz3.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("Паттерн Билдер - пример работы\n");

        Animal cat = new Animal.Builder("Мурка", "cat").build();
        System.out.println("Кошка (только обязательные):");
        System.out.println(cat);

        Animal dog = new Animal.Builder("Шериф", "dog")
                .age(12)
                .temper("Злой, любит кусаться")
                .favoriteFood("Куриные лапки")
                .gender("М")
                .breed("Лайка")
                .build();
        System.out.println("\nСобака (несколько необязательных):");
        System.out.println(dog);

        try {
            Animal invalid = new Animal.Builder("", "Кошка").build();
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка валидации: " + e.getMessage());
        }
    }
}
