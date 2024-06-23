package Exams.Exam20231021;

import java.util.Scanner;

public class _2_FishingCompetition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] fishingArea = new char[n][n];
        for (int i = 0; i < n; i++) {
            fishingArea[i] = scanner.nextLine().toCharArray();
        }

        int[] position = findStartingPosition(fishingArea);

        int score = 0;
        boolean sank = false;
        String command = scanner.nextLine();
        while (!"collect the nets".equals(command) && !sank) {
            assert position != null;
            move(command, position, fishingArea);
            char currentChar = fishingArea[position[0]][position[1]];
            if(Character.isDigit(currentChar)) {
                score += Character.getNumericValue(currentChar);
            } else if (currentChar == 'W') {
                sank = true;
                score = 0;
            }
            fishingArea[position[0]][position[1]] = 'S';
            command = scanner.nextLine();
        }

        if (score >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else if (!sank) {
            int lack = 20 - score;
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more" +
                    ".%n", lack);
        }

        if (score > 0) {
            System.out.printf("Amount of fish caught: %d tons.%n", score);
        }

        if (!sank) {
            printMatrix(fishingArea);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(row);
        }
        System.out.println();
    }

    private static void move(String command, int[] position, char[][] fishingArea) {
        fishingArea[position[0]][position[1]] = '-';
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
            if (position[i] < 0) position[i] = fishingArea.length - 1;
            else if (position[i] >= fishingArea.length) position[i] = 0;
        }
    }

    private static int[] findStartingPosition(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
