//ReEntrant lock can be used to avoid race condition.

package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    private static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Started running main method");

        ReentrantLock lock = new ReentrantLock();

        Thread longTask1 = new Thread(() -> longTask(lock));
        Thread longTask2 = new Thread(() -> longTask(lock));

        longTask1.start();
        longTask2.start();

        try {
            longTask1.join();
            longTask2.join();
            System.out.println("Counter : " + counter);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void longTask(ReentrantLock lock) {
        for (int i = 0; i < 10000; i++) {
            lock.lock();
            counter++;
            lock.unlock();
        }
    }
}
