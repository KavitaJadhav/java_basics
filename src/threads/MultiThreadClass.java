package threads;

import java.util.concurrent.TimeUnit;


public class MultiThreadClass {
    static class LongTask implements Runnable {
        @Override
        public void run() {
            longTask();
        }
    }

    public static void main(String[] args) {
        System.out.println("Started running main method");

        LongTask runnable = new LongTask();
        Thread longTask = new Thread(runnable);
        longTask.start();

        Runnable runnableInline = new Runnable() {
            @Override
            public void run() {
                longTask();
            }
        };

        Thread longTaskInline = new Thread(runnableInline);
        longTaskInline.start();

        Thread longTaskLambda = new Thread(() -> longTask());
        longTaskLambda.start();

        System.out.println("Completed main task");
    }

    private static void longTask() {
        System.out.println("Started long task");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed long task");

    }
}
