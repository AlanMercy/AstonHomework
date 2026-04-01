package ru.aston.hometasks.dz3.chain;

public class ChainDemo {
    public static void main(String[] args) {
        System.out.println("Паттерн Цепочка обязанностей - пример работы\n");
        FeederHandler catFeeder = new CatFeeder();
        FeederHandler dogFeeder = new DogFeeder();
        FeederHandler generalFeeder = new LastFeeder();

        catFeeder.setNext(dogFeeder);
        dogFeeder.setNext(generalFeeder);

        Animal murka = new Animal(Species.CAT);
        Animal sherif = new Animal(Species.DOG);
        Animal lion = new Animal(Species.LION);

        System.out.println("Кормим кошку");
        catFeeder.handle(murka);

        System.out.println("\nКормим собаку");
        catFeeder.handle(sherif);

        System.out.println("\nКормим льва");
        catFeeder.handle(lion);
    }
}