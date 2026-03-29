package ru.aston.hometasks.dz3.chain;

public class ChainDemo {
    public static void main(String[] args) {
        FeederHandler catFeeder = new CatFeeder();
        FeederHandler dogFeeder = new DogFeeder();
        FeederHandler generalFeeder = new LastFeeder();

        catFeeder.setNext(dogFeeder);
        dogFeeder.setNext(generalFeeder);

        Animal murka = new Animal("cat");
        Animal sharik = new Animal("dog");
        Animal lion = new Animal("lion");

        System.out.println("Кормим кошку");
        catFeeder.handle(murka);

        System.out.println("\nКормим собаку");
        catFeeder.handle(sharik);

        System.out.println("\nКормим льва");
        catFeeder.handle(lion);
    }
}