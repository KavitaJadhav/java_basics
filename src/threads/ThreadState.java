package threads;

import java.util.concurrent.TimeUnit;


public class ThreadState {


    public static void main(String[] args) {
        System.out.println("Started running main method");

        Runnable runnableInline = new Runnable() {
            @Override
            public void run() {
                longTask();
            }
        };

        Thread longTaskInline = new Thread(runnableInline);
        System.out.println("Thread State runnableInline : " + longTaskInline.getState());
        longTaskInline.start();
        System.out.println("Thread State runnableInline : " + longTaskInline.getState());


        System.out.println("Waiting for long task to complete");
        try {
            longTaskInline.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
