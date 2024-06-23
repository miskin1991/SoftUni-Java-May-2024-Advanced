package Exercises.MultidimensionalArrays;

import java.util.*;

public class _6_StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().split("\\(")[1].split("\\)")[0]);
        Queue<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            queue.add(input);
            input = scanner.nextLine();
        }

        int rows = queue.size();
        int cols = Collections.max(queue, Comparator.comparing(String::length)).length();
        char[][] matrix = new char[rows][cols];
        for (char[] row : matrix) Arrays.fill(row, ' ');

        for (int i = 0; i < matrix.length && !queue.isEmpty(); i++) {
            int index = 0;
            String word = queue.poll();
            while (index < word.length()) {
                matrix[i][index] = word.charAt(index);
                index++;
            }
        }

        for (int times = 0; times < rotation / 90; times++) {
            matrix = rotate90(matrix);
        }

        printMatrix(matrix);
    }

    private static char[][] rotate90(char[][] matrix) {
        int newRows = matrix[0].length;
        int newCols = matrix.length;
        char[][] newMatrix = new char[newRows][newCols];
        for (int row = matrix.length - 1, index = 0; row >= 0 ; row--, index++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char current = matrix[row][col];
                newMatrix[col][index] = current;
            }
        }
        return newMatrix;
    }

    private static void printMatrix(char[][] newMatrix) {
        for (char[] row : newMatrix) {
            for (char element : row) {
                System.out.printf("%c", element);
            }
            System.out.println();
        }
        System.out.println();
    }
}
