package ru.aston.hometasks.dz3.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("Паттерн Прокси - пример работы\n");

        String name = "Симба";
        String diag = "Перелом лапы";
        String vaccines = "Бешенство (2023), Лейкоз (2024)";

        MedicalRecord proxyForVisitor = new MedicalRecordProxy(name, diag, vaccines, "visitor");
        MedicalRecord proxyForKeeper = new MedicalRecordProxy(name, diag, vaccines, "keeper");
        MedicalRecord proxyForVet = new MedicalRecordProxy(name, diag, vaccines, "veterinarian");

        System.out.println("Попытка доступа: Посетитель");
        proxyForVisitor.displayInfo();

        System.out.println("\nПопытка доступа: Смотритель");
        proxyForKeeper.displayInfo();

        System.out.println("\nПопытка доступа: Ветеринар");
        proxyForVet.displayInfo();

        System.out.println("\nПовторный доступ ветеринара (без повторной загрузки)");
        proxyForVet.displayInfo();
    }
}
