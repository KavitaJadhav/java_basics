//Atomic data types can be used to lock critical code

package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicLock {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("Started running main method");

        Thread longTask1 = new Thread(() -> longTask());
        Thread longTask2 = new Thread(() -> longTask());

        longTask1.start();
        longTask2.start();

        try {
            longTask1.join();
            longTask2.join();
            System.out.println("Counter : " + counter);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed running main method");
    }

    private static void longTask() {
        for (int i = 0; i < 10000; i++) {
            counter.addAndGet(1);
        }
    }
}
