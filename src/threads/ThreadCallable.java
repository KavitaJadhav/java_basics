//Callable implements Run method to store return type
//Thread does not support return value, hence FutureTask object can be passed to thread to store return value
//Return value can be accessed using get() method of Future task

package threads;

import java.util.concurrent.*;

public class ThreadCallable {
    public static void main(String[] args) {
        System.out.println("Started running main method");
        boolean threadComplete = false;

        Callable<Boolean> callable = () -> longTask();
        FutureTask<Boolean> futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);

        thread.start();

        try {
            System.out.println("Before Join - Thread Complete? : " + threadComplete);

            thread.join();

            threadComplete = futureTask.get();
            System.out.println("After Join - Thread Complete? : " + threadComplete);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed main task");
    }

    private static Boolean longTask() {
        System.out.println("Started long task");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed long task");
        return true;
    }
}
