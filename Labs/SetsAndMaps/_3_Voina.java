package Labs.SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _3_Voina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> player1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> player2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 0;
        while (rounds < 50 && !player1.isEmpty() && !player2.isEmpty()) {
            int playerOne = player1.getFirst();
            player1.remove(playerOne);
            int playerTwo = player2.getFirst();
            player2.remove(playerTwo);

            if (playerOne > playerTwo) {
                player1.add(playerOne);
                player1.add(playerTwo);
            } else if (playerTwo > playerOne) {
                player2.add(playerOne);
                player2.add(playerTwo);
            }

            rounds++;
        }

        if (player1.size() == player2.size()) {
            System.out.println("Draw!");
        } else if (player1.size() > player2.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
