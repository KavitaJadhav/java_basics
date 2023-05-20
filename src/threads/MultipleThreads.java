
package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MultipleThreads {
    public static void main(String[] args) {
        System.out.println("Started running main method");

        FutureTask<Boolean> futureTask1 = new FutureTask((Callable<Boolean>) () -> longTask(1));
        Thread thread1 = new Thread(futureTask1);

        FutureTask<Boolean> futureTask2 = new FutureTask((Callable<Boolean>) () -> longTask(2));
        Thread thread2 = new Thread(futureTask2);

        FutureTask<Boolean> futureTask3 = new FutureTask((Callable<Boolean>) () -> longTask(3));
        Thread thread3 = new Thread(futureTask3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed main task");
    }

    private static Boolean longTask(int id) {
        System.out.println("Started long task");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed long task : " + id);
        return true;
    }
}
