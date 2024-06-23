package Exercises.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _1_FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);
        int[][] matrix = new int[n][n];

        if (type == 'A') {
            fillMatrixByA(matrix);
            printMatrix(matrix);
        } else {
            fillMatrixByB(matrix);
            printMatrix(matrix);
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }

    private static void fillMatrixByB(int[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = ++value;
                }
            } else {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    matrix[j][i] = ++value;
                }
            }
        }
    }

    private static void fillMatrixByA(int[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = ++value;
            }
        }
    }
}
