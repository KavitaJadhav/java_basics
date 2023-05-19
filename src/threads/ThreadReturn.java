//Have to use global variable as thread does not return value
//if value is return inside thread function then its ignore as run method return type is void
//Hence values need to be stored in global variables and updated from run method

//Callable and FutureTask will help in achieving return values
package threads;

import java.util.concurrent.TimeUnit;

public class ThreadReturn {
    private static boolean threadComplete = false;

    public static void main(String[] args) {
        System.out.println("Started running main method");

        Runnable runnableInline = new Runnable() {
            @Override
            public void run() {
                threadComplete = longTask();
            }
        };

        Thread longTaskInline = new Thread(runnableInline);
        longTaskInline.start();


        try {
            System.out.println("Before Join - Thread Complete? : " + threadComplete);
            longTaskInline.join();
            System.out.println("After Join - Thread Complete? : " + threadComplete);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Completed main task");
    }

    private static boolean longTask() {
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
