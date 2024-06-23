package Labs.SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class _9_Largest3Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> sortedList = Arrays.stream(numbers).boxed().sorted((a, b) -> b - a).toList();
        if (sortedList.size() < 4) {
            sortedList.forEach(value -> System.out.printf("%d ", value));
            System.out.println();
        } else {
            System.out.printf("%d %d %d", sortedList.get(0), sortedList.get(1), sortedList.get(2));
        }
    }
}
