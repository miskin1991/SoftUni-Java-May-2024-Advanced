package Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1_ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = Stream.of(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pollLast());
        }
        System.out.println();
    }
}
