package ru.aston.hometasks.dz3.chain;

public class LastFeeder extends FeederHandler {
    @Override
    public void handle(Animal animal) {
        System.out.println("Универсальный кормитель покормил " + animal.getSpecies());
    }
}
