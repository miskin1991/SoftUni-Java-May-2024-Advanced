package Exercises.SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class _4_CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();
        for (char c : input.toCharArray()) {
            symbols.putIfAbsent(c, 0);
            symbols.replace(c, symbols.get(c) + 1);
        }

        for (var symbol : symbols.entrySet()) {
            System.out.printf("%c: %d time/s%n", symbol.getKey(), symbol.getValue());
        }
    }
}
