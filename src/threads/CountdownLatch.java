// CountDownLatch can be used to join all threads to the main thread
// latch.await() method waits for all threads to join back main thread.
// latch.countDown() method needs to be called to let latch know that the thread is complete.
//Count of CountDownLatch needs to be same as totalThreadCounts

package threads;

import java.util.concurrent.*;

public class CountdownLatch {
    public static void main(String[] args) {
        System.out.println("Started main thread");

        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);
        int processorCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processorCount);

        for (int i = 0; i < threadCount; i++) {
            int threadCounter = i;
            executorService.submit(() -> longTask(threadCounter, latch));
        }

        try {
//            Note: latch.await() method waits for all threads to join back main thread.
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
        System.out.println("Completed main thread");
    }

    private static void longTask(int counter, CountDownLatch latch) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed thread : " + counter);
        latch.countDown();
    }
}
