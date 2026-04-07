package ru.aston.hometasks.dz3.adapter;

public class Dog implements Animal {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " гавкает: Гааав");
    }

    @Override
    public String getName() {
        return name;
    }
}
