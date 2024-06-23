package Labs.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _5_MaximumSumOf2x2Matrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readMatrix(scanner, dimensions[0], dimensions[1]);

        int sum = Integer.MIN_VALUE;
        int[][] sumMatrix = new int[2][2];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int[][] subMatrix = new int[][] {
                        {matrix[i][j], matrix[i][j + 1]}, {matrix[i+ 1][j], matrix[i + 1][j + 1]}
                };
                int subSum = getSum(subMatrix);
                if (subSum > sum) {
                    sum = subSum;
                    sumMatrix = subMatrix;
                }
            }
        }

        for (int[] row : sumMatrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
        System.out.println(sum);
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

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
