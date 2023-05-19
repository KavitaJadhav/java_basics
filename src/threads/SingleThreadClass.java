package threads;

import java.util.concurrent.TimeUnit;

public class SingleThreadClass {
    public static void main(String[] args) {
        System.out.println("Started running main method");

        longTask();

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
