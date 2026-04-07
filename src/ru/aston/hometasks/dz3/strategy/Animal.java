package ru.aston.hometasks.dz3.strategy;

public class Animal {
    private final String special;
    private SoundStrategy soundStrategy;

    public Animal(String name) {
        this.special = name;
        this.soundStrategy = new MuteVoice();
    }

    public String getSpecial() {
        return special;
    }

    public void makeSound() {
        System.out.print(special + " говорит: ");
        soundStrategy.makeSound();
    }

    public SoundStrategy getSoundStrategy() {
        return soundStrategy;
    }

    public void setSoundStrategy(SoundStrategy soundStrategy) {
        this.soundStrategy = soundStrategy;
        System.out.println(special + " теперь умеет " + soundStrategy.getSoundName());
    }
}
