package ru.aston.hometasks.dz3.decorator;

public class AggressiveAnimalDecorator extends AnimalDecorator {

    public AggressiveAnimalDecorator(Animal decoratedAnimal) {
        super(decoratedAnimal);
    }

    @Override
    public void makeSound() {
        decoratedAnimal.makeSound();
        setAggressiveAnimal(decoratedAnimal);
    }

    private void setAggressiveAnimal(Animal decoratedAnimal) {
        System.out.println("Сообщение от AggressiveAnimalDecorator. Животное агрессивное ");
    }
}
