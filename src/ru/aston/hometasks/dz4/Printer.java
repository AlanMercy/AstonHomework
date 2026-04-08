package ru.aston.hometasks.dz4;

public class Printer {

    private static final Object MONITOR = new Object();
    private static boolean turn = true;

    private static final String OUTPUT_1 = "1 ";
    private static final String OUTPUT_2 = "2 ";
    private static final boolean TURN_FOR_THREAD1 = true;
    private static final boolean TURN_FOR_THREAD2 = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    while (turn != TURN_FOR_THREAD1) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(OUTPUT_1);
                    turn = TURN_FOR_THREAD2;
                    MONITOR.notify();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    while (turn != TURN_FOR_THREAD2) {
                        try {
                            MONITOR.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.print(OUTPUT_2);
                    turn = TURN_FOR_THREAD1;
                    MONITOR.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
