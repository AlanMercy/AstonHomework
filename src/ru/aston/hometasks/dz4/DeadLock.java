package ru.aston.hometasks.dz4;

public class DeadLock {
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    private static final long SLEEP = 100L;

    private static final String MSG_HOLDING1 = "Поток 1: удерживаю LOCK1...";
    private static final String MSG_WAITING2 = "Поток 1: ожидаю LOCK2...";
    private static final String MSG_ACQUIRED2 = "Поток 1: захватил LOCK2";
    private static final String MSG_HOLDING2 = "Поток 2: удерживаю LOCK2...";
    private static final String MSG_WAITING1 = "Поток 2: ожидаю LOCK1...";
    private static final String MSG_ACQUIRED1 = "Поток 2: захватил LOCK1";

    public static void main(String[] args) {
        Thread t1 = new Thread( () ->  {
            synchronized (LOCK1) {
                System.out.println(MSG_HOLDING1);

                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(MSG_WAITING2);

                synchronized (LOCK2) {
                    System.out.println(MSG_ACQUIRED2);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println(MSG_HOLDING2);

                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(MSG_WAITING1);

                synchronized (LOCK1) {
                    System.out.println(MSG_ACQUIRED1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
