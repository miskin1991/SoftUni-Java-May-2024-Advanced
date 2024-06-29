package Labs.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class _4_AddVAT {

    public static void main(String[] args) {
        DoubleUnaryOperator addVAT = value -> value * 1.2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble).map(addVAT).forEach(price -> System.out.printf("%.2f%n", price));
    }
}
