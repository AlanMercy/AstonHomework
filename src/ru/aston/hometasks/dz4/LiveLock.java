package ru.aston.hometasks.dz4;

public class LiveLock {
    private static boolean FLAG1 = false;
    private static boolean FLAG2 = false;

    private static final String MSG_WORK1 = "Рабочий 1: выполняю работу...";
    private static final String MSG_YIELD1 = "Рабочий 1: уступаю, жду...";
    private static final String MSG_WORK2 = "Рабочий 2: выполняю работу...";
    private static final String MSG_YIELD2 = "Рабочий 2: уступаю, жду...";

    public static void main(String[] args) {
        Thread worker1 = new Thread(() -> {
            while (true) {
                if (FLAG1 && !FLAG2) {
                    System.out.println(MSG_WORK1);
                    FLAG1 = false;
                    FLAG2 = true;
                } else {
                    System.out.println(MSG_YIELD1);
                    Thread.yield();
                }
            }
        });

        Thread worker2 = new Thread(() -> {
            while (true) {
                if (FLAG2 && !FLAG1) {
                    System.out.println(MSG_WORK2);
                    FLAG2 = false;
                    FLAG1 = true;
                } else {
                    System.out.println(MSG_YIELD2);
                    Thread.yield();
                }
            }
        });

        worker1.start();
        worker2.start();
    }
}
