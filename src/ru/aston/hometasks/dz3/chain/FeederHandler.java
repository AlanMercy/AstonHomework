package ru.aston.hometasks.dz3.chain;

public abstract class FeederHandler {
    protected FeederHandler next;

    public void setNext(FeederHandler next) {
        this.next = next;
    }

    public abstract void handle(Animal animal);

    protected void passToNext(Animal animal) {
        if (next != null) {
            next.handle(animal);
        } else {
            System.out.println("Никто не смог покормить " + animal.getSpecies());
        }
    }
}
