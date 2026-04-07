package ru.aston.hometasks.dz3.proxy;

public class MedicalRecordProxy implements MedicalRecord {
    private RealMedicalRecord realRecord;
    private final String animalName;
    private final String diagnosis;
    private final String vaccinationHistory;
    private final String userRole;

    public MedicalRecordProxy(String animalName, String diagnosis, String vaccinationHistory, String userRole) {
        this.animalName = animalName;
        this.diagnosis = diagnosis;
        this.vaccinationHistory = vaccinationHistory;
        this.userRole = userRole;
    }

    private boolean checkAccess() {
        return "veterinarian".equalsIgnoreCase(userRole) || "keeper".equalsIgnoreCase(userRole);
    }

    private void logAccess() {
        System.out.println("[Лог] Пользователь с ролью '" + userRole + "' получил доступ к карте " + animalName);
    }

    @Override
    public void displayInfo() {
        if (!checkAccess()) {
            System.out.println("Доступ запрещён! У вас нет прав на просмотр медицинской карты.");
            return;
        }

        if (realRecord == null) {
            realRecord = new RealMedicalRecord(animalName, diagnosis, vaccinationHistory);
        }

        logAccess();
        realRecord.displayInfo();
    }

    @Override
    public String getDiagnosis() {
        if (!checkAccess()) {
            System.out.println("Доступ запрещён! У вас нет прав на получение диагноза.");
            return null;
        }

        if (realRecord == null) {
            realRecord = new RealMedicalRecord(animalName, diagnosis, vaccinationHistory);
        }

        logAccess();
        return realRecord.getDiagnosis();
    }
}
