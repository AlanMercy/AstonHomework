package ru.aston.hometasks.dz3.strategy;

public class WoofVoice implements SoundStrategy {
    @Override
    public void makeSound() {
        System.out.println("Гав");
    }

    @Override
    public String getSoundName() {
        return "Гавканье";
    }
}
