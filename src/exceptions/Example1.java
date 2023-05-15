// Example of Compile exception

package exceptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example1 {
    private static void readFile(String name) {
        System.out.println("Reading file: " + name);
        try {
            FileInputStream fis = new FileInputStream(name);
            Scanner scanner = new Scanner(fis);
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Process completed for file: " + name);
        }
    }

    public static void main(String[] args) {
        readFile("src/exceptions/Sample.txt");
        readFile("noFile.txt");
    }


}
