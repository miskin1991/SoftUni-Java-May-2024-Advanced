package Labs.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _3_IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] m1 = readMatrix(scanner, rows, cols);
        char[][] m2 = readMatrix(scanner, rows, cols);
        char[][] mOut = intersectMatrices(m1, m2);

        for (char[] chars : mOut) {
            for (char aChar : chars) {
                System.out.printf("%c ", aChar);
            }
            System.out.println();
        }

    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }

    private static char[][] intersectMatrices(char[][] m1, char[][] m2) {
        char[][] mOut = new char[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2 [i][j]) {
                    mOut[i][j] = '*';
                } else {
                    mOut[i][j] = m1[i][j];
                }
            }
        }
        return mOut;
    }
}
