import java.math.BigDecimal;

public class Decimal {
    public static void main(String[] args) {
        double num1 = 0.1;
        double num2 = 0.2;
        System.out.println("double sum: " + (num1 + num2));

        BigDecimal bNum1 = new BigDecimal("0.1");
        BigDecimal bNum2 = new BigDecimal("0.2");

        System.out.println("double sum: " + bNum1.add(bNum2));

    }
}
