package ru.aston.hometasks.dz3.adapter;

public class WildAnimalAdapter implements Animal{
    private WildAnimal wildAnimal;

    public WildAnimalAdapter(WildAnimal wildAnimal){
        this.wildAnimal = wildAnimal;
    }

    @Override
    public void makeSound() {
        wildAnimal.roar();
    }

    @Override
    public String getName() {
        return wildAnimal.getSpecies();
    }
}
