package ru.aston.hometasks.dz3.decorator;

public abstract class AnimalDecorator implements Animal {
    protected Animal decoratedAnimal;

    public AnimalDecorator(Animal decoratedAnimal) {
        this.decoratedAnimal = decoratedAnimal;
    }

    public void makeSound() {
        decoratedAnimal.makeSound();
    }
}
