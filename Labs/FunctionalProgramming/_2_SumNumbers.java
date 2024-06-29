package Labs.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _2_SumNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(",\\s+");
        Function<String, Integer> parse = Integer::parseInt;

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + Arrays.stream(numbers).mapToInt(parse::apply).sum());
    }
}
