package ru.aston.hometasks.dz4;

import java.util.concurrent.atomic.AtomicBoolean;

public class LiveLock {
    private static final AtomicBoolean FLAG1 = new AtomicBoolean(false);
    private static final AtomicBoolean FLAG2 = new AtomicBoolean(false);

    private static final String MSG_WORK1 = "Рабочий 1: выполняю работу...";
    private static final String MSG_YIELD1 = "Рабочий 1: уступаю, жду...";
    private static final String MSG_WORK2 = "Рабочий 2: выполняю работу...";
    private static final String MSG_YIELD2 = "Рабочий 2: уступаю, жду...";

    public static void main(String[] args) {
        Thread worker1 = new Thread(() -> {
            while (true) {
                if (FLAG1.get() && !FLAG2.get()) {
                    System.out.println(MSG_WORK1);
                    FLAG1.set(false);
                    FLAG2.set(true);
                } else {
                    System.out.println(MSG_YIELD1);
                    Thread.yield();
                }
            }
        });

        Thread worker2 = new Thread(() -> {
            while (true) {
                if (FLAG2.get() && !FLAG1.get()) {
                    System.out.println(MSG_WORK2);
                    FLAG2.set(false);
                    FLAG1.set(true);
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
