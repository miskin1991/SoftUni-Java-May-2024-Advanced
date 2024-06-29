package Labs.FunctionalProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _3_CountUppercaseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");

        ArrayDeque<String> uppercaseWords = new ArrayDeque<>();
        Predicate<String> predicate = str -> Character.isUpperCase(str.charAt(0));

        Arrays.stream(line).filter(predicate).forEach(uppercaseWords::offer);
        Consumer<String> consumer = System.out::println;
        System.out.println(uppercaseWords.size());
        while (!uppercaseWords.isEmpty()) {
            consumer.accept(uppercaseWords.poll());
        }

    }
}
