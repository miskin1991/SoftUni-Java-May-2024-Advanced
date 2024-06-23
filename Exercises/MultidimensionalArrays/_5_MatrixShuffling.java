package Exercises.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _5_MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimension[0]][dimension[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(" ");
            if (tokens.length != 5 || !tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if ((row1 < matrix.length && row2 < matrix.length)
                        && (row1 >= 0 && row2 >= 0)
                        && (col1 < matrix[0].length && col2 < matrix[0].length)
                        && (col1 >= 0 && col2 >= 0)) {
                    String aux = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = aux;
                    printMatrix(matrix);
                }
                else {
                    System.out.println("Invalid input!");
                }
            }
            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            Arrays.stream(row).forEach(element -> System.out.printf("%s ", element));
            System.out.println();
        }
    }
}
