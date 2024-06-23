package Exercises.MultidimensionalArrays;

import java.util.*;

public class _7_Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        fillMatrix(matrix);

        String command = scanner.nextLine();
        while (!"Nuke it from orbit".equals(command)) {
            String[] tokens = command.split(" ");
            int iRow = Integer.parseInt(tokens[0]);
            int iCol = Integer.parseInt(tokens[1]);
            int iRange = Integer.parseInt(tokens[2]);
            for (int i = iCol - iRange; i <= iCol + iRange; i++) {
                unsetCell(iRow, i, matrix);
            }
            for (int i = iRow - iRange; i < iRow + iRange; i++) {
                unsetCell(i, iCol, matrix);
            }
            copyMatrix(matrix);
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(int[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ++value;
            }
        }
    }

    private static void unsetCell(int row, int col, int[][] matrix) {
        if (withinMatrix(row, col, matrix)) {
            matrix[row][col] = 0;
        }
    }

    private static boolean withinMatrix(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cel : row) {
                System.out.printf("%d ", cel);
            }
            System.out.println();
        }
    }

    private static void copyMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i]).filter(value -> value != 0).toArray();
        }
    }
}
