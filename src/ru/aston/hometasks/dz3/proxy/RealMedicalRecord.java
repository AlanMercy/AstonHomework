package ru.aston.hometasks.dz3.proxy;

public class RealMedicalRecord implements MedicalRecord {
    private final String animalName;
    private final String diagnosis;
    private final String vaccinationHistory;

    public RealMedicalRecord(String animalName, String diagnosis, String vaccinationHistory) {
        this.animalName = animalName;
        this.diagnosis = diagnosis;
        this.vaccinationHistory = vaccinationHistory;
    }

    private void loadFromDatabase() {
        System.out.println("Загрузка данных из базы для " + animalName + "... (тяжёлая операция)");
        System.out.println("Данные загружены.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Медицинская карта " + animalName);
        System.out.println("Диагноз: " + diagnosis);
        System.out.println("Прививки: " + vaccinationHistory);
    }

    @Override
    public String getDiagnosis() {
        return diagnosis;
    }
}
