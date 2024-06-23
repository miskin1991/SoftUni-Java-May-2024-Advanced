package Exercises.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _4_MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int sum = Integer.MIN_VALUE;
        int[][] sumMatrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int[][] subMatrix = getSubMatrix(i, j, matrix);
                int mSum = getSum(subMatrix);
                if (sum < mSum) {
                    sum = mSum;
                    sumMatrix = subMatrix;
                }
            }

        }
        System.out.println("Sum = " + sum);
        printMatrix(sumMatrix);
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    private static int[][] getSubMatrix(int row, int col, int[][] matrix) {
        int[][] subMatrix = new int[3][3];
        if ((row + 2) < matrix.length && (col + 2) < matrix[0].length) {
            for (int i = 0; i < subMatrix.length; i++) {
                System.arraycopy(matrix[row + i], col, subMatrix[i], 0, subMatrix[i].length);
            }
        } else {
            for (int[] rows : subMatrix) {
                Arrays.fill(rows, Integer.MIN_VALUE);
            }
        }
        return subMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            Arrays.stream(row).forEach(element -> System.out.printf("%d ", element));
            System.out.println();
        }
    }
}
