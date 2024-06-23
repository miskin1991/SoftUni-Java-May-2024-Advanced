package Exams.Exam20240722;

import java.util.Scanner;

public class _2_Beesy {

    public static boolean hive = false;
    public static int energy = 15;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }

        int[] position = findStartingPosition(field);
        int nectar = 0;
        int rounds = 0;

        while (!hive && energy > 0 && rounds <= 2) {
            ++rounds;
            int collected = play(position, scanner, field);
            if (!hive && collected > 30) {
                energy = collected - 30;
                nectar = 30;
            } else {
                nectar += collected;
            }
        }

        if (hive && nectar >= 30) {
            System.out.printf("Great job, Beesy! The hive is full. Energy left: %d", energy);
        } else if (hive){
            System.out.print("Beesy did not manage to collect enough nectar.");
        } else {
            System.out.print("This is the end! Beesy ran out of energy.");
        }
        System.out.println();
        printField(field);

    }

    private static int play(int[] position, Scanner scanner, char[][] field) {
        int nectar = 0;
        while (energy > 0 && !hive) {
            assert position != null;
            String command = scanner.nextLine();
            move(command, position, field);
            energy--;
            char currentChar = field[position[0]][position[1]];
            if(Character.isDigit(currentChar)) {
                nectar += Character.getNumericValue(currentChar);
            } else if (currentChar == 'H') {
                hive = true;
            }
            field[position[0]][position[1]] = 'B';
        }
        return nectar;
    }

    private static void move(String command, int[] position, char[][] field) {
        field[position[0]][position[1]] = '-';
        switch (command) {
            case "up":
                position[0]--;
                break;
            case "down":
                position[0]++;
                break;
            case "left":
                position[1]--;
                break;
            case "right":
                position[1]++;
                break;
        }

        for (int i = 0; i < position.length; i++) {
            if (position[i] < 0) position[i] = field.length - 1;
            else if (position[i] >= field.length) position[i] = 0;
        }
    }

    private static int[] findStartingPosition(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'B') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static void printField(char[][] field) {
        for (char[] row : field) {
            System.out.println(row);
        }
        System.out.println();
    }
}
