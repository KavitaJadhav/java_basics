package higherOrderFunctions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class streamFunctions {
    public static void main(String[] args) {
        forEachArray();
        sortArrayAsc();
        sortArrayDesc();
        forEachMap();
        arrayStream();
        arrayReduceSum();
        arrayReduceSub();
        arrayFilterFindAny();
        arrayFilterCount();
        otherStreams();
    }

    private static void otherStreams() {
        String[] values = new String[]{"Milk", "Coffee", "Tea", "Juice"};
        Arrays.stream(values).forEach(val -> System.out.println(val));

        Path path = Paths.get("src/higherOrderFunctions/Sample.txt");
        try {
            Files.lines(path).forEach(line -> System.out.println(line));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void arrayFilterFindAny() {
        List<String> values = Arrays.asList("Milk", "Coffee", "Tea", "Juice");

        String coffee = values.stream()
                .filter(beverage -> beverage.equals("Coffee"))
                .findAny()
                .orElse(null);

        boolean available = (coffee == null) ? false : true;
        System.out.println("coffee available : " + available);
    }

    private static void arrayFilterCount() {
        List<String> values = Arrays.asList("Milk", "Coffee", "Tea", "Juice", "Coffee", "Espresso");

        long coffeeCount = values.stream()
                .filter(beverage -> beverage.equals("Coffee"))
                .count();

        System.out.println("coffee count : " + coffeeCount);
    }

    private static void arrayReduceSub() {
        //Terminal
        List<Integer> values = Arrays.asList(10, 67, 85, 96, 37, 23, 41, 22, 89, 60, 68);

        Integer remaining = values.stream().reduce(1000, (sum, next) -> sum - next);
        System.out.println("Sub of values " + values + " = " + remaining);
    }

    private static void arrayReduceSum() {
        //Terminal
        List<Integer> values = Arrays.asList(10, 67, 85, 96, 37, 23, 41, 22, 89, 60, 68);

        Integer total = values.stream().reduce(0, (sum, next) -> sum + next);
        System.out.println("Sum of values " + values + " = " + total);
    }

    private static void arrayStream() {
        //Stream
        List<Integer> values = Arrays.asList(10, 67, 85, 96, 37, 23, 41, 22, 89, 60, 68);

        values.stream()
                .filter(val -> val > 50)
                .sorted((right, left) -> right.compareTo(left))
                .map(val -> "$" + val)
                .forEach(val -> System.out.println(val));
    }

    private static void forEachMap() {
        //BiConsumer function

        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "One");
        numbers.put(2, "Two");
        numbers.put(3, "Three");
        numbers.put(4, "Four");
        numbers.put(5, "Five");

        numbers.forEach((key, val) -> System.out.println(key + " is read as : " + val));
    }

    private static void forEachArray() {
        //Consumer function

        List<Integer> values = Arrays.asList(10, 67, 85, 23, 41, 22, 89, 60);

        values.forEach(value -> System.out.println(value));
    }

    private static void sortArrayAsc() {
        //Comparator function

        List<Integer> values = Arrays.asList(10, 67, 85, 23, 41, 22, 89, 60);

        values.sort((right, left) -> right.compareTo(left));
        System.out.println(values);
    }

    private static void sortArrayDesc() {
        //Comparator function
        List<Integer> values = Arrays.asList(10, 67, 85, 23, 41, 22, 89, 60);

        values.sort((right, left) -> left.compareTo(right));
        System.out.println(values);
    }
}
