package Exercises.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _1_UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> users = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            users.add(scanner.nextLine());
        }

        users.forEach(System.out::println);
    }
}
