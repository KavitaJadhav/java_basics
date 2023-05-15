// Example of Compile exception

package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example2 {
    private static void readFile(String name) throws FileNotFoundException {
        System.out.println("Reading file: " + name);
        FileInputStream fis = new FileInputStream(name);
        Scanner scanner = new Scanner(fis);
        System.out.println(scanner.nextLine());


    }

    public static void main(String[] args) {
        try {
            readFile("src/exceptions/Sample.txt");
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Process completed for file: src/exceptions/Sample.txt");
        }

        try {
            readFile("noFile.txt");
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Process completed for file: noFile.txt");
        }
    }


}
