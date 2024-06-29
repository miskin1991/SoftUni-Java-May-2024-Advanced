package Labs.FunctionalProgramming;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class _6_FindEvensOrOdds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(range[0]);
        int upperBound = Integer.parseInt(range[1]);
        String condition = scanner.nextLine();

        IntPredicate predicate = integer -> condition.equals("even") == (integer % 2 == 0);

        IntStream.range(lowerBound, upperBound + 1)
                .filter(predicate).forEach(e -> System.out.print(e + " "));
    }
}
