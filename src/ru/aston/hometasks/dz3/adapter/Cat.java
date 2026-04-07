package ru.aston.hometasks.dz3.adapter;

public class Cat implements Animal {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: Мяяяяуу");
    }

    @Override
    public String getName() {
        return name;
    }
}
