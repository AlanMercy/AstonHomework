package ru.aston.hometasks.dz3.chain;

public class DogFeeder extends FeederHandler {
    @Override
    public void handle(Animal animal) {
        if ("dog".equalsIgnoreCase(animal.getSpecies())) {
            System.out.println("Кормитель собак покормил " + animal.getSpecies());
        } else {
            System.out.println("Кормитель собак не может покормить " + animal.getSpecies());
            passToNext(animal);
        }
    }
}
