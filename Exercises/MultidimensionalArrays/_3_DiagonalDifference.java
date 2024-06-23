package Exercises.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _3_DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int sumDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            sumDiagonal += matrix[i][i];
        }

        int sumReverseDiagonal = 0;
        for (int j = matrix.length - 1, i= 0; j >= 0 && i < matrix.length; i++, j--) {
            sumReverseDiagonal += matrix[i][j];
        }

        System.out.println(Math.abs(sumDiagonal - sumReverseDiagonal));
    }
}
