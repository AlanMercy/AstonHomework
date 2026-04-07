package ru.aston.hometasks.dz3.strategy;

public class MeowVoice implements SoundStrategy {
    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }

    @Override
    public String getSoundName() {
        return "Мяуканье";
    }
}
