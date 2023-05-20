//Thread creation takes time
//Use thread pool to use existing alive thread
//Ideally for compute intensive task thread pool size should be same as cpu core count
package threads;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        System.out.println("Started running main method");

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService= Executors.newFixedThreadPool(availableProcessors);

        executorService.submit(new FutureTask((Callable<Boolean>) () -> longTask(1)));
        executorService.submit(new FutureTask((Callable<Boolean>) () -> longTask(2)));
        executorService.submit(new FutureTask((Callable<Boolean>) () -> longTask(3)));
        executorService.submit(new FutureTask((Callable<Boolean>) () -> longTask(4)));
        executorService.submit(new FutureTask((Callable<Boolean>) () -> longTask(5)));

        executorService.shutdown();

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
