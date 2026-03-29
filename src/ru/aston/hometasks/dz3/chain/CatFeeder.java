package ru.aston.hometasks.dz3.chain;

public class CatFeeder extends FeederHandler {
    @Override
    public void handle(Animal animal) {
        if ("cat".equalsIgnoreCase(animal.getSpecies())) {
            System.out.println("Кормитель кошек покормил " + animal.getSpecies());
        } else {
            System.out.println("Кормитель кошек не может покормить " + animal.getSpecies());
            passToNext(animal);
        }
    }
}
