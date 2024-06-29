package Labs.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntConsumer;

public class _1_SortEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).filter(value -> value % 2 == 0).toArray();

        StringBuilder sb = new StringBuilder();
        IntConsumer intConsumer = n -> sb.append(n).append(", ");
        Arrays.stream(numbers).forEach(intConsumer);
        System.out.println(sb.substring(0, sb.length() - 2));
        // clear the StringBuilder for the next print
        sb.setLength(0);
        Arrays.stream(numbers).sorted().forEach(intConsumer);
        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
