package ru.aston.hometasks.dz3.strategy;

public class MuteVoice implements SoundStrategy {

    @Override
    public void makeSound() {
        System.out.println("....");
    }

    @Override
    public String getSoundName() {
        return "Молчание";
    }
}
