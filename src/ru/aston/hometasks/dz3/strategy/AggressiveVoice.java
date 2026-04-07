package ru.aston.hometasks.dz3.strategy;

public class AggressiveVoice implements SoundStrategy {
    @Override
    public void makeSound() {
        System.out.println("РААААРАРАРАР");
    }

    @Override
    public String getSoundName() {
        return "Рычание";
    }
}
