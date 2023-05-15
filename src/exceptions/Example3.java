// Example of Runtime exception
package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter first number : ");
            num1 = scanner.nextInt();
            System.out.println("Enter second number : ");
            num2 = scanner.nextInt();
            System.out.println("division= " + (num1 / num2));
        } catch (InputMismatchException exception) {
            System.out.println("Enter valid number: ");
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
