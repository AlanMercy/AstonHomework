package ru.aston.hometasks.dz3.decorator;

public class LazyAnimalDecorator extends AnimalDecorator {

    public LazyAnimalDecorator(Animal decoratedAnimal) {
        super(decoratedAnimal);
    }

    @Override
    public void makeSound() {
        decoratedAnimal.makeSound();
        setLazyAnimalDecorator(decoratedAnimal);
    }

    private void setLazyAnimalDecorator(Animal decoratedAnimal) {
        System.out.println("Сообщение от LazyAnimeDecorator. Животное ленивое");
    }
}
