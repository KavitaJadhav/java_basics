//Race condition is when critical code is accessed by multiple applications at the same time
//To avoid race condition, critical code needs to be executed sequentially

package threads;

public class RaceCondition {
    private static int counter = 0;

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

    }

    private static void longTask() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
}
