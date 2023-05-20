package threads;

import java.util.concurrent.TimeUnit;

public class ManualThreadJoin {
    public static void main(String[] args) {
        System.out.println("Started main thread");
        Thread thread1 = new Thread(() -> longTask(1));
        Thread thread2 = new Thread(() -> longTask(2));
        Thread thread3 = new Thread(() -> longTask(3));
        Thread thread4 = new Thread(() -> longTask(4));
        Thread thread5 = new Thread(() -> longTask(5));
        Thread thread6 = new Thread(() -> longTask(6));
        Thread thread7 = new Thread(() -> longTask(7));
        Thread thread8 = new Thread(() -> longTask(8));
        Thread thread9 = new Thread(() -> longTask(9));
        Thread thread10 = new Thread(() -> longTask(10));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        try {
//            Note: To avoid manually joining threads CountDownLatch can be used. latch.await().

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            thread9.join();
            thread10.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed main thread");
    }

    private static void longTask(int counter) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed thread : " + counter);
    }
}
