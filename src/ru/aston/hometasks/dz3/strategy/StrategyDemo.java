package ru.aston.hometasks.dz3.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("Паттерн Стратегия - пример работы\n");

        Animal dog = new Animal("Собака");
        Animal cat = new Animal("Кошка");

        System.out.println("\nЖивотные без настроенной стратегии");
        dog.makeSound();
        cat.makeSound();

        System.out.println("\nОбучаем животных звукам");
        dog.setSoundStrategy(new WoofVoice());
        cat.setSoundStrategy(new MeowVoice());

        System.out.println("\nЖивотные с настроенное стратегий");
        dog.makeSound();
        cat.makeSound();

        System.out.println("\nИзменение стратегии животных");
        dog.setSoundStrategy(new AggressiveVoice());
        cat.setSoundStrategy(new WoofVoice());

        System.out.println("\nРезультат изменений");
        dog.makeSound();
        cat.makeSound();
    }
}
