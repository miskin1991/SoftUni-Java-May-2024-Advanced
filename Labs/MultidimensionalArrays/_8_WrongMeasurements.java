package Labs.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _8_WrongMeasurements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        // read the matrix from the console
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] wrongValuesPosition = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int row = wrongValuesPosition[0];
        int col = wrongValuesPosition[1];
        int wrongValue = matrix[row][col];

        int[][] copyMatrix = new int[matrix.length][];
        // copy matrix to correctMatrix
        for (int i = 0; i < matrix.length; i++) {
            copyMatrix[i] = matrix[i].clone();
        }


        // find all wrong values in the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    matrix[i][j] = getCorrectValue(copyMatrix, i, j, wrongValue);
                }
            }
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        // print the matrix in the console
        for (int[] matrixRow : matrix) {
            for (int cell : matrixRow) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int i, int j, int wrongValue) {
        int correctValue = 0;
        // check if value at left from wrongValue is different from wrongValue
        if (j - 1 >= 0 && matrix[i][j - 1] != wrongValue) {
            correctValue += matrix[i][j - 1];
        }
        // check if value at right from wrongValue is different from wrongValue
        if (j + 1 < matrix[i].length && matrix[i][j + 1] != wrongValue) {
            correctValue += matrix[i][j + 1];
        }
        // check if value at up from wrongValue is different from wrongValue
        if (i - 1 >= 0 && matrix[i - 1][j] != wrongValue) {
            correctValue += matrix[i - 1][j];
        }
        // check if value at down from wrongValue is different from wrongValue
        if (i + 1 < matrix.length && matrix[i + 1][j] != wrongValue) {
            correctValue += matrix[i + 1][j];
        }

        return correctValue;
    }
}
