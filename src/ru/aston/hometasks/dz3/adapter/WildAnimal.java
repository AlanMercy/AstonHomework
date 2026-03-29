package ru.aston.hometasks.dz3.adapter;

public class WildAnimal {  // Класс который нельзя изменить
    private final String species;

    public WildAnimal(String species) {
        this.species = species;
    }

    public void roar() {
        System.out.println(species + " рычит: Р-Р-Р-Р!!!");
    }

    public String getSpecies() {
        return species;
    }
}
